<%-- 
    Document   : frmCelulas
    Created on : 10/03/2014, 03:08:26 PM
    Author     : Ing. Edeher
--%>

<%@page import="Clases.*"%>

<%@page import="java.util.Vector"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>celulas</title>
    </head>
  <SCRIPT LANGUAGE="JavaScript" SRC="CalendarPage/calendar.js"></SCRIPT>
    <link href="css/style2.css" rel="stylesheet" type="text/css"/>
    <title>Celula</title>

    <script language="javaScript">

        function verificar(f)
        {
            var falta = "";

            if (f.cbotipocel.value == "") {
                falta += "\t tipo de celula \n ";
            }
            if (f.txtdireccion.value == "") {
                falta += "\t direccion\n ";
            }

            if (f.txtreferencia.value == "") {
                falta += "\t referencia \n ";
            }
            if (f.cbolider.value == "") {
                falta += "\t lider \n ";
            }
            if (f.txtdiarea.value == "---") {
                falta += "\t dia de realizacion \n ";
            }
            if (f.txthora.value == "---")
            {
                falta += "\t hora \n ";
            }
            if (f.txtmin.value == "---")
            {
                falta += "\t minutos \n ";
            }
            if (f.txtpm.value == "---")
            {
                falta += "\t itinerario \n ";
            }
            if (f.txtfechaape.value == "---")
            {
                falta += "\t fecha \n ";
            }
            if (f.txttelefono.value == "") {
                falta += "\t telefono \n ";
            }
            if (f.cbotipored.value == "") {
                falta += "\t red \n ";

            }
            
            if (falta != "") {
                alert("Ingrese :\n " + falta + " : de la celula");
                return false;
            }
            else
            {
                if (f.vall.value == "NUE")
                {
                    f.action = "sCelulaMan?val=NUE";
                    f.target = "";
                    f.submit();
                    f.reset();
                    return true;
                }
                else
                {
                    f.action = "sCelulaMan?val=MOD";
                    f.target = "";
                    f.submit();
                    return true;
                }

            }
        }
            function CargaFrame(vas)
            {
                if (vas == "2") {
                   
                    f.action = "sCelulaMan?val=RECARGA";
                    f.target = "cuerpito";
                    f.submit();
                    true;
                } else {
                    return false;
                }
            }
        function cerrarse()
        {
            window.close()
        }
    </script>

</head>
<%
    String vRespuesta = request.getParameter("vRespuesta");
        if (vRespuesta == null) {
            vRespuesta = "noway";
        }

    String val = request.getParameter("val");
    System.out.println(" entrando al frm con :" + val);
    cRedTrabajo objred = new cRedTrabajo();
    Vector vredtrabajo = new Vector();
    cTipoCelula objtcel = new cTipoCelula();
    Vector vtipocelula = new Vector();
    Vector vlideres=new Vector();
    cMiembro objlider=new cMiembro();
    String vcodigo = "Autogenerado";
    int vcodigo2 = 0;
    int vidtipocelula = 0;
    String vdireccion = "";
    String vreferencia = "";
    String vdia_realiza = "";
    String vhora_realiza = "";
    String vfecha_apertura = "";
    String vtelefono = "";
    int vPPersona=0;
    int vidRedTrabajo = 0;
    String vestado = "";
    String vano = "";
    String vmes = "";
    String vdia = "";
    String vhora = "";
    String vmin = "";
    String vpm = "";

    vredtrabajo = objred.BuscarTodo();
    vtipocelula = objtcel.BuscarTodo();
    vlideres =objlider.Lideres();
    if (val.equals("MOD")) {
        System.out.println(" entrando al modificar :" + val);
        cCelula c = new cCelula();

        int vidCelula = Integer.parseInt(request.getParameter("vidCelula"));
        System.out.println(" recibiendo el codigo :" + vidCelula);
        c.Buscar(vidCelula);

        System.out.println("se encontro");
        System.out.println("Invitado " + c.toString());
        vcodigo2 = c.getIdCelula();
        vidtipocelula = c.getIdTipoCelula();
        vdireccion = c.getDireccion();
        vreferencia = c.getReferencia();
        vdia_realiza = c.getDia_realiza();
        vhora_realiza = c.getHora_realiza();
        vfecha_apertura = c.getFecha_apertura();
        vtelefono = c.getTelefono();
        vidRedTrabajo = c.getIdRedTrabajo();
        
        cPersona objper=new cPersona();
        objper.Buscarlider2(vcodigo2);
        vPPersona=objper.getIdPersona();
        
        
        
        vestado = c.getEstado();
       
        vhora = vhora_realiza.substring(0, 2);
        vmin = vhora_realiza.substring(3, 6);
        vpm = vhora_realiza.substring(6, 9);

        System.out.println("codigo : " + vcodigo2);
        System.out.println("tipo : " + vidtipocelula);
        System.out.println("direccion : " + vdireccion);
        System.out.println("referencia : " + vreferencia);
        System.out.println("dia : " + vdia_realiza);
        System.out.println("hora : " + vhora_realiza);
        System.out.println("fecha apertura: " + vfecha_apertura);
        System.out.println("tefefono : " + vtelefono);
        System.out.println("red: " + vidRedTrabajo);
        System.out.println("estado: " + vestado);

    }

%>
<body onload="CargaFrame('<%=vRespuesta%>')">
    <form name="f" method="post"  >
        <br><br>

        <table class="tablita">
            <tr class="celtitu">
                <td>REGISTRAR CELULAS</td>
            </tr>
        </table>
        <BR>
        <table class="tablita">
            <tr>
                <td>
            <tr>
                <td >Codigo : </td>
            <input type="hidden" name="vall" value="<%=val%>"> 
            <%if (val.equals("NUE")) {%>
            <td >
                <input name="Codigo" type="text" value="<%=vcodigo%>" disabled="disabled"   >
                <input type="hidden" name="txtcodigo" value="<%=vcodigo%>">
                </div></td>
                <%} else if (val.equals("MOD")) {%>
            <td >
                <input name="Codigo" type="text" value="<%=vcodigo2%>" disabled="disabled" class="TText" size="26"  >
                <input type="hidden" name="txtcodigo" value="<%=vcodigo2%>">
            </td>
            <%}%>

            </tr>
            <tr>
                <td >Tipo de Celula : </td>
                <%if (val.equals("NUE")) {%>
                <td><select name="cbotipocel" class="celdita1" >
                        <option value="">-----</option>
                        <%for (int i = 0; i < vtipocelula.size(); i++) {
                                objtcel = (cTipoCelula) vtipocelula.elementAt(i);
                        %>
                        <option value="<%=objtcel.getIdTipoCelula()%>">
                            <%=objtcel.getDescripcion()%></option>
                            <%}%>

                    </select>
                </td>
                <%} else if (val.equals("MOD")) {%>
                <td>
                    <select name="cbotipocel" class="celdita1">
                        <%for (int i = 0; i < vtipocelula.size(); i++) {
                                    objtcel = (cTipoCelula) vtipocelula.elementAt(i);%>
                        <option value="<%=objtcel.getIdTipoCelula()%>" 
                                <%
                                    if (vidtipocelula == objtcel.getIdTipoCelula()) {
                                        out.print("selected");
                                    }
                                %>
                                >
                            <%=objtcel.getDescripcion()%></option>
                            <%}%>
                    </select>
                    <%}%>
                </td>
            </tr>
            <tr>
                <td >Direccion:</td>
                <td>
                    <input type="text" name="txtdireccion" class="celdita1"value="<%=vdireccion%>"  >

                    </div>
                </td>
            </tr>
            <tr>
                <td >Referencia: </td>
                <td>
                    <input type="text" name="txtreferencia" value="<%=vreferencia%>" class="celdita1" >


                </td>
            </tr>
            <tr>
                <td >Lider: </td>
               
                   <%if (val.equals("NUE")) {%>
                <td><select name="cbolider" class="celdita1" >
                        <option value="">-----</option>
                        <%for (int i = 0; i < vlideres.size(); i++) {
                                objlider = (cMiembro) vlideres.elementAt(i);
                        %>
                        <option value="<%=objlider.getIdPersona() %>">
                            <%=objlider.getNombres() %></option>
                            <%}%>

                    </select>
                </td>
                <%} else if (val.equals("MOD")) {%>
                <td>
                    <select name="cbolider" class="celdita1">
                        <%for (int i = 0; i < vlideres.size(); i++) {
                                    objlider = (cMiembro) vlideres.elementAt(i);%>
                        <option value="<%=objlider.getIdPersona() %>" 
                                <%
                                    if (vPPersona== objlider.getIdPersona()) {
                                        out.print("selected");
                                    }
                                %>>
                            <%=objlider.getNombres() %></option>
                            <%}%>
                    </select>
                    <%}%>
                </td>

               
            </tr>
            <tr>
                <td >dia:</td>
                <td>
                    <%if (val.equals("NUE")) {%>
                    <select name="txtdiarea" id="txtdiarea" >
                        <option value="---">---</option>
                        <option value="Lunes">Lunes</option>
                        <option value="Martes">Martes</option>
                        <option value="Miercoles">Miercoles</option>
                        <option value="Jueves">Jueves</option>
                        <option value="Viernes">Viernes</option>
                        <option value="Sabado">Sabado</option>
                        <option value="Domingo">Domingo</option>
                        <%} else if (val.equals("MOD")) {%>
                        <select name="txtdiarea" id="txtdiarea" >
                            <option value="<%=vdia_realiza%>"><%=vdia_realiza%></option>
                            <option value="Lunes">Lunes</option>
                            <option value="Martes">Martes</option>
                            <option value="Miercoles">Miercoles</option>
                            <option value="Jueves">Jueves</option>
                            <option value="Viernes">Viernes</option>
                            <option value="Sabado">Sabado</option>
                            <option value="Domingo">Domingo</option>  
                            <%} %>
                  </select>
                </td>
            </tr>
            <tr>
                <td >hora: </td>
                <td><div align="left"> 
                        <%if (val.equals("NUE")) {%>
                        <select name="txthora" id="txthora" >
                            <option value="---">---</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>

                            <%} else if (val.equals("MOD")) {%>
                            <select name="txthora" id="txthora" >
                                <option value="<%=vhora%>"><%=vhora%></option>
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <%} %>

                  </select>:
                            <%if (val.equals("NUE")) {%>
                            <select name="txtmin" id="txtmin">
                                <option value="---">---</option>
                                <option value="00">00</option>
                                <option value="15">15</option>
                                <option value="30">30</option>
                                <option value="45">45</option>
                                <%} else if (val.equals("MOD")) {%>
                                <select name="txtmin" id="txtmin">
                                    <option value="<%=vmin%>"><%=vmin%></option>
                                    <option value="00">00</option>
                                    <option value="15">15</option>
                                    <option value="30">30</option>
                                    <option value="45">45</option>
                                    <%}%>
                                    <%if (val.equals("NUE")) {%>
                  </select> <select name="txtpm" id="txtpm">
                                    <option value="---">---</option>
                                    <option value="pm.">pm.</option>
                                    <option value="am.">am.</option>
                                    <%} else if (val.equals("MOD")) {%>
                                </select> <select name="txtpm" id="txtpm">
                                    <option value="<%=vpm%>"><%=vpm%></option>
                                    <option value="pm.">pm.</option>
                                    <option value="am.">am.</option>
                                    <%} %>
                                </select></td>

          </tr>

                                <tr>
                                    <td>fecha de apertura: </td>
                                   <td>
                        <input type="text" ID="txtfechaape" name="txtfechaape" class="celdita1"value="<%=vfecha_apertura%>">
                        <a href="javascript:doNothing()" 
                           onClick="setDateField(document.f.txtfechaape);
                                   top.newWin = window.open('calendario.jsp', 'cal', 'dependent=yes,width=280,height=240,screenX=1100,screenY=300,titlebar=yes')"> 
                            <img src="CalendarPage/calendar.gif" border=0></a>


                    </td>
                                </tr>
                                                <tr>
                                                    <td >telefono: </td>
                                                    <td>
                                                        <input type="text" name="txttelefono" value="<%=vtelefono%>"class="celdita1"  >

                                                      
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td >Red : </td>
                                                    <%if (val.equals("NUE")) {%>
                                                    <td><select name="cbotipored">
                                                            <option value="">-----</option>
                                                            <%for (int i = 0; i < vredtrabajo.size(); i++) {
                                                                    objred = (cRedTrabajo) vredtrabajo.elementAt(i);
                                                            %>
                                                            <option value="<%=objred.getIdRedTrabajo()%>">
                                                                <%=objred.getDescripcion()%></option>
                                                                <%}%>

                                                        </select>
                                                    </td>
                                                    <%} else if (val.equals("MOD")) {%>
                                                    <td>
                                                        <select name="cbotipored">
                                                            <%for (int i = 0; i < vredtrabajo.size(); i++) {
                                                                        objred = (cRedTrabajo) vredtrabajo.elementAt(i);%>
                                                            <option value="<%=objred.getIdRedTrabajo()%>" 
                                                                    <%
                                                                        if (vidRedTrabajo == objred.getIdRedTrabajo()) {
                                                                            out.print("selected");
                                                                        }
                                                                    %>>
                                                                <%=objred.getDescripcion()%></option>
                                                                <%}%>
                                                        </select>
                                                        <%}%>
                                                    </td>
                                                </tr>
                                               

      </table>
                                                <BR>
                                                <table class="tablita">
                                                    <tr >
                                                        <td >
                                                            <input type="button" value="Cerrar" class="BOTONCITO" onclick="cerrarse()">
                                                        </td>
                                                        <td >&nbsp;</td>
                                                        <td >
                                                            
                                                              <div align="right">
                                                                <input type="button" value="Grabar " class="BOTONCITO" onclick="verificar(this.form)"/>
                                                              </div>
                                                            
                                                        </td>
                                                    </tr>
                                                </table>
                                                
            <% if (vRespuesta.equals("1")) {%>
            <table class="tablita">
            <tr class="celtitu">
                <td> 
                    ESTA PERSONA YA TIENE UNA CELULA DE DISCIPULADO
                </td> 
            </tr>
            </table>
            <%}
            if (vRespuesta.equals("2")) {%>
            <table class="tablita">
            <tr class="celtitu">
                <td>
                    SE GRABO CORRECTAMENTE
                </td> 
            </tr>
            <%}%>
            </table>
                                                </form>
                                                </body>
                                                </html>