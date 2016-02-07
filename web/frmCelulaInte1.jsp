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
        <title>Integrantes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <SCRIPT LANGUAGE="JavaScript" SRC="CalendarPage/calendar.js"></SCRIPT>
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
        <link href="css/calendar-blue.css" rel="stylesheet" type="text/css"/>
        <script src="js/calendar.js" type="text/javascript"></script>
        <script src="js/calendar-setup.js" type="text/javascript"></script>
        <script language="javaScript">
            function verificar(f)
            {
                var falta = "";

                if (f.txtnombres.value == "") {
                    falta += "\t Nombre \n ";
                }
                if (f.txtapepaterno.value == "") {
                    falta += "\t Apellido Paterno \n ";
                }
                if (f.txtapematerno.value == "") {
                    falta += "\t Apellido Materno \n ";
                }
                if (f.txtsexo.value == "") {
                    falta += "\t sexo \n ";
                }
                if (f.txtdireccion.value == "") {
                    falta += "\t direccion \n ";
                }
                if (f.txtreferencia.value == "") {
                    falta += "\t Referencia \n ";
                }
                if (f.txtfecha.value == "") {
                    falta += "\t fecha de nacimiento \n ";
                }
                if (f.txttelefono.value == "") {
                    falta += "\t telefono \n ";
                }
                if (f.cbotipodoc.value == "") {
                    falta += "\t tipo de documento de indentidad \n ";
                }
                else
                {
                    if (f.cbotipodoc.value == "DNI")
                    {
                        if (f.txtnrodni.value == "")
                        {
                            alert('falta el numero de Dni');
                        }
                        else
                        {
                            if (f.txtnrodni.value.length != 8)
                            {
                                alert('numero de Dni  Imcompleto');

                            }
                        }
                    }
                    else
                    {
                        if (f.txtnrodni.value == "")
                        {
                            alert('falta nro de carnet');
                        }
                        else
                        {
                            if (f.txtnrodni.value.length != 9)
                            {
                                alert('numero de carnet Imcompleto');

                            }
                        }
                    }

                }
                
                if (f.txtprofesion.value == "") {
                    falta += "\t profesion \n ";
                }
                if (f.cboestadocivil.value == "") {
                    falta += "\t estado civil \n ";
                }

                if (falta != "")
                {
                    alert("Ingrese :\n " + falta + " : de la Persona");
                    return false;
                }

                else
                {
                    f.action = "sCelulainte?val=NUE";
                    f.target = "";
                    f.submit();
                    return true;
                }

            }
            function CargaFrame(vas)
            {
                if (vas == "2") {
                    f.txtnombres.value = "";
                    f.txtapepaterno.value = "";
                    f.txtapematerno.value = "";
                    f.txtsexo.value = "";
                    f.txtdireccion.value = "";
                    f.txtreferencia.value = "";
                    f.txtfecha.value = "";
                    f.txttelefono.value = "";
                    f.cbotipodoc.value = "";
                    f.txtnrodni.value = "";
                    f.txtprofesion.value = "";
                    f.cboestadocivil.value="";
                    f.action = "sCelulainte?val=RECARGA";
                    f.target = "cuerpo";
                    f.submit();
                    true;
                } else {
                    return false;
                }
            }
            function cerrarse() {
                window.close();
            }
        </script>

    </head>
    <%
        String vRespuesta = request.getParameter("vRespuesta");
        if (vRespuesta == null) {
            vRespuesta = "noway";
        }

        String vel = "";
        vel = request.getParameter("vel");
        int vcodigocel = Integer.parseInt(request.getParameter("idcelula"));

        String vcodigo = "Autogenerado";
        String vnombres = "";
        String vapepaterno = "";
        String vapematerno = "";
        String vdireccion = "";
        String vreferencia = "";
       
        String vfecha = "";
        String vtelefono = "";
       
        String vnroidentidad = "";
        
        String vprofesion = "";
        String vobservacion = "";
        


    %>
    <body onload="CargaFrame('<%=vRespuesta%>')">
        <form name="f" method="post"  >

            <BR>
            <table class="tablita" >
                <tr class="celtitu">
                    <td>REGISTRAR NUEVO ASISTENTE </td>
                </tr>
            </table>

            <br>
            <table class="tablita" >

                <tr>
                    <td  >Codigo : </td>


                    <td >
                        <input name="Codigo" class="celdita" type="textcodigo" value="<%=vcodigo%>" disabled="disabled"  >
                        <input type="hidden" name="txtidcelula" value="<%=vcodigocel%>">
                        <input type="hidden" name="vel" value="<%=vel%>">
                    </td>


                </tr>
                <tr>
                    <td >NOMBRES: </td>
                    <td >
                        <input class="celdita" type="text" name="txtnombres" value="<%=vnombres%>"  >


                    </td>
                </tr>
                <tr>
                    <td >Apellido Paterno: </td>
                    <td>
                        <input class="celdita"type="text" name="txtapepaterno" value="<%=vapepaterno%>" >


                    </td>
                </tr>
                <tr>
                    <td >Apellido Materno: </td>
                    <td>
                        <input class="celdita" type="text" name="txtapematerno" value="<%=vapematerno%>"  >


                    </td>
                </tr>
                <tr>
                    <td >sexo: </td>

                    <td>
                       F <input type=radio value="f" name="txtsexo" >M <input type=radio value="m" name="txtsexo">


                    </td>
                </tr>

                <tr>
                    <td >Direccion: </td>
                    <td>
                        <input type="text" class="celdita"name="txtdireccion" value="<%=vdireccion%>"  >


                    </td>
                </tr>

                <tr>
                    <td >Referencia:</td>
                    <td>
                        <input type="text" class="celdita"name="txtreferencia" value="<%=vreferencia%>"  >


                    </td>
                </tr>
                <tr>
                    <td >fecha nacimiento: </td>
                    <td >
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
                <tr>
                    <td >Tipo de documento : </td>

                    <td><select class="celdita" name="cbotipodoc">
                            <option value="">-----</option>
                           
                            <option value="DNI">DNI</option>
                            <option value="CARNETEXTRA">CARNET DE EXTRANJERIA</option>
                                

                        </select>
                    </td>


                </tr>
                <tr>
                    <td >numero de identidad: </td>
                    <td>
                        <input class="celdita" type="text" name="txtnrodni" value="<%=vnroidentidad%>" >


                    </td>
                </tr>
               
                <tr>
                    <td >Profesion : </td>
                    <td>
                        <input type="text" class="celdita" name="txtprofesion" value="<%=vprofesion%>" >


                    </td>
                </tr>
                 <tr>
                    <td >Estado Civil : </td>

                    <td><select class="celdita" name="cboestadocivil">
                            <option value="">-----</option>
                           
                            <option value="s">Soltero</option>
                            <option value="c">Casado</option>
                             <option value="d">Divorciado</option>
                            <option value="k">Comviviente</option>
                            
                                

                        </select>
                    </td>


                </tr>
                <tr>
                    <td>observaciones : </td>
                    <td>


                        <textarea class="celbox" name="txtobservacion" value="<%=vobservacion%>" rows="9" cols="15"  ></textarea>


                    </td>

                </tr>

            </table>


            <br>
            <table class="tablita">
                <tr>
                    <td width="166">
                        <input type="button" value="Cerrar" class="BOTONCITO" onclick="cerrarse()">
                    </td>

                    <td width="122"></td>
                    <td width="96">
                        <input type="button"  value="Grabar " class="BOTONCITO" onclick="verificar(this.form)"/>
                    </td>
                </tr>
            </table>
          
            <% if (vRespuesta.equals("1")) {%>
            <table class="tablita">
            <tr class="celtitu"><td> ESTA PERSONA YA SE ENCUENTR REGISTRADA EN OTRA CELULA</td> </tr>
            <%}
            if (vRespuesta.equals("2")) {%>
            
            <tr class="celtitu"> <td>SE GRABO CORRECTAMENTE</td> </tr>
            <%}%>
            </table>
        </form>
    </body>

</html>