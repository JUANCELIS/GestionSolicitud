<%-- 
    Document   : registrarse
    Created on : 17/06/2021, 12:16:11 AM
    Author     : juand
--%>
<link href="../css/stilo.css" rel="stylesheet">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarme</title>
    </head>
    
    <body>
    <section class ="form-admin">    
        <h1>Formulario de registro</h1>
        <form action="nuevousuario" method="post">
            
            <label>Nombre: </label><br>
            <input  class="controles" type="text" name="nombre" /><br>
            <label>apellido</label><br>
            <input class="controles" type="text" name="apellido" /><br>
            <label>tipo documento</label><br>
            <input class="controles" type="text" name="tipodocumento" /><br>
            <label>documento</label><br>
            <input class="controles" type="number" name="documento" /><br>
            <label>correo</label><br>
            <input class="controles" type="email" name="correo" /><br>
            <label>contraseña</label><br>
            <input class="controles" type="password" name="clave" /><br>
            <br>
            <button class="boton" type="sumbit" value="registrarme">registrarme</button>
        </form>
     </section>    
    </body>
   
</html>
