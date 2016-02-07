<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
</* global Calendar */

/* global Calendar */

%-- 
    Document   : frmPeriodo
    Created on : 20/04/2015, 02:18:49 PM
    Author     : Ing. Pool
--%>


<%@page import="Clases.*"%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <title>PERIODO</title>
        <SCRIPT LANGUAGE="JavaScript" SRC="CalendarPage/calendar.js"></SCRIPT>
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
        
        <link href="css/calendar-blue.css" rel="stylesheet" type="text/css"/>
        <script src="js/lang/calendar-en.js" type="text/javascript"></script>
        <script src="js/calendar.js" type="text/javascript"></script>
        <script src="js/calendar-setup.js" type="text/javascript"></script>
        
        <script language="javaScript">

            function verificar(f)
            {
                var falta = "";

                if (f.txtanio.value == "0") {
                    falta += "\t año \n ";
                }
                if (f.txtmes.value == "0") {
                    falta += "\t mes\n ";
                }

                if (f.txtsemana.value == "0") {
                    falta += "\t semana \n ";
                }
                if (f.txtfechaini.value == "") {
                    falta += "\t fecha de inicio \n ";
                }

                if (f.txtfechafin.value == "") {
                    falta += "\t fecha de fin \n ";

                }
                if (f.txttema1.value == "") {
                    falta += "\t tema 1 \n ";

                }
                if (f.txttema2.value == "") {
                    falta += "\t tema 2 \n ";

                }
                if (f.txtestado.value == "") {
                    falta += "\t estado \n ";

                }

                if (falta != "") {
                    alert("Ingrese :\n " + falta + " : de Periodo");
                    return false;
                }
                else {
                    if (f.vall.value == "NUE")
                    {
                        f.action = "sPeriodoMan?val=NUE";
                        f.target = "cuerpito";
                        f.submit();
                        f.reset();
                        return true;
                    }
                    else
                    {
                        f.action = "sPeriodoMan?val=MOD";
                        f.target = "cuerpito";
                        f.submit();
                        return true;
                    }
                }
            }

            function cerrarse()
            {
                window.close()
            }

        </script>

    </head>
    <%

        String val = request.getParameter("val");
        System.out.println(" entrando al frm con :" + val);

        String vcodigo = "Autogenerado";
        int vcodigo2 = 0;
        int vaño = 0;
        int vmes = 0;
        int vsemana = 0;
        String vfechaini="";
        String vfechafin="" ;
        String vtema1 = "";
        String vtema2 = "";
        String vestado = "";

        if (val.equals("MOD")) {
            System.out.println(" entrando al modificar :" + val);
            cPeriodo p = new cPeriodo();

            int vidPeriodo = Integer.parseInt(request.getParameter("vidPeriodo"));
            System.out.println(" recibiendo el codigo :" + vidPeriodo);
            p.Buscar54(vidPeriodo);

            System.out.println("se encontro");
            System.out.println("Invitado " + p.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ii:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:ii:ss");
            vcodigo2 = p.getIdPeriodo();
            vaño = p.getAño();
            vmes = p.getMes();
            vsemana = p.getSemana();
            vfechaini = sdf.format( p.getFechaini());
            vfechafin = sdf1.format(p.getFechafin());
            vtema1 = p.getTema1();
            vtema2 = p.getTema2();
            vestado = p.getEstado();

        }

    %>

    <body>
        <form name="f" method="post"  >
            <br><br>

            <table class="tablita">
                <tr class="celtitu">
                    <td>REGISTRAR PERIODO</td>
                </tr>
            </table>
            <BR>

            <table class="tablita" >

                <tr>
                    <td >Codigo : </td>
                <input type="hidden" name="vall" value="<%=val%>"> 
                <%if (val.equals("NUE")) {%>
                <td >
                    <input name="Codigo" type="text" value="<%=vcodigo%>" disabled="disabled"   >
                    <input type="hidden" name="txtcodigo" value="<%=vcodigo%>">
                </td>
                <%} else if (val.equals("MOD")) {%>
                <td >
                    <input name="Codigo" type="text" value="<%=vcodigo2%>" disabled="disabled"   >
                    <input type="hidden" name="txtcodigo" value="<%=vcodigo2%>">
                </td>
                <%}%>

                </tr>

                <tr>
                    <td >Año: </td>
                    <td>
                        <input type="text" name="txtanio" class="celdita1"value="<%=vaño%>" >

                    </td>
                </tr>
                <tr>
                    <td >mes: </td>
                    <td>
                        <input type="text" name="txtmes" class="celdita1"value="<%=vmes%>" >


                    </td>
                </tr>


                <tr>
                    <td >Semana : </td>
                    <td>
                        <input type="text" name="txtsemana" class="celdita1"value="<%=vsemana%>"  >

                </tr>
                <tr>
                    <td >fecha inicio :</td>
                    <td>
                        <input type="text" ID="txtfechaini" name="txtfechaini" class="celdita1"value="<%=vfechaini%>">
                        <a href="javascript:doNothing()" 
                           onClick="setDateField(document.f.txtfechaini);
                                   top.newWin = window.open('calendario.jsp', 'cal', 'dependent=yes,width=280,height=240,screenX=1100,screenY=300,titlebar=yes')"> 
                            <img src="CalendarPage/calendar.gif" border=0></a>


                    </td>
                </tr>

                <tr>
                    <td >fecha fin : </td>
                    <td>
                        <input type="text" name="txtfechafin" class="celdita1"value="<%=vfechafin%>">
                        <a href="javascript:doNothing()" 
                           onClick="setDateField(document.f.txtfechafin);
                                   top.newWin = window.open('calendario.jsp', 'cal', 'dependent=yes,width=280,height=240,screenX=1100,screenY=300,titlebar=yes')"> 
                            <img src="CalendarPage/calendar.gif" border=0></a>

                    </td>
                </tr>
                <tr>
                    <td >tema 1 :</td>
                    <td>
                        <input type="text" name="txttema1" class="celdita1"value="<%=vtema1%>"  >

                </tr>
                <tr>
                    <td >tema2 :</td>
                    <td>
                        <input type="text" name="txttema2" class="celdita1"value="<%=vtema2%>"  >


                </tr>
                <tr>
                    <td >estado : </td>
                    <td>
                        <input type="text" name="txtestado" class="celdita1"value="<%=vestado%>"  >


                </tr>

            </table>

            <BR>
            <table class="tablita">
                <tr >
                    <td >
                        <input type="button" value="Cerrar" class="BOTONCITO" onClick="cerrarse()">
                    </td>
                    <td >
                        <div align="right">
                          <input type="button" value="Grabar " class="BOTONCITO"onclick="verificar(this.form)"/>
                        </div>
                    </td>
                </tr>
            </table>

            <p>&nbsp;</p>

        </form>



    </body>

</html>