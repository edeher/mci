<%-- 
    Document   : manPersonas
    Created on : 30-ago-2013, 11:51:01
    Author     : Ing. Edeher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
        <script language="javaScript">
            
            function Ventana(f)
            {
                javascript:window.open('frmPersonas.jsp?val=NUE','','width=450,height=700,left=700,top=500,resizable=0,toolsbar=1,scrollbars=0');
                return true;
                
            }
            function Ventana2(f,vidPersona)
            {
                javascript:window.open('frmPersonas.jsp?val=MOD&vidPersona='+vidPersona,'','width=450,height=700,left=700,top=500,resizable=0,toolsbar=1,scrollbars=0');
               
                
            }
            function pregunta()
            {
                if(confirm("seguro que desea eliminar Persona")==true)return true;
                return false;
            }
            function Mostrar(f)
            {
                f.action="sPersonaMan?val=MOS";
                f.submit();
                return true;
            }
            function Nuevo(f)
            {
                f.action="sPersonaMan?val=N";
                f.submit();
                return true;
            }
            function Buscar(f)
            {
                if(f.txtNombre.value=="")
                    {
                        alert("ingrese nombre de la persona")
                        return false;
                    }
                    f.action="sPersonaMan?val=BUS";
                    f.submit();
                    return true;
            }

            var anterior="";
          function resaltar(obj)
          {
            if (anterior != obj)
            obj.style.backgroundColor='#FFFFEC';
          }
          function normal(obj)
          {
            if (anterior != obj)
            obj.style.backgroundColor='#FFFFFF';
          }
        </script>

    </head>
    <%
     String val=request.getParameter("val");
      String  vRespuesta=request.getParameter("vRespuesta");
         if(vRespuesta==null){vRespuesta="noway";}
        cPersona objPr=new  cPersona();
        
        Vector vPersona=new Vector();
        
      
        vPersona=(Vector)request.getAttribute("vPersona");
        
    %>
    <body><center>
        <form name="f" method="POST">
            <br> <br>
            <table class="tablali">
            <tr class="celtitu">
                <td>LISTA DE PERSONAS</td>
            </tr>
          </table>
          <br>
          
          <table class="tablita">
            <tr>
                <td >Buscar/Nombre : </td>
                <td > 
                                                <input type="text" size="30" name="txtNombre">
                                                </td>
                <td >
                        <input type="button" value="Buscar" class="BOTONCITOS" onclick="Buscar(this.form)" >
                                              </td>
                <td >&nbsp; </td>
                <td >
                        <input type="button" value="Nuevo" class="BOTONCITOS" onclick="Ventana(this.form)" >
                                             </td>
                <td >
                                               <input type="button" value="Mostrar Todo" class="BOTONCITOS" onclick="Mostrar(this.form)">
                                               </td>
            </tr>
         </table >
          <br>
          <table class="tablita">
              <tr class="celtitu">
                  <td >Codigo</td>
                  <td >nombres</td>
                  <td >apellido 1</td>
                  <td >apellido 2</td>
                  <td >direccion </td>
                  <td >edad </td>
                  <td >telefono </td>
                  <td >tipodoc </td>
                  <td >numero de dni</td>
                  <td >tipo </td>
                  <td >profesion </td>
                  <td >observaciones </td>
                   <td colspan="2"> Opcion </td>
              </tr>
              <%
                for(int i=0;i<vPersona.size();i++)
                    {
                    System.out.println("entrando al for de jsp");
                     objPr=(cPersona)vPersona.elementAt(i);
                     System.out.println("se encontro");
                     System.out.println("codigo "+objPr.toString());
                     
                        objPr=(cPersona)vPersona.elementAt(i);
                        int vidPersona=objPr.getIdPersona();
              %>
              <tr  >
                  <td><%=objPr.getIdPersona() %> </td>
                  <td><%=objPr.getNombres() %> </td>
                  <td><%=objPr.getApe_paterno() %> </td>
                  <td><%=objPr.getApe_materno() %> </td>
                  <td><%=objPr.getDireccion() %> </td>
                  <td><%=objPr.getEdad() %> </td>
                  <td><%=objPr.getTelefono() %> </td>
                  <td><%=objPr.getTipodoc()%> </td>
                  <td><%=objPr.getNro_identidad() %> </td>
                  <td><%=objPr.getTipoper()%> </td>
                  <td><%=objPr.getProfesion() %></td>
                  <td><%=objPr.getObservaciones()%></td>
                  
                  <td width="16"><a href="javascript:Ventana2(this.form,'<%=vidPersona%>')">
                           <img src="imganes/modificar.gif" width="25" height="25" alt="Modificar" border="0"/>
                          </a> </td>
                  <td width="32"><a href="sPersonas?val=E&vcodigo=<%=objPr.getIdPersona()%>">
                          <img src="imganes/Eliminar.gif" width="25" height="25" alt="Eliminar" border="0" onclick="return pregunta()"/>
                                  </a> </td>
              </tr>
              <%}%>
          </table>
           <%if(vRespuesta.equals("2")){%>
                  <span class="Estilo1">SE GRABO CORRECTAMENTE<img src="imganes/yes.png"/></span>
        <%}%>
        </form>
        </center>
    </body>
</html>
