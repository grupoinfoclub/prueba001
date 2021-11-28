<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
</head>
<body>
  <h1>INSERTAR CLIENTE</h1>
   <!--  insertarCliente es el método de la interfaz -->
   <form:form action="insertarCliente" modelAttribute="cliente" method="POST">   
   <!--  para usarlo en la parte de modificar el registro ya que carga el id tambien al recuperar el registro-->  
     <form:hidden path="id"/>  
     <table border="1">
      <tr>
      <td>Nombre</td><td><form:input path="nombre" /></td>
      </tr>
      <tr>
     <td>Apellidos</td><td><form:input path="apellido" /></td>
     </tr>
     <tr>
     <td>Email</td><td><form:input path="email" /></td>
     </tr>
     <tr>
     <td colspan="2"><input type="submit" value="Insertar/Actualizar"></td>
     </tr>
  </table>
		
</form:form>

</body>
</html>


