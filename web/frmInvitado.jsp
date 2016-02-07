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

    </body><title>Persona</title><link rel="stylesheet" type="text/css" href="css/estylo.css">
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
                if(f.txtdia.value=="---")
                {
                falta+="\t dia \n ";
                }
                if(f.txtmes.value=="---")
                {
                falta+="\t mes \n ";
                }
                if(f.txtano.value=="---")
                {
                falta+="\t año \n ";
                }
                if(f.txttelefono.value=="")
                {
                falta+="\t telefono \n ";
                }
                if(f.cboCelula.value=="")
                 {
                    falta+="\t Ingrese la direcion de la celula \n ";
                   
                  } 
                if(f.cboPeriodo.value=="")
                {
                falta+="\t ingrese el tema de la semanas \n ";
                }
                if(f.txtestado.value=="")
                {
                falta+="\t estado \n ";
                }
                if(falta!="")
                {
                    alert("Ingrese :\n "+ falta + " : del Invitado");
                    return false;
                }
                else 
                {
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

        String val=request.getParameter("val");
      System.out.println(" entrando al frm como :"+val);
        cCelula objcel=new cCelula();
        cPeriodo objperi=new cPeriodo();
        Vector vCelula=new Vector();
        Vector vPeriodo=new Vector();
        
        int vcodigo=0;
        int vidCelula=0;
        int vidPeriodo=0;
        String vnombres="";
        String vapepaterno="";
        String vapematerno="";
        String vsexo="";
        String vdireccion="";
        String vreferencia="";
        int vedad=0;
        String vfechanac="";
        String vtelefono="";
        String vestado="";
       
        String vano="";
        String vmes="";
        String vdia="";

            
            vCelula=objcel.BuscarTodot();

            
            vPeriodo=objperi.BuscarTodo();

        if(val.equals("MOD"))
        {
          System.out.println(" entrando al modificar :"+val);
            cInvitado obji=new cInvitado();
            
            int vidInvitado=Integer.parseInt(request.getParameter("vidInvitado"));
            System.out.println(" recibiendo el codigo :"+vidInvitado);
             obji.Buscar1(vidInvitado);

             System.out.println("se encontro");
             System.out.println("Invitado "+obji.toString());

                vcodigo=obji.getIdInvitado();
                vnombres=obji.getNombres();
                vapepaterno=obji.getApe_paterno();
                vapematerno=obji.getApe_materno();
                vsexo=obji.getSexo();
                vdireccion=obji.getDireccion();
                vreferencia=obji.getReferencia();
                vedad=obji.getEdad();
                vfechanac=obji.getFecha_nac();
                vano=vfechanac.substring(0,4);
                vmes=vfechanac.substring(5,7);
                vdia=vfechanac.substring(8,10);
                
                vtelefono=obji.getTelefono();
                vidCelula=obji.getIdCelula();
                vidPeriodo=obji.getIdPeriodo();
                vestado=obji.getEstado();
               
             System.out.println(" codigo de celula : "+vidCelula);   
            System.out.println(" codigo d eperiodo : "+vidPeriodo);
            System.out.println("  fecha de nacimiento: "+vfechanac);
             System.out.println("  año : "+vano);
              System.out.println("  mes : "+vmes);
               System.out.println("  dia : "+vdia);
               System.out.println("  SEXO: "+vsexo);
        }

    %>
    <body>
        <form name="f" method="post" action="sInvitados?val=<%=val%>" onsubmit="return verificar(f)" >
	<br><br>
	<center>
	  <table width="340" border="0" class="TTitulo">
        <tr>
          <td>REGISTRAR PERSONAS</td>
        </tr>
      </table>
	<BR>

	  <table width="331" border="0" class="TBorde">
        <tr>
          <td><table width="330" border="0" class="TFondo2">
            <tr>
              <td width="113" class="TDetalle"><div align="right">Codigo : </div></td>
              <td width="201"><div align="left">
                <input name="Codigo" type="text" value="<%=vcodigo%>" disabled="disabled" class="TText" size="34"  >
                <input type="hidden" name="txtCodigo" value="<%=vcodigo%>">
              </div></td>
            </tr>
             <tr>
              <td class="TDetalle"><div align="right">Direccion de Celula : </div></td>
              <%if(val.equals("NUE")) {%>
              <td><select name="cboCelula">
                        <option value="">-----</option>
                        <%for(int i=0;i<vCelula.size()  ;i++ )
                        {
                        objcel=(cCelula)vCelula.elementAt(i);
                        %>
                        <option value="<%=objcel.getIdCelula() %>"><%=objcel.getDireccion() %></option>
                        <%}%>

                    </select>
                </td>
                <%}else if(val.equals("MOD")){%>
                <td>
                    <select name="cboCelula" id="cbotiiden" >
                            <%for(int i=0;i<vCelula.size();i++){
                                objcel =(cCelula)vCelula.elementAt(i);%>
                                <option value="<%=objcel.getIdCelula() %>" 
                                        
                                        <%if(vidCelula==objcel.getIdCelula() )
                                            
                                            out.print("selected");%>>
                                <%=objcel.getDireccion() %></option>
                            <%}%>
                        </select>
                    <%} %>
                <!-- --> 
                </td>
            </tr>
            <tr>
              <td class="TDetalle"><div align="right">Tema de Celula (periodo) : </div></td>
              <%if(val.equals("NUE")) {%>
              <td><select name="cboPeriodo">
                        <option value="">-----</option>
                        <%for(int i=0;i<vPeriodo.size()  ;i++ )
                        {
                        objperi=(cPeriodo)vPeriodo.elementAt(i);
                        %>
                        <option value="<%=objperi.getIdPeriodo() %>"><%=objperi.getTema1() %></option>
                        <%}%>

                    </select>
                </td>
                <%}else if(val.equals("MOD")){%>
                <td>
                <select name="cboPeriodo">
                            <%for(int i=0;i<vPeriodo.size();i++){
                                objperi =(cPeriodo)vPeriodo.elementAt(i);%>
                                <option value="<%=objperi.getIdPeriodo() %>" 
                                        
                                        <%if(vidPeriodo==objperi.getIdPeriodo())
                                            
                                            out.print("selected");%>>
                                <%=objperi.getTema1() %></option>
                            <%}%>
                        </select>
                <%}%>
                </td>
            </tr>
            <tr>
              <td class="TDetalle"><div align="right">NOMBRES: </div></td>
              <td><div align="left">
                <input type="text" name="txtnombres" value="<%=vnombres%>" class="TText" size="34" >

              </div>
              </td>
            </tr>
             <tr>
              <td class="TDetalle"><div align="right">Apellido Paterno: </div></td>
              <td><div align="left">
                <input type="text" name="txtapepaterno" value="<%=vapepaterno%>" class="TText" size="34" >

              </div>
              </td>
            </tr>
             <tr>
              <td class="TDetalle"><div align="right">Apellido Materno: </div></td>
              <td><div align="left">
                <input type="text" name="txtapematerno" value="<%=vapematerno%>" class="TText" size="34" >

              </div>
              </td>
            </tr>
              <tr>
              <td class="TDetalle"><div align="right">sexo: </div></td>
              <%if(val.equals("NUE")) {%>
              <td><div align="left">
                      V <input type=radio value="v" name="txtsexo" >M <input type=radio value="m" name="txtsexo">

              </div>
              </td>
              <%}else if(val.equals("MOD")){%>
              <td><div align="left">
                       <%if(vsexo.equals("v")) {%>
                       V <input type=radio value="v" name="txtsexo" checked>M <input type=radio value="m" name="txtsexo">
                       <%}else if(vsexo.equals("m")){%>
                       V <input type=radio value="v" name="txtsexo">M <input type=radio value="m" name="txtsexo"checked>
                       <%} %>
              </div>
              </td>
               <%} %>
            </tr>
             <tr>
              <td class="TDetalle"><div align="right">Direccion: </div></td>
              <td><div align="left">
                <input type="text" name="txtdireccion" value="<%=vdireccion%>" class="TText" size="34" >

              </div>
              </td>
            </tr>
             <tr>
              <td class="TDetalle"><div align="right">Referencia: </div></td>
              <td><div align="left">
                <input type="text" name="txtreferencia" value="<%=vreferencia%>" class="TText" size="34" >

              </div>
              </td>
            </tr>
            <tr>
              <td class="TDetalle"><div align="right">fecha nacimiento: </div></td>
             <td><div align="left">Dia 
        <%if(val.equals("NUE")) {%>
        <select name="txtdia" id="txtdia" >
        <option value="---">---</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
        <%}else if(val.equals("MOD")){%>
        <select name="txtdia" id="txtdia" >
        <option value="<%=vdia%>"><%=vdia%></option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
         <%} %>
        
      </select> Mes
      <%if(val.equals("NUE")) {%>
      <select name="txtmes" id="txtmes">
          <option value="---">---</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
           <%}else if(val.equals("MOD")){%>
          <select name="txtmes" id="txtmes">
          <option value="<%=vmes%>"><%=vmes%></option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
           <%}%>
           <%if(val.equals("NUE")) {%>
        </select> Año<select name="txtano" id="txtano">
          <option value="---">---</option>
          <option value="2000">2000</option>
          <option value="1999">1999</option>
          <option value="1998">1998</option>
          <option value="1997">1997</option>
          <option value="1996">1996</option>
          <option value="1995">1995</option>
          <option value="1994">1994</option>
          <option value="1993">1993</option>
          <option value="1992">1992</option>
          <option value="1991">1991</option>
          <option value="1990">1990</option>
          <option value="1989">1989</option>
          <option value="1988">1988</option>
          <option value="1987">1987</option>
          <option value="1986">1986</option>
          <option value="1985">1985</option>
          <option value="1984">1984</option>
          <option value="1983">1983</option>
          <option value="1982">1982</option>
          <option value="1981">1981</option>
          <option value="1980">1980</option>
           <%}else if(val.equals("MOD")){%>
           </select> Año<select name="txtano" id="txtano">
           <option value="<%=vano%>"><%=vano%></option>
          <option value="2000">2000</option>
          <option value="1999">1999</option>
          <option value="1998">1998</option>
          <option value="1997">1997</option>
          <option value="1996">1996</option>
          <option value="1995">1995</option>
          <option value="1994">1994</option>
          <option value="1993">1993</option>
          <option value="1992">1992</option>
          <option value="1991">1991</option>
          <option value="1990">1990</option>
          <option value="1989">1989</option>
          <option value="1988">1988</option>
          <option value="1987">1987</option>
          <option value="1986">1986</option>
          <option value="1985">1985</option>
          <option value="1984">1984</option>
          <option value="1983">1983</option>
          <option value="1982">1982</option>
          <option value="1981">1981</option>
          <option value="1980">1980</option>
           <%} %>
        </select></div></td>
            </tr>
             <tr>
              <td class="TDetalle"><div align="right">Tefelefono: </div></td>
              <td><div align="left">
                <input type="text" name="txttelefono" value="<%=vtelefono%>" class="TText"  size="9" maxlength="9"  >

              </div>
              </td>
            </tr>
           
            <tr>
              <td class="TDetalle"><div align="right">Estado
              <td><div align="left">
                <input type="text" name="txtestado" value="<%=vestado%>" class="TText" size="9" maxlength="9" >
              </td>
               
                         
              </div>
            </tr>
            
              </td>

            </tr>

          </table>
	 <BR>
	  <table width="331" border="0" class="TBorde">
        <tr class="TFondo">
          <td width="161"><div align="left">
            <input type="button" value="Cerrar" class="Boton" onclick="cerrarse()">
          </div></td>
          <td width="160" ><div align="right">
            <input type="submit" value="Grabar" class="Boton"  onclick="verificar(this.form),graba()">
          </div></td>
        </tr>
      </table>
	  <p>&nbsp;</p>
	</center>
	</form>




    </body>

</html>