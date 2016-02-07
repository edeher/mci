<%-- 
    Document   : demos
    Created on : 21-nov-2013, 12:18:39
    Author     : Ing. Edeher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/estylo.css">
    </head>
        <%
    
            cUsuario P=new cUsuario();
            cCelula c=new cCelula();
            cPersona per=new cPersona();
            
            int idPersona=0;
            int vidcelula=0;
            String vreferencia="";
            String vdireccion="";
            String diarealiza="";
            String horarealiza="";
            String feapertura="";
            String telcelula="";
            String tipcelula="";
            P=(cUsuario)request.getAttribute("objusu");

            System.out.println("se encontro");
             System.out.println("Ersona "+P.toString());
            System.out.println("entro al jsp");
            idPersona=P.getIdPersona();
            
            c.Buscarcelu(idPersona);
            vidcelula=c.getIdCelula();
            vreferencia=c.getReferencia();
            vdireccion=c.getDireccion();
            diarealiza=c.getDia_realiza();
            horarealiza=c.getHora_realiza();
            feapertura=c.getFecha_apertura();
            telcelula=c.getTelefono();
            tipcelula=c.getTip_celula();
            
            Vector vmiembros=per.Buscarmiembro(idPersona);
            System.out.println("se encontrado");
         if(per!=null){
             System.out.println("entrando al if");
             for(int i=0;i<vmiembros.size();i++ ){
                 System.out.println("entrando al for");
                     per=(cPersona)vmiembros.elementAt(i);
         System.out.println("se encontro en el jsp ");
         System.out.println("miembros "+per.toString3());
            
                    }}
    %>
    <body>
        <h1>todo ok!!</h1>
        <table border="1" width="392">
            <tr>
            <td>n° de celula</td>
            <td>direccion</td>
            <td>referencia</td>
            <td>dia que se realiza</td>
            <td>hora que se realiza</td>
            <td>fecha de apeertura</td>
            <td>telefono de celula</td>
            <td>tipo de celula</td>
            </tr>  
            <tr>
            <td><%=vidcelula%></td>
            <td><%=vdireccion%></td>
            <td><%=vreferencia%></td>
            <td><%=diarealiza%></td>
            <td><%=horarealiza%></td>
            <td><%=feapertura%></td>
            <td><%=telcelula%></td>
            <td><%=tipcelula%></td>
            </tr>  
        </table>
          
         <table width="392" border="1" class="TBorde">
              <tr class="TDetalle">
                  <td width="110"><div Aling="center">Codigo</div></td>
                  <td width="203"><div Aling="center">nombres</div></td>
                 
                  <td width="203"><div Aling="center">direccion </div></td>
                  <td width="203"><div align="center">edad</div> </td>
                  <td width="203"><div align="center">telefono</div> </td>
                 
                  <td width="203"><div align="center">tipo de miembro</div> </td>
              </tr>
              <%
              
               for(int i=0; i<vmiembros.size();i++)
              {
                   
                        per=(cPersona)vmiembros.elementAt(i);
                        
              %>
              <tr class="TRegistro" onmouseover="resaltar(this)" onmouseout="normal(this)">
                  <td><div align="center"><%=per.getIdPersona() %></div> </td>
                  <td><div align="center"><%=per.getNomcompleto() %></div> </td>
                  
                  <td><div align="center"><%=per.getDireccion() %></div> </td>
                  <td><div align="center"><%=per.getEdad() %></div> </td>
                  <td><div align="center"><%=per.getTelefono() %></div> </td>
                  
                  <td><div align="center"><%=per.getTipmiembro() %></div> </td>
                 
              </tr>
              <%}%>
          </table>

        
        
    </body>
</html>
