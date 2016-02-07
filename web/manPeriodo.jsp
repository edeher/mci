<%-- 
    Document   : manPeriodo
    Created on : 20/04/2015, 02:18:27 PM
    Author     : Ing. Pool
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Periodos</title>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
        <script language="javaScript">
            function Ventana(f)
            {
                javascript:window.open('frmPeriodo.jsp?val=NUE','','width=550,height=520,left=700,top=200,resizable=0,toolsbar=1,scrollbars=0');
                return true;
                
            }
            function Ventana2(f,vidPeriodo)
            {
                javascript:window.open('frmPeriodo.jsp?val=MOD&vidPeriodo='+vidPeriodo,'','width=550,height=520,left=700,top=200,resizable=0,toolsbar=1,scrollbars=0');
               
                
            }
            function pregunta()
            {
                if(confirm("seguro que desea eliminar Miembro")==true)return true;
                return false;
            }
            function Mostrar(f)
            {
                f.action="sPeriodoMan?val=MOS";
                f.submit();
                return true;
            }
            function Mostrar2(f)
            {
                f.action="sPeriodoMan?val=MOS1";
                f.submit();
                return true;
            }
            function Buscar(f)
            {
                if(f.txtid.value=="")
                    {
                        alert("ingrese codigo del Miembro")
                        return false;
                    }
                    f.action="sPeriodoMan?val=BUS";
                    f.submit();
                    return true;
            }
         function Buscar1(f)
            {
                var falta="";
                if(f.txtmes.value=="")
                    {
                        falta+="\t mes\n ";
                        
                    }
                 if(f.txtsemana.value=="")  
                    {
                        falta+="\t semana\n ";
                    }
                 
                if(falta!="")
                {
                alert("Ingrese :\n "+ falta + " : de Miembro");
                return false;
                }
                else
                {  
                    f.action="sPeriodoMan?val=BUS1";
                    f.submit();
                    return true;
                }
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
        cPeriodo objPeri=new  cPeriodo();
        
        Vector vPeriodo=new Vector();
        
      vPeriodo=(Vector)request.getAttribute("vPeriodo");
        //vPeriodo=(Vector)request.getAttribute("vPerido");
        
    %>
    <body><center>
        <form name="f" method="POST">
            <br> <br>
            <table class="tablita">
                <tr class="celtitu">
                <td>LISTA DE Periodo</td>
            </tr>
          </table>
          <br>
	  <table class="tablita">
           
            <td>
                <td  >Buscar/ Tipo : </td>
                <td >
                                                <input type="text" size="30" name="txtmes">
                                                </td>
                <td >
                                                <input type="text" size="30" name="txtsemana">
                                                </td>
                <td >
                    <input type="button" value="Buscar" class="BOTONCITOS" onclick="Buscar1(this.form)" >
                                              </td>
                <td >&nbsp; </td>
                
                
            </td>
            <td>
                
                <td >&nbsp; </td>
                <td >
                        <input type="button" value="Nuevo" class="BOTONCITOS" onclick="Ventana(this.form)" >
                                              </td>
                <td >
                                               <input type="button" value="Mostrar Todo" class="BOTONCITOS" onclick="Mostrar(this.form)">
                                              </td>
                <td >
                                               <input type="button" value="Mostrar Actuales" class="BOTONCITOS" onclick="Mostrar2(this.form)">
                                               </td>                               
            </td>
         </table>
          <br>
          <table class="tablita">
              <tr class="celtitu">
                  <td width="112" >Codigo</td>
                  <td width="64" >Año</td>
                  <td width="67" >Mes</td>
                  <td width="130" >Semana</td>
                  <td width="159" >Fecha de Iniio</td>
                  <td width="146" >Fecha de Fin </td>
                  <td width="209" >Tema 1 </td>
                  <td width="189" >Tema 2 </td>
                  <td width="116">Estado </td>
                 
                   <td colspan="2"> Opcion </td>
              </tr>
              <%
                for(int i=0;i<vPeriodo.size();i++)
                    {
                    System.out.println("entrando al for de jsp segundaparte");
                     objPeri=(cPeriodo)vPeriodo.elementAt(i);
                     System.out.println("se encontro");
                     System.out.println("codigo "+objPeri.toString());
                     
                        objPeri=(cPeriodo)vPeriodo.elementAt(i);
                        int vidPeriodo=objPeri.getIdPeriodo();
              %>
              <tr >
                  <td><div align="center"><%=objPeri.getIdPeriodo() %> </div></td>
                  <td><div align="center"><%=objPeri.getAño() %> </div></td>
                  <td><div align="center"><%=objPeri.getMes() %> </div></td>
                  <td><div align="center"><%=objPeri.getSemana() %> </div></td>
                  <td><div align="center"><%=objPeri.getFechaini() %> </div></td>
                  <td><div align="center"><%=objPeri.getFechafin() %> </div></td>
                 <td><%=objPeri.getTema1() %> </td>
                  <td><%=objPeri.getTema2() %> </td>
                  <td><div align="center"><%=objPeri.getEstado() %> </div></td>
                  
                  <td width="23"><div align="center"><a href="javascript:Ventana2(this.form,'<%=vidPeriodo%>')">
                              <img src="imganes/modificar.gif" width="25" height="25" alt="Modificar" border="0"/>
                          </a></div> </td>
                  <td width="37"><div align="center"><a href="sMiembro?val=E&vcodigo=<%=objPeri.getIdPeriodo()%>">
           <img src="imganes/Eliminar.gif" width="25" height="25" alt="Eliminar" border="0" onclick="return pregunta()"/>
                                  </a></div> </td>
              </tr>
              <%}%>
          </table>
        </form>
        </center>
    </body>
</html>
