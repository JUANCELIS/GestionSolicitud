<%-- 
    Document   : validarUsuario
    Created on : 13/06/2021, 12:56:24 PM
    Author     : juand
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.UsuarioDAO"%>

<%
    String email= request.getParameter("email");
    String clav = request.getParameter("clave");

    UsuarioDAO user = new UsuarioDAO();
    ArrayList<Usuario> users = new ArrayList();
    users = user.read();
    boolean correcto = false;
    for (Usuario x : users) {
        if (x.getContra1().equals(clav) && x.getCorreo().equals(email)) {
            correcto = true;
            
        }
        
    }
%>
<% if(correcto){%>
<jsp:forward page="historialusuario.html"/>
<%}else{%>
<jsp:forward page="../../index.html"/>
<%}%>
