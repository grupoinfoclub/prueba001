package salmantino.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import salmantino.es.controlador.entity.Cliente;
import salmantino.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {

	// TODOS LOS MAPEOS DE LAS URL
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		List<Cliente> losClientes=clienteDAO.getClientes();
		elModelo.addAttribute("clientes",losClientes);
		return "lista-clientes";
	}
	
	@RequestMapping("/muestraFormularioAgregar")  //la url del <input type>
	public String muestraFormularioAgregar(Model elModelo) {
		//bind de datos de los clientes
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente",elCliente);
		//devuelve el formulario cliente
		return "formularioCliente";
	}
	
	//el formulario es post porque al inseertar usamos el post del formulario
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente ) //le pasamos el atributo cliente del ModelAtribute del form de la vista formularioCliente 
	{
		//insertar el cliente en la BBDD
		clienteDAO.insertarCliente(elCliente);
		return "redirect:/cliente/lista";
	}
	
	//el id que viaje con el formulario es get  usamos el mismo formulario para altas y modificaciones
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int Id,Model elModelo) //le pasamos el atributo cliente del ModelAtribute del form de la vista formularioCliente 
	{
		//tareas a realizar
		// primero obtener el cliente
		Cliente elCliente=clienteDAO.getCliente(Id); 
		//segundo establecer el cliente como atributo del modelo
		elModelo.addAttribute("cliente",elCliente);
		//tercero enviar al formulario
		
		return "formularioCliente";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int Id) //le pasamos el atributo cliente del ModelAtribute del form de la vista formularioCliente 
	{
		//tareas a realizar
		
		// primero obtener el cliente y eliminarlo
		clienteDAO.eliminarCliente(Id); 
		
		//segundo redireccionar 
		return "redirect:/cliente/lista";
	}
	
	
	
	@Autowired
	private ClienteDAO clienteDAO;
}
