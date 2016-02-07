<%-- 
    Document   : mensaje
    Created on : 01-nov-2009, 16:28:42
    Author     : Ing. Edeher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
    String vel=request.getParameter("vel");
    %>
        <META HTTP-EQUIV="Refresh" CONTENT="3; URL=<%=vel%>?val=MOS">
    </head>


    <body>
        <h1></h1>
                  Su Operacion se Realizo con Exito <a href='<%=vel%>?val=MOS'>Si no carga pulse aquí</a>
    </body>
</html>
