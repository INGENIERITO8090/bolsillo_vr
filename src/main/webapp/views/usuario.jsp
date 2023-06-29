<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title> 

    
    List<usuarios> usuarios=(List<usuarios>)request.getAttribute("usuarios.getIdUsuario()"); %> </p>
</head>
<body>
    <p><%=request.getAttribute("usuarios")%></p>
    <table class="table table-hover table-bordered"> 
        <tr>
            <th>Id</th>
            <th>N_documento</th>
            <th>NombreUsuario</th>
            <th>ContraseñaUsuario</th>
            <th>NumeroCelularUsuario</th>
            <th><center>Estado</center></th>            
            <th colspan="2"><center>Acciones</center></th>
        </tr>       
<c:forEach var="usuario" items="${usuarios}">         
        <tr>
        <td>${usuario.getIdUsuario()}</td>
        <td>${usuario.getN_documento()}</td>
        <td>${usuario.getNombreUsuario()}</td>
        <td>${usuario.getConstrasenaUsuario()}</td>
        <td>${usuario.getNumeroCelularUsuario()}</td>
        <td>${usuario.getEstadoUsuario()}</td> 
        
     	<!--<c:if test="${usuario.getEstadoUsuario() == true}">
           <td><span class="badge bg-success active">usuario Activo</span></td> 
        </c:if>
        <c:if test="${usuario.getEstadoUsuario() == false}">
            <td><span class="badge bg-danger active">usuario Inactivo</span></td> 
        </c:if>
        
        <td>
        <c:if test="${usuario.getEstadoUsuario() == true}">
           <a usuario="button" 
           class="btn btn-danger btn-sm" 
           onclick=""> 
        Inactivar
        </a>
        </c:if>
        <c:if test="${usuario.getEstadoUsuario() == false}">
            <a usuario="button" 
            class="btn btn-success btn-sm" 
          >
        Activar
        </a>
        </c:if> 
        </td>
        
        
        <td>
        <a usurio="button" 
        class="btn btn-warning" 
        href="">
        <i class="bi bi-pencil"></i> 
        </a>

	    <a usurio="button" 
	    class="btn btn-danger" 
	    onclick="">
	    <i class="bi bi-trash"></i> 
	    </a>
	    
	    </td>
        <tr>
        -->
</c:forEach>    


</table>

</body>
</html>