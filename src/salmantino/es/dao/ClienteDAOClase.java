package salmantino.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import salmantino.es.controlador.entity.Cliente;

@Repository
public class ClienteDAOClase implements ClienteDAO {

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		
		Session miSession=sessionFactory.getCurrentSession();
		Query<Cliente> miQuery=miSession.createQuery("from Cliente",Cliente.class);
		List<Cliente> clientes=miQuery.getResultList();
		return clientes;
	}
@Autowired
	private SessionFactory sessionFactory;

@Override
@Transactional
public void insertarCliente(Cliente elCliente) {
	Session miSession=sessionFactory.getCurrentSession();
	//miSession.save(elCliente);   este solo vale para insertar
	miSession.saveOrUpdate(elCliente); //sirve para actualizar o insertar se adapta
	
}

//proporciona el cliente pasado por la url para modificar el seleccionado
@Override
@Transactional
public Cliente getCliente(int id) {
	//tarea obtener la sesión
	Session miSession=sessionFactory.getCurrentSession();
	//obtener la información del cliente seleccionado
	Cliente elCliente=miSession.get(Cliente.class, id);
	// devuelve el cliente
	return elCliente;
}

@Override
@Transactional
public void eliminarCliente(int id) {
	
	//tarea obtener la sesión
	Session miSession=sessionFactory.getCurrentSession();
	//eliminar el registro de la BBDD con su id correspondiente
	//cñodigo ORM para borrar
	Query consulta=miSession.createQuery("delete from Cliente where id=:IdDelCliente");
	consulta.setParameter("IdDelCliente",id);
	consulta.executeUpdate();  //ejecuta ésta actualización
}




}
