<%-- 
    Document   : frmProducto
    Created on : 22/11/2010, 09:40:36 AM
    Author     : Edeher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body><title>Persona</title>
    <SCRIPT LANGUAGE="JavaScript" SRC="CalendarPage/calendar.js"></SCRIPT>
    <link href="css/style2.css" rel="stylesheet" type="text/css"/>
    <script language="javaScript">

        function verificar(f)
        {
            var falta = "";

            if (f.txtnombres.value == "")
            {
                falta += "\t Nombre \n ";
            }
            if (f.txtapepaterno.value == "")
            {
                falta += "\t Apellido Paterno \n ";
            }
            if (f.txtapematerno.value == "")
            {
                falta += "\t Apellido Materno \n ";
            }

            if (f.txtreferencia.value == "")
            {
                falta += "\t Referencia \n ";
            }
            if (f.txtdia.value == "---")
            {
                falta += "\t dia \n ";
            }
            if (f.txtmes.value == "---")
            {
                falta += "\t mes \n ";
            }
            if (f.txtano.value == "---")
            {
                falta += "\t año \n ";
            }
            if (f.txttelefono.value == "")
            {
                falta += "\t telefono \n ";
            }

            if (falta != "")
            {
                alert("Ingrese :\n " + falta + " : del Invitado Nuevo");
                return false;
            }
            else
            {
                 f.action = "sCelulainvi?val=NUE";
                    f.target = "";
                    f.submit();
                    return true;
            }


        }
        function cerrarse()
        {
            window.close()
        }


        function graba()
        {

            window.opener.location.reload();

        }

    </script>

</head>
<%
    int vcodigocel = Integer.parseInt(request.getParameter("idcelula"));
    int vperiodo= Integer.parseInt(request.getParameter("idperiodo"));
    String vcodigo = "Autogenerado";
    String vnombres = "";
    String vapepaterno = "";
    String vapematerno = "";
    String vdireccion = "";
    String vreferencia = "";
    int vedad = 0;
    String vfecha = "";
    String vtelefono = "";
   System.out.println(" celula =:" + vcodigocel+", periodo="+vperiodo);

%>
<body>
    <form name="f" method="post"   >
        <br><br>
      
        <table class="tablita">
                <tr class="celtitu">
                    <td>REGISTRAR NUEVO INVITADO</td>
                </tr>
            </table>
            <BR>

            
                        <table class="tablita" >
                            <tr>
                                <td >Codigo : </td>


                                <td >
                                        <input name="Codigo" type="textcodigo" class="celdita"value="<%=vcodigo%>" disabled="disabled"   >
                                        <input type="hidden" name="txtidcelula"class="celdita" value="<%=vcodigocel%>">
                                         <input type="hidden" name="txtidperiodo" class="celdita"value="<%=vperiodo%>">
                                    </td>


                            </tr>
                            <tr>
                                <td class="TDetalle"><div align="right">NOMBRES: </div></td>
                                <td>
                                        <input type="text" name="txtnombres" class="celdita"value="<%=vnombres%>"  >

                                    
                                </td>
                            </tr>
                            <tr>
                                <td >Apellido Paterno: </td>
                                <td><div align="left">
                                        <input type="text" name="txtapepaterno" class="celdita"value="<%=vapepaterno%>"  >

                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >Apellido Materno: </td>
                                <td>
                                        <input type="text" name="txtapematerno" class="celdita"value="<%=vapematerno%>"  >

                                    
                                </td>
                            </tr>
                            <td >sexo: </td>

                            <td>
                                    V <input type=radio value="v" name="txtsexo" >M <input type=radio value="m" name="txtsexo">

                                
                            </td>
                            <tr>
                                <td >Direccion: </td>
                                <td>
                                        <input type="text" name="txtdireccion" class="celdita"value="<%=vdireccion%>"  >

                                    
                                </td>
                            </tr>

                            <tr>
                                <td >Referencia: </td>
                                <td>
                                        <input type="text" name="txtreferencia" class="celdita"value="<%=vreferencia%>" >

                                   
                                </td>
                            </tr>
                            <tr>
                                <td >fecha nacimiento: </td>
                                <td>
                                    <input type="text" class="celdita2" name="txtfecha" value="<%=vfecha%>">
                        <a href="javascript:doNothing()" 
                           onClick="setDateField(document.f.txtfecha);
                                   top.newWin = window.open('calendario.jsp', 'cal', 'dependent=yes,width=230,height=240,screenX=200,screenY=300,titlebar=yes')"> 
                            <img src="CalendarPage/calendar.gif" border=0></a>
                                </td>

                            </tr>
                            <tr>
                                <td >Tefelefono: </td>
                                <td>
                                      
                                                 <input type="text" class="celdita"name="txttelefono" value="<%=vtelefono%>" >
                                   
                                </td>
                            </tr>

                        </table>
                        <BR>
                        <table class="tablita">
                            <tr >
                                <td width="161"><div align="left">
                                        <input type="button" value="Cerrar" class="BOTONCITO" onclick="cerrarse()">
                                    </div></td>
                                <td width="160" >
                                        <input type="button" value="Grabar " class="BOTONCITO"onclick="verificar(this.form), graba()"/>

                                    </td>
                            </tr>
                        </table>
                        <p>&nbsp;</p>
                      
                        </form>




                        </body>

                        </html>