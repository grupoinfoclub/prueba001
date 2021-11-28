<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
</head>
<body>
<h1>Bienvenidos al Proyecto</h1>

<table border="1">
  <tr>
    <td>Nombre</td>
    <td>Apellidos</td>
    <td>Email</td>
    <td>Modificar</td>
    <td>Eliminar</td>
 </tr>

  <c:forEach var="clienteTemp"  items="${clientes}">

     <!--  link para actualizar  -->
     <c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">  <!-- nos lleva a la url al modificar-->
     <c:param name="clienteId" value="${clienteTemp.id}"/>   <!--  el parámetro que le pasamos a la url -->
    </c:url>
    
     <!--  link para eliminar  -->
     <c:url var="linkEliminar" value="/cliente/eliminar">  <!-- nos lleva a la url eliminar-->
     <c:param name="clienteId" value="${clienteTemp.id}"/>   <!--  el parámetro que le pasamos a la url -->
    </c:url>
    
  <tr>
      <td>${clienteTemp.nombre}</td>
      <td>${clienteTemp.apellido}</td>
      <td>${clienteTemp.email}</td>
      <td><a href="${linkActualizar}"><input type="button" value="Modificar"/></a></td>
      <td><a href="${linkEliminar}"><input type="button" value="Eliminar"  
             onclick="if(!(confirm('vas a eliminar un registro. Estás seguro?')))  return false;"/></a></td>
  </tr>
</c:forEach>
</table>

<br>
<center>
<input type="button" value="Agregar Cliente" onclick="window.location.href='muestraFormularioAgregar'; return false;"/>
</center>
</body>
</html>