<%-- 
    Document   : numerocelulas
    Created on : 18-dic-2013, 11:18:07
    Author     : Ing. Edeher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Celulas</title>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
    </head>
     <%
     
     cCelula objC=new cCelula();
    // cCelula objc2=new cCelula();
     cCelula objc3=new cCelula();
    // Vector vCelula2=new Vector();
     Vector vCelula3=new Vector();
     cUsuario usu=new cUsuario();
     usu=(cUsuario)session.getAttribute("usu");
     cPersona per=new cPersona();
     per = (cPersona) request.getAttribute("per");
     
     if(per!=null)
     {
     System.out.println("llego PERSONA NRO "+per.toString());
     vCelula3=objc3.Buscarnroscelu2(per.getIdPersona());
     }
     else if(usu!=null)
     {
     System.out.println("llego USUARIO NRO "+usu.toString());
     vCelula3=objc3.Buscarnroscelu2(usu.getIdPersona());
     }
     %>
    <body>
        <table class="tablali">
            <tr class="celtitu">
                <td >Item </td>
                <td  >Codigo </td>
                <td  >Direccion </td>
                <td  >Tipo de Celula</td>
            </tr>
            <%
                for(int i=0;i<vCelula3.size();i++)
                {
                    objC=(cCelula)vCelula3.elementAt(i);
                     System.out.println(" celulas  "+objC.getIdCelula());
            %>
            <tr  onMouseOver="resaltar(this)" onMouseOut="normal(this)" >
                <td><div align="center"><%=i+1%></div></td>
                <td><a href="sCelula?vcodigo=<%=objC.getIdCelula() %>">
                  <div align="center"><%=objC.getIdCelula()%></div></td>
               <td><div align="center"><%=objC.getDireccion() %></div></td>
               <td><div align="center"><%=objC.getTipocelula() %></div></td>
               <%=usu.toString() %>
          </tr>
        <%}%>
        </table>
    </body>
</html>
