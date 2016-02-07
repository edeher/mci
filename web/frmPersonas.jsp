<%-- 
    Document   : frmPersonas
    Created on : 24-feb-2014, 15:26:25
    Author     : Ing. Edeher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<!DOCTYPE html>
<html>
    <head>
          
    <title>Personas</title>
    <SCRIPT LANGUAGE="JavaScript" SRC="CalendarPage/calendar.js"></SCRIPT>
    <link href="css/style2.css" rel="stylesheet" type="text/css"/>
   <script language="javaScript">

            function verificar(f)
            {
                var falta="";

                if(f.txtnombres.value=="")
                {
                falta+="\t Nombre \n ";
                }
                if(f.txtapepaterno.value=="")
                {
                falta+="\t Apellido Paterno \n ";
                }
                if(f.txtapematerno.value=="")
                {
                falta+="\t Apellido Materno \n ";
                }
                
                if(f.txtreferencia.value=="")
                {
                falta+="\t Referencia \n ";
                }
                if(f.txtfechanac.value=="")
                {
                   falta+="\t fecha de nacimiento \n "; 
                }
               if(f.txttelefono.value=="")
                {
                falta+="\t telefono \n ";
                }
                
                if(f.cbotiidentidad.value=="")
                {
                falta+="\t tipo de documento de indentidad \n ";
                }
                if(f.txtnroidentidad.value=="")
                {
                falta+="\t numero de DNI \n ";
                }
                 
                 if(f.cbotiidentidad.value=="carnet extranjeria")
                {
                if (f.txtnroidentidad.value.length!=9) {
                    alert('Carnet de Extrangeria incompleto');
                   
                  }
                  
                 }  
                 else (f.cbotiidentidad.value=="dni")
                 {
                    if (f.txtnroidentidad.value.length!=8) {
                    alert('DNI  Imcompleto');
                   
                  } 
                     
                 }
                if(f.cbotitipopersona.value=="")
                {
                falta+="\t tip de persona \n ";
                }
                if(f.txtprofesion.value=="")
                {
                falta+="\t profesion \n ";
                }
                if(f.txtobservacion.value=="")
                {
                falta+="\t observaciones \n ";
                }
                if(falta!="")
                {
                    alert("Ingrese :\n "+ falta + " : de la Persona");
                    return false;
                }
                else 
                {
                    if(f.vall.value=="NUE" )
                    {
                        f.action="sPersonaMan?val=NUE";
                        f.target="";
                        f.submit();
                        f.reset();
                        return true;
                    }
                    else 
                    {
                        f.action="sPersonaMan?val=MOD";
                        f.target="";
                        f.submit();
                        return true;
                    }
                }
            }
function CargaFrame(vas)
            {
                if (vas == "2") {
                   
                    f.action = "sPersonaMan?val=RECARGA";
                    f.target = "cuerpito";
                    f.submit();
                    true;
                } else {
                    return false;
                }
            }
            function cerrarse()
            {
                window.close();
            } 
         
    </script>
    </head>
    <%
 String vRespuesta = request.getParameter("vRespuesta");
        if (vRespuesta == null) {
            vRespuesta = "noway";
        }
        String val=request.getParameter("val");
      System.out.println(" entrando al frm.jsp como :"+val);
      cTipoPersona objtper=new cTipoPersona();
       Vector vtipopersona=new Vector();
        cTipoIdentidad objtiden=new cTipoIdentidad();
            Vector vtipoidentidad=new Vector();
            
       String vcodigos="Autogenerado";
        int vcodigo=0;
        String vnombres="";
        String vapepaterno="";
        String vapematerno="";
        String vsexo="";
        String vdireccion="";
        String vreferencia="";
        int vedad=0;
        String vfechanac="";
        String vtelefono="";
        int vidtipoidentidad=0;
        String vtipodoc="";
        String vnroidentidad="";
        int vidtipopersona=0;
        String vtipoper="";
        String vprofesion="";
        String vobservacion="";
     
        String vano="";
        String vmes="";
        String vdia="";

            vtipopersona=objtper.BuscarTodo();
                    vtipoidentidad=objtiden.BuscarTodo();
        if(val.equals("MOD"))
        {
            System.out.println(" entrando al modificar :"+val);
            cPersona P=new cPersona();
            int vidPersona=Integer.parseInt(request.getParameter("vidPersona"));
             System.out.println(" recibiendo el codigo :"+vidPersona);
             P.Buscar1(vidPersona);

             System.out.println("se encontro");
             System.out.println("Persona "+P.toString());

                vcodigo=P.getIdPersona();
                vnombres=P.getNombres();
                vapepaterno=P.getApe_paterno();
                vapematerno=P.getApe_materno();
                vsexo=P.getSexo();
                vdireccion=P.getDireccion();
                vreferencia=P.getReferencia();
                vedad=P.getEdad();
                vfechanac=P.getFecha_nac();
                vano=vfechanac.substring(0,4);
                vmes=vfechanac.substring(5,7);
                vdia=vfechanac.substring(8,10);
                
                vtelefono=P.getTelefono();
                vidtipoidentidad=P.getIdTipoIdentidad();
                vtipodoc=P.getTipodoc();
                vnroidentidad=P.getNro_identidad();
                vidtipopersona=P.getIdTipoPersona();
                vtipoper=P.getTipoper();
                vprofesion=P.getProfesion();
                vobservacion=P.getObservaciones();
             System.out.println(" tipo identidad del fmr : "+vidtipoidentidad);   
            System.out.println(" tipo persona aca del fmr : "+vidtipopersona);
            System.out.println(" tipo fecha de nacimiento: "+vfechanac);
             System.out.println(" numerode dni: "+vnroidentidad);
            System.out.println(" profesion: "+vprofesion);
            System.out.println(" observaciones: "+vobservacion);
             System.out.println("  año : "+vano);
              System.out.println("  mes : "+vmes);
               System.out.println("  dia : "+vdia);
               System.out.println("  SEXO: "+vsexo);
        }

    %>
    <body onload="CargaFrame('<%=vRespuesta%>')">
        <form name="f" method="post"  >
	<br><br>
	<center>
            <table class="tablita">
                <tr class="celtitu">
          <td>REGISTRAR PERSONAS</td>
        </tr>
      </table>
	<BR>

       
              <table class="tablita">
            <tr>
              <td >Codigo : </td>
             <input type="hidden" name="vall" value="<%=val%>"> 
              <td >
                      <%if(val.equals("NUE")){%>
                      
                <input name="Codigo" type="text" value="<%=vcodigos%>" disabled="disabled"    >
                <input type="hidden" name="txtCodigo" class="celbox" value="<%=vcodigo%>">
                <%} else
                      {%>
                     <input name="Codigo" type="text" value="<%=vcodigo%>" disabled="disabled"    >
                <input type="hidden" name="txtCodigo" value="<%=vcodigo%>"> 
                      
                      <%}%>
                
              </td>
            </tr>
             <tr>
              <td >NOMBRES: </td>
              <td>
                <input type="text" name="txtnombres" class="celdita"value="<%=vnombres%>"   >

             
              </td>
            </tr>
             <tr>
              <td >Apellido Paterno: </td>
              <td>
                <input type="text" name="txtapepaterno"class="celdita" value="<%=vapepaterno%>"   >

             
              </td>
            </tr>
             <tr>
              <td >Apellido Materno: </div></td>
              <td>
                <input type="text" name="txtapematerno" class="celdita"value="<%=vapematerno%>"  >

             
              </td>
            </tr>
              <tr>
              <td >sexo: </td>
              <%if(val.equals("NUE")) {%>
              <td>
                      V <input type=radio value="v" name="txtsexo" >M <input type=radio value="m" name="txtsexo">

              
              </td>
              <%}else if(val.equals("MOD")){%>
              <td>
                       <%if(vsexo.equals("v")) {%>
                       V <input type=radio value="v" name="txtsexo" checked>M <input type=radio value="m" name="txtsexo">
                       <%}else if(vsexo.equals("m")){%>
                       V <input type=radio value="v" name="txtsexo">M <input type=radio value="m" name="txtsexo"checked>
                       <%} %>
             
              </td>
               <%} %>
            </tr>
             <tr>
              <td>Direccion: </td>
              <td>
                <input name="txtdireccion" type="text" class="celdita"value="<%=vdireccion%>"   >

          
              </td>
            </tr>
             <tr>
              <td >Referencia: </td>
              <td>
                <input type="text" name="txtreferencia" class="celdita"value="<%=vreferencia%>"  >

           
              </td>
            </tr>
            <tr>
              <td >fecha nacimiento: </td>
              <td ><input type="text" name="txtfechanac" class="celdita2"  value="<%=vfechanac%>">
                     <a href="javascript:doNothing()" 
                                               onClick="setDateField(document.f.txtfechanac);
                                                       top.newWin = window.open('calendario.jsp', 'cal', 'dependent=yes,width=280,height=240,screenX=1100,screenY=300,titlebar=yes')"> 
                                                <img src="CalendarPage/calendar.gif" border=0></a></td>
            </tr>
             <tr>
              <td >Tefelefono: </td>
              <td>
                <input type="text" name="txttelefono" class="celdita"value="<%=vtelefono%>"   size="9" maxlength="9"  >

             
              </td>
            </tr>
            <tr>
              <td >Tipo de Documento :</td>
              <%if(val.equals("NUE")) {%>
              <td ><select name="cbotiidentidad" class="celdita">
                        <option value="">-----</option>
                        <%for(int i=0;i<vtipoidentidad.size()  ;i++ )
                        {
                        objtiden=(cTipoIdentidad)vtipoidentidad.elementAt(i);
                        %>
                        <option value="<%=objtiden.getIdTipoIdentidad() %>"><%=objtiden.getDescripcion() %></option>
                        <%}%>

                    </select>
                </td>
                <%}else if(val.equals("MOD")){%>
                <td >
                    <select name="cbotiidentidad" id="cbotiiden" class="celdita">
                            <%for(int i=0;i<vtipoidentidad.size();i++){
                                objtiden =(cTipoIdentidad)vtipoidentidad.elementAt(i);%>
                                <option value="<%=objtiden.getIdTipoIdentidad() %>" 
                                        
                                        <%if(vidtipoidentidad==objtiden.getIdTipoIdentidad() )
                                            
                                            out.print("selected");%>>
                                <%=objtiden.getDescripcion() %></option>
                            <%}%>
                        </select>
                    <%} %>
                <!-- --> 
                </td>
            </tr>
            <tr>
              <td >numero de identidad : </td>
              
              <td>
                <input type="text" name="txtnroidentidad"class="celdita" value="<%=vnroidentidad%>"  >
              </td>
               
                         
        
            </tr>
            <tr>
              <td >Tipo de Persona : </td>
              <%if(val.equals("NUE")) {%>
              <td><select name="cbotitipopersona" class="celdita">
                        <option value="">-----</option>
                        <%for(int i=0;i<vtipopersona.size()  ;i++ )
                        {
                        objtper=(cTipoPersona)vtipopersona.elementAt(i);
                        %>
                        <option value="<%=objtper.getIdTipoPersona() %>"><%=objtper.getDescripcion() %></option>
                        <%}%>

                    </select>
                </td>
                <%}else if(val.equals("MOD")){%>
                <td>
                <select name="cbotitipopersona" class="celdita">
                            <%for(int i=0;i<vtipopersona.size();i++){
                                objtper =(cTipoPersona)vtipopersona.elementAt(i);%>
                                <option value="<%=objtper.getIdTipoPersona() %>" 
                                        
                                        <%if(vidtipopersona==objtper.getIdTipoPersona())
                                            
                                            out.print("selected");%>>
                                <%=objtper.getDescripcion() %></option>
                            <%}%>
                        </select>
                <%}%>
                </td>
            </tr>
            <tr>
              <td >PROFESION : </td>
              <td>
                <input type="text" name="txtprofesion" class="celdita"value="<%=vprofesion%>"  >

             
            </tr>
            
            <tr>
              <td >observaciones : </td>
              <td>
                <input type="text" name="txtobservacion"class="celdita" value="<%=vobservacion%>"  >

            
            </tr>
             
          </table>
	
         <BR>
	  <table class="tablita">
              <tr>
          <td width="166">
              <input type="button" value="Cerrar" class="BOTONCITO" onclick="cerrarse()">
         </td>
         <td width="122"></td>
          <td width="96">
              <input type="button" class="BOTONCITO" value="Grabar " onclick="verificar(this.form)"/>
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
	
	</form>





    </body>

</html>