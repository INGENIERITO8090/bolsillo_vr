<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<html>

<body>
<h2>Hello World!</h2>
<div class="contenedor ">
    
 <form action="usuario" method="post"> 
     
    <input type="number"  name="N_documento">
    <input type="text" name="NombreUsuario">
    <input type="text" name="ContrasenaUsuario">
   <input type="number" name = "NumeroCelularUsuario"> 
   <input type="checkbox" name="EstadoUsuario" >
    <button type="submit" name="accion" value="registrar">    
   </button> 


<span><a href="usuario?accion=listar"> listar</a>     </span>

 </form>

</div>
</body>
</html>
