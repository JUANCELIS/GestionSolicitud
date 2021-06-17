<%-- 
    Document   : validarUsuario
    Created on : 13/06/2021, 12:56:24 PM
    Author     : juand
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.UsuarioDAO"%>

<%
    String email = request.getParameter("email");
    String clave = request.getParameter("clave");

    System.out.println("email" + email + "clave" + clave);

    UsuarioDAO user = new UsuarioDAO();
    ArrayList<Usuario> users = new ArrayList();
    users = user.read();
    boolean correcto = false;
    for (Usuario x : users) {
        if (x.getContra1().equals(clave) && x.getCorreo().equals(email)) {
            correcto = true;
            

        }

    }
%>


<% if (correcto) {
    System.out.println("correcto " + email );
        if (email.equals("juandiegocbl@ufps.edu.co") ){%>
       <jsp:forward page="historialadministrador.jsp"/>
         <%} else {%>
       <jsp:forward page="historialusuario.html"/>
       <% }%>
<%} else{%>
<jsp:forward page="../../index.html"/>
<%}%>
