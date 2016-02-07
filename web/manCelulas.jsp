<%-- 
    Document   : manCelulas
    Created on : 10/03/2014, 10:54:29 AM
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
        <title>Celulas</title>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
        <script language="javaScript">
            function Ventana(f)
            {
                javascript:window.open('frmCelulas.jsp?val=NUE','','width=550,height=570,left=700,top=200,resizable=0,toolsbar=1,scrollbars=0');
                return true;
                
            }
            function Ventana2(f,vidCelula)
            {
                javascript:window.open('frmCelulas.jsp?val=MOD&vidCelula='+vidCelula,'','width=550,height=570,left=700,top=200,resizable=0,toolsbar=1,scrollbars=0');
               
                
            }
            function pregunta()
            {
                if(confirm("seguro que desea eliminar la Celula")==true)return true;
                return false;
            }
            function Mostrar(f)
            {
                f.action="sCelulaMan?val=MOS";
                f.submit();
                return true;
            }
            
            function Buscar(f)
            {
                if(f.txtNombre.value=="")
                    {
                        alert("ingrese direccion ")
                        return false;
                    }
                    f.action="sCelulaMan?val=BUS";
                    f.submit();
                    return true;
            }
            function Buscar1(f)
            {
                if(f.txtid.value=="")
                    {
                        alert("ingrese idCelula ")
                        return false;
                    }
                    f.action="sCelulaMan?val=BUS1";
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
         
        cCelula objcel=new cCelula();
        
        Vector vCelula=new Vector();
        
      
        vCelula=(Vector)request.getAttribute("vCelula");
        
    %>
    <body><center>
        <form name="f" method="POST">
            <br> <br>
            <table class="tablita">
                <tr class="celtitu">
                <td>LISTA DE CELULAS</td>
            </tr>
          </table>
          <br>
	  <table class="tablita" >
            <tr>
                <td  >Buscar/Direccion : </td>
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
             <tr>
                <td  >Buscar/idCelula : </td>
                <td > 
                                                <input type="text" size="30" name="txtid">
                                                </td>
                <td >
                        <input type="button" value="Buscar" class="BOTONCITOS" onclick="Buscar1(this.form)" >
                                              </td>
                <td >&nbsp; </td>
                
                
            </tr>
         </table>
          <br>
          <table class="tablita">
              <tr class="celtitu" >
                  <td width="36" >Codigo</td>
                  <td width="443" >direccion</td>
                  <td width="99" >Lider</td>
                  <td width="15" >dia</td>
                  <td width="60" >hora</td>
                  <td width="109" >fecha de apertura</td>
                  <td width="59" >telefono </td>
                  <td width="131" >tipo de celula </td>
                  <td width="78" >red </td>
                  <td width="137" >estado </td>
                  <td colspan="2"> Opcion </td>
              </tr>
              <%
                for(int i=0;i<vCelula.size();i++)
                    {
                    System.out.println("entrando al for de jsp");
                     objcel=(cCelula)vCelula.elementAt(i);
                     System.out.println("se encontro");
                     System.out.println("codigo "+objcel.toString());
                     
                        objcel=(cCelula)vCelula.elementAt(i);
                        int vidCelula=objcel.getIdCelula();
              %>
              <tr >
                  <td><div align="center"><%=objcel.getIdCelula() %> </div></td>
                  <td><%=objcel.getDireccion()%> </td>
                  <td><%=objcel.getLider() %> </td>
                  <td><div align="center"><%=objcel.getDia_realiza()%> </div></td>
                  <td><div align="center"><%=objcel.getHora_realiza()%> </div></td>
                  <td><div align="center"><%=objcel.getFecha_apertura()%> </div></td>
                  <td><div align="center"><%=objcel.getTelefono() %> </div></td>
                  <td><div align="center"><%=objcel.getTip_celula()%> </div></td>
                  <td><div align="center"><%=objcel.getRed()%> </div></td>
                  <td><div align="center"><%=objcel.getEstado()%> </div></td>
                 
                  
                  <td width="30"><div align="center"><a href="javascript:Ventana2(this.form,'<%=vidCelula%>')">
                              <img src="imganes/modificar.gif" width="25" height="25" alt="Modificar" border="0"/>
                          </a></div> </td>
                  <td width="51"><div align="center"><a href="sCelulaMan?val=E&vcodigo=<%=objcel.getIdCelula()%>">
                              <img src="imganes/Eliminar.gif" width="25" height="25" alt="Eliminar" border="0" onclick="return pregunta()"/>
                                  </a></div> </td>
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
