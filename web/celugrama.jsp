<%-- 
    Document   : pruebis
    Created on : 14-jun-2013, 8:43:10
    Author     : Ing. Edeher
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*" %>
<%@page import="Clases.*" %>
<%@page import="java.util.Calendar" %>

<%@page import="java.text.ParseException"%>

<%@page import ="java.util.Date"%>


<html>
    <head>
        <!--<link href="css/tooltipster.css" rel="stylesheet" type="text/css"/>
        <link href="css/botones.css" rel="stylesheet" type="text/css"/>-->
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
      
        <script language="javaScript">
            function Ventana(f, vidCelula)
            {
                javascript:window.open('frmCelulaInte1.jsp?idcelula=' + vidCelula, '', 'width=550,height=850,left=750,top=400,resizable=0,toolsbar=1,scrollbars=1');
               
                return true;
            }
            function Ventana2(f, vidCelula,periodo)
            {
                javascript:window.open('frmCelulaInvi.jsp?idcelula=' + vidCelula+'&idperiodo='+periodo, '', 'width=550,height=850,left=750,top=400,resizable=0,toolsbar=1,scrollbars=1');
                return true;
                
            }
            function Ventana3(f,vidPersona)
            {
                javascript:window.open('frmInformation.jsp?idPersona=' + vidPersona, '','width=550,height=520,left=700,top=200,resizable=0,toolsbar=1,scrollbars=0');
               
                
            }
            
            function Grabar(f)
            {
                f.action = "sCelulaAsis?val=GRA";
                f.target="cuerpo";
                f.submit();
                return true;
            }
         function cerrar(f)
            {
                f.action = "sLogin?val=CE";
                f.submit();
                return true;
            }
            function Buscarperi(f)
            {
                var falta="";
                if(f.txtyear.value=="---"){falta+="\t Año \n ";}
                if(f.txtmoht.value=="---"){falta+="\t Mes \n ";}
                if(falta!="")
                {
                   alert("Ingrese :\n "+ falta + " : Para hacer busqueda del Periodo");
                    return false;
                }
                else 
                {
                     
                    f.action="sCelulainte?val=BUS1";
                    f.target="cuerpo";
                    f.submit();
                    f.reset();
                    return true;
                }
            }
            function grabaofrenda(f)
            {
                var falta="";
                if(f.txtmonto.value==""){falta+="\t monto de ofrenda \n ";}
                if(f.txtnroinvitados.value==""){falta+="\t numero de invitados \n ";}
                if(falta!="")
                {
                   alert("Ingrese :\n "+ falta + " : para guardar correctamente");
                    return false;
                }
                else 
                {
                     
                    f.action="sOfrendaInvi?val=BUS1";
                    f.target="cuerpo";
                    f.submit();
                    f.reset();
                    return true;
                }
            }
            //setTimeout("document.location=document.location ",1000);
            
        </script>
        
        <title>Celugrama</title>
        

    </head>
    <%
String variable=request.getParameter("val");

 String  vRespuesta=request.getParameter("vRespuesta");
         if(vRespuesta==null){vRespuesta="noway";}
         
         
         
System.out.println("entro el VALLLL : "+variable);
System.out.println("entro la respuesta : "+vRespuesta);
        cUsuario P = new cUsuario(); //clase Usuario
        cCelula c = new cCelula(); //clase celula
        cPersona per = new cPersona();//clase persona
        cPersona per3 = new cPersona();//clase persona
        cCelula c1 = new cCelula();//clase celula
        cCelula c2 = new cCelula();//clase celula
        cUsuario usu=new cUsuario(); //clase usuario
        cOfrendaInvitados objOfre=new cOfrendaInvitados();
        c1=null;
        P=null;
        per3=null;
        int idPersona = 0;
        int vidcelula = 0;
        int vidministerio=0;
        String vreferencia = "";
        String vdireccion = "";
        String diarealiza = "";
        String horarealiza = "";
        String feapertura = "";
        String telcelula = "";
        String tipcelula = "";
        String redtrabajo="";
        String ministerio="";

        int pidpersona = 0;
        String pnombres = "";
        String pdireccion = "";
        int pedad = 0;
        String ptelefono = "";
        String ptipmiembro = "";
        int vcodigos = 0;
        
        Vector vmiembros = new Vector();
        
        usu=(cUsuario)session.getAttribute("usu");// recibe usuario
        c1 = (cCelula) request.getAttribute("objcel"); //recibe objeto celula
        P = (cUsuario) session.getAttribute("objusu");
        per3 = (cPersona) request.getAttribute("per");// recibe objeto persona
        
        
        HttpSession sesion=request.getSession();
        sesion.removeAttribute("usu");//cualquier nombre
         sesion.setAttribute("usu",usu);
         
//si entra como usuario----------------------------------------------------------------------
        if (P != null) 
        {
            System.out.println("entro como usuario");
            System.out.println("id :"+P.getIdUsuario() );
             System.out.println("id2 :"+P.getIdPersona());
            idPersona = usu.getIdPersona();

            c.Buscarcelu(idPersona);/*devuelve los datos de una celula.... ingresando el idPersona, 
            siempre en cuando la persona pertenesca a una sola celula, como lider o miembro */
            vidcelula = c.getIdCelula();// id celula
            vidministerio=c.getIdMinisterio();
            tipcelula = c.getTipocelula();
            vdireccion = c.getDireccion();
            vreferencia = c.getReferencia();
            diarealiza = c.getDia_realiza();
            horarealiza = c.getHora_realiza();
            feapertura = c.getFecha_apertura();
            telcelula = c.getTelefono();
            redtrabajo=c.getRed();
            ministerio=c.getMinisterio();
            
            

            per.Buscarlider(idPersona);/*devuelve solo el lider de la celula. ingresando el idPersona,
                                 siempre en cuando la persona pertenesca a una sola celula, como lider o miembro .*/
            pidpersona = per.getIdPersona();
            pnombres = per.getNomcompleto();
            pdireccion = per.getDireccion();
            pedad = per.getEdad();
            ptelefono = per.getTelefono();
            ptipmiembro = per.getTipmiembro();

            vmiembros = per.Buscarmiembro(idPersona);/*devuelve los integrantes de una celula solo miembros... ingresando el idPersona, siempre en cuando la persona 
						pertenesca a una sola celula, como lider o miembro .*/
          if (per != null) {
               
                for (int i = 0; i < vmiembros.size(); i++)
                {
                    
                    per = (cPersona) vmiembros.elementAt(i);
                   
                    System.out.println("miembros " + per.toString3());

                }
            }
            
             
           /*  System.out.println("termino como usuario ");*/
            
        }
        /// si entra como celula--------------------------------------------------------------------------
        if (c1 != null) 
        {
                System.out.println("entro como celula");
           
             vidcelula = c1.getIdCelula();// id de celula
             vidministerio=c.getIdMinisterio();
            tipcelula = c1.getTipocelula();
            vdireccion = c1.getDireccion();
            vreferencia = c1.getReferencia();
            diarealiza = c1.getDia_realiza();
            horarealiza = c1.getHora_realiza();
            feapertura = c1.getFecha_apertura();
            telcelula = c1.getTelefono();
            redtrabajo=c1.getRed();
            ministerio=c1.getMinisterio();

            per.Buscarlider2(vidcelula);

            pidpersona = per.getIdPersona();
            pnombres = per.getNomcompleto();
            pdireccion = per.getDireccion();
            pedad = per.getEdad();
            ptelefono = per.getTelefono();
            ptipmiembro = per.getTipmiembro();

            vmiembros = per.Buscarmiembro2(vidcelula); /*devuelve todos los miembros no
            de la celula, ingresando el id celula*/
               
           /* if (per != null) {
                System.out.println("miembros como celula");
                for (int i = 0; i < vmiembros.size(); i++) {
                    System.out.println("entrando al for");
                    per = (cPersona) vmiembros.elementAt(i);
                    System.out.println("se encontro en el jsp ");
                    System.out.println("miembros " + per.toString3());

                }
            }
         System.out.println("termino como celula ");*/
        } 
        // si entra como persona-----------------------------------------------------------------
       if (per3 != null) 
       {
            System.out.println("entro como persona");
            idPersona = per3.getIdPersona();
            System.out.println("idpersonaaaa =" + idPersona);
            c2.Buscarcelu3(idPersona);/*devuelve los datos de una celula ingresando el idPerosna de un lider...*/

             vidcelula = c2.getIdCelula();
             vidministerio=c.getIdMinisterio();
            tipcelula = c2.getTipocelula();
            vdireccion = c2.getDireccion();
            vreferencia = c2.getReferencia();
            diarealiza = c2.getDia_realiza();
            horarealiza = c2.getHora_realiza();
            feapertura = c2.getFecha_apertura();
            telcelula = c2.getTelefono();
            redtrabajo=c2.getRed();
            ministerio=c2.getMinisterio();

            per.Buscar2(idPersona);/*devuelve la persona por codigo*/

            pidpersona = per.getIdPersona();
            pnombres = per.getNomcompleto();
            pdireccion = per.getDireccion();
            pedad = per.getEdad();
            ptelefono = per.getTelefono();
           // System.out.println("esta es la persona"+idPersona);
            vmiembros = per.Buscarmiembro3(idPersona);/*devuelve los integrantes de una celula solo miembros...
                                                        ingresando el idPersona, del lider.*/	
          
        }
       
/*hacer todo con periodo activos, si no hay hacerlo de una forma y si hay hacerla de otra listo*/
        cAsistencia asis = new cAsistencia();
        cAsistencia asis2 = new cAsistencia();
        Vector vAsiste = new Vector();
        Vector vAsiste2 = new Vector();
        
            
        cPeriodo cperi = new cPeriodo();
        cPeriodo cperi2 = new cPeriodo();
        cPeriodo cperi3 = new cPeriodo();
        cPeriodo cperi4= new cPeriodo();
        cPeriodo cperi5= new cPeriodo();
        Vector vperi = new Vector();
        Vector vperi2= new Vector();
         Vector vperi3= new Vector();
        int semana=0;
        int messs =0;
        int periodo=0;
        String mess ="";
         int messss=0;
         int anioo=0;
         String tema1="";
         String tema2="";
         
           
     // busca periodo anterior----------------------------------------------------------
        if (variable.equals("BUS1") )
        {
            System.out.println("ENTRO AL BUS1!!!!");
            try{
           anioo=Integer.parseInt( request.getParameter("anio"));
            messss=Integer.parseInt( request.getParameter("mes"));
          
            }catch(Exception e){
            System.out.println("Error DEPARAMETROS:" + e.getMessage());
            }
           System.out.println("MESSS :" +anioo+" AÑOOO :"+messss);
            
        vperi2= cperi3.Buscar33(messss, anioo);
          if (cperi3!= null) {
                
                for (int i = 0; i < vperi2.size(); i++) {
                    
                    cperi3= (cPeriodo) vperi2.elementAt(i);
                    
                    System.out.println("periodo" + cperi3.toString());

                }
               System.out.println("numero de periodos" +vperi2.size()); 
            }
          
        anioo=cperi3.getAño();
        
        cperi2.periodo_actual123();
        messs=messss;
        semana = cperi2.getSemana();
        
        tema1=cperi3.getTema1();
        if(tema1==null)
            tema1="no disponible";
        tema2=cperi3.getTema2();
         if(tema2==null)
            tema2="no disponible";
         
         
         
        cperi.Buscar_mes3(messs);//devuelve el nombre del mes
        mess = cperi.getMess()+" "+anioo;// guardo el nombre del mes
        
        
        cperi5.fecha_actual();
        
        }
        else
        {
        
        //vperi = cperi.BuscarTodo2();///devuelve solo un periodo el vigente
        vperi2= cperi3.BuscarTodo3();//devuelve todo los periodos en el mes actual
        if (cperi3!= null) {
                
                for (int i = 0; i < vperi2.size(); i++) {
                    
                    cperi3= (cPeriodo) vperi2.elementAt(i);
                    
                    System.out.println("periodo" + cperi3.toString());

                }
               System.out.println("numero de periodos" +vperi2.size()); 
            }
      cperi2.Buscar_actual();///devuelve solo un periodo el vigente
        
        periodo = cperi2.getIdPeriodo();//devuelve el idperiodo vigente
        semana = cperi2.getSemana(); //devuelve la semana vigente
        //messs = cperi2.getMes();//devuelve el numero de mes vigente
        System.out.println("MESSSSS"+cperi2.getMes());
        //buscar la manera de arreglar el mess actual
        
        tema1=cperi2.getTema1();
         if(tema1==null)
            tema1="no disponible";
        tema2=cperi2.getTema2();
         if(tema2==null)
            tema2="no disponible";
         
         if(cperi2.getMes()==0)
         {
             cperi5.Buscar_mes2();
             mess=cperi5.getMess();
         
         }
         else
         {
         
        cperi.Buscar_mes3(cperi2.getMes());
        mess =cperi.getMess();
        if(mess==null)
            mess="mes actual" ;
        System.out.println("MESSSSS"+mess);
         }
        cperi5.fecha_actual();
        cperi.Buscar_mes2();//devuelve el nombre del mes actual
        
         }
        //ofrendas
        int vidofrenda=0;
        int vicelulaOfrenda=0;
        int vidperiodoofrenda=0;
        double vmonto=0;
        int nroinvitados=0;
        String estado="";
        
       
       
        
    %>
    <body>
        <form name="f" method="post">
            <center>
             &nbsp;
                <table class="tablita" >
                       
                    <tr >
                                              <td height="12" class="celtitu" colspan="8">LIDER DE CÉLULA
                                                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td colspan="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td width="200">NOMBRES Y APELLIDOS</td>
                                              <td nowrap="nowrap" class="celdita" ><%=pnombres%></td>
                                              <td width="80"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                              <td width="200" >CODIGO DE CELULA</td>
                                              <td nowrap="nowrap" class="celdita"><%=vidcelula%></td>
                                              <td width="80">&nbsp;</td>
                                              <td width="150">TEL. DE LIDER</td>
                                              <td nowrap="nowrap" class="celdita" ><%=ptelefono%></td>
                                            </tr>
                                            <tr>
                                                <td height="1">&nbsp;</td>
                                            
                                            <td height="1">&nbsp;</td>
                                              <td height="1"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                              

                                                 <input type="hidden" name="txtidcelula" value="<%=vidcelula%>">
                                                 <input type="hidden" name="txtperiodoactual" value="<%=periodo%>">

                                                <td height="1" >&nbsp;</td>
                                                <td height="1">&nbsp;</td>
                                                <td height="1">&nbsp;</td>
                                               
                                                <td height="1">&nbsp;</td>
                                                <td height="1" >&nbsp;</td>
                                            </tr>
                                        </table>
                     &nbsp;
              
        <table  class="tablita">
                               <tr >
                                   <td class="celtitu"colspan="11"><strong>DATOS DE CÉLULA</strong></td>
                                           
                                 <td  >&nbsp;</td>
                               </tr>
                               <tr>
                                 <td colspan="11">&nbsp;</td>
                               </tr>
                               <tr>
                                 <td height="5">DIRECCION:</td>
                                 <td width="200" height="2" class="celdita"><%=vdireccion%></td>
                                 <td width="45">&nbsp;</td>
                                 <td>TELEFONO:</td>
                                 <td class="celdita"><%=telcelula%></td>
                                 <td width="45">&nbsp;</td>
                                 <td width="40">DIA:</td>
                                 <td class="celdita"><%=diarealiza%></td>
                                 <td width="45">&nbsp;</td>
                                 <td width="80">HORA:</td>
                                 <td  class="celdita"><%=horarealiza%></td>
                               </tr>
                               <tr>
                                 <td>&nbsp;</td>
                                 <td >&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td >&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td >&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td  >&nbsp;</td>
                               </tr>
                               <tr>
                                                
                                  <td width="80"> BARRIO:</td>
                                 <td class="celdita"><%=vreferencia%></td>
                                  <td>&nbsp;</td>
                                 
                                  <td width="180">FECHA DE APERTURA:</td>
                                 <td class="celdita"><%=feapertura%></td>
                                  <td>&nbsp;</td>
                                 
                                  <td>TIPO:</td>
                                  <td class="celdita"><%=tipcelula%></td>
                                  <td>&nbsp;</td>
                                  
                                  <td>TEMA:</td>
                                  <td  class="celdita"><%=tema1%></td>
                                </tr>
                                            
                                            <tr>
                                                
                                                <td height="1">&nbsp;</td>
                                                <td height="1">&nbsp;</td>
                                                <td height="1">&nbsp;</td>
                                                
                                                <td height="1">&nbsp;</td>
                                                <td height="1">&nbsp;</td>
                                                <td height="1">&nbsp;</td>
                                                
                                                <td height="1">&nbsp;</td>
                                                <td height="1" colspan="5" >&nbsp;</td>
                                            </tr>
                                       
                             
              </table>
             
                           &nbsp;                 
                           <table> 
                               <tr>
                                   <td>
               <table  class="tablabu"  >
  <tr>
    <td  ><div align="center">Año</div></td>
    <td  ><label  for="txtyear"></label>
        <select class="celdabu"  name="txtyear"   id="txtyear">
            <option  value="---">---</option>
        <option value="2014">2014</option>
        <option value="2015">2015</option>
      </select></td>
    <td  ><div align="center">Mes</div></td>
    <td  ><label for="txtmoht"></label>
      <select class="celdabu"  name="txtmoht"   id="txtmoht">
        <option value="---" >---</option>
        <option value="1">enero</option>
        
        <option value="2">febrero</option>
        <option value="3">marzo</option>
        <option value="4">abril</option>
        <option value="5">mayo</option>
        <option value="6">junio</option>
        <option value="7">julio</option>
        <option value="8">agosto</option>
        <option value="9">setiembre</option>
      </select></td>
    <td >
        <input type="BUTTON" value="Buscar" class="BOTONCITOS"onclick="Buscarperi(this.form)"></td>
     <!--  <a href="javascript:Buscarperi(this.form)"><img src="imganes/Buscar.gif"/></a></td>
        <input type="image" width="" height="30" onclick="Buscarperi(this.form)" src="imganes/Buscar.gif" align="middle">
    </td>-->
    
  </tr>
</table>
                                   </td>
                                   <td><table><tr><td>&nbsp; </td></tr></table></td>
                                   <td >
 <table class="tablabu">
                   <tr>
                       <%
                        if(objOfre.Buscar_por_idce_idperi(vidcelula,periodo) )
                        {
                            vmonto=objOfre.getMonto();
                            nroinvitados=objOfre.getNroinvitados();
                        
                       %>
                       <td>OFRENDA:</td>
                       <td class="celdabu"><%=vmonto%></td>
                       <td> </td>
                       <td>INVITADOS:</td>
                       <td class="celdabu"><%=nroinvitados%></td>
                       
                       
                       
                       <%}
                        else {%>
                       <td>OFRENDA:</td>
                       <td ><input type="text" name="txtmonto" class="celdabu" value=""></td>
                       <td>INVITADOS:</td>
                       <td ><input type="text" name="txtnroinvitados" class="celdabu" value=""></td>
                       <td><input type="BUTTON" value="Guardar" class="BOTONCITOS"onclick="grabaofrenda(this.form)"></td>
                       <%}%>
                   </tr>
 </table></td>
                           </tr>
                </table>  &nbsp;                         
<table class="tablali">
    
                         <tr  >
                    <td colspan="5" class="celtitu" >
                           INTGEGRANTES DE LA CELULA</td>
                        <td class="celtitu"  colspan="<%=vperi2.size()%>" style="text-align: center">
                            <strong>ASISTENCIA SEMANAL</strong></td>
                        <!--<td colspan="11">
                            <div align="center">CRECIMIENTO ESPIRITUAL</div></td>-->
                  </tr>
                    <tr >
                        <td rowspan="2"  class="celtitu"><div align="center"><strong>
                          N°</strong></div></td>

                        <td rowspan="2"  class="celtitu"><div align="center"><strong>
                          NOMBRES Y APELLIDOS</strong></div></td>
                        <td rowspan="2" class="celtitu" ><div align="center"><strong>
                          DIRECCION</strong></div></td>
                        <td rowspan="2" class="celtitu" ><div align="center"><strong>
                          TELEFONO</strong></div></td>
                        <td rowspan="2" class="celtitu" ><div align="center"><strong>
                          EDAD</strong></div></td>

                        <td class="celtitu" colspan="<%=vperi2.size()%>"><center>
                        <%=mess%></center></td>
                  </tr>
                    <tr >
                        <!-- se verifica que hay semana si la hay corre el for --> 
                        <%if (vperi2.size() != 0) {
                                for (int i = 0; i < vperi2.size(); i++) 
                        {
                            cperi4 = (cPeriodo) vperi2.elementAt(i);
                            System.out.println("semana : " + cperi4.getSemana());
                                                   %>
                        
                        <td class="celtitu" ><center>Semana <%=cperi4.getSemana()%></center></td>
                         <%} 
                        }
                        else {%>
                         <td class="celtitu"  ><center>Semana no Activada </center></td>
                         
                        <%}%>

                  </tr>

                    <%
                        for (int i = 0; i < vmiembros.size(); i++) 
                        {
                            per = (cPersona) vmiembros.elementAt(i);
                          //  System.out.println("asistentes " + per.toString());
                            cPersona per2 = new cPersona();
                             %>
                   <tr >
                            <!-- busca si tiene celula y lo habilita --> 
                                <td ><span class="ketchup tooltip " ><%=i + 1%></span></td>
                            
                            
                            <%per2.Buscarlider3(per.getIdPersona());
                             
                             if (per2.getTipmiembro() != null) 
                                {%>
                                    <td ><a href="sPersona?vcodigo=<%=per.getIdPersona()%>"><%=per.getNomcompleto()%></a></td>
                              <%}
                            else
                            {
                              %>
                                <td ><%=per.getNomcompleto()%> </td>
                           <%}%>
                            <td ><%=per.getDireccion()%></td><td ><div align="center"><%=per.getTelefono()%></div></td>
                            <td ><div align="center"><%=per.getEdad()%></div></td>
                            <% 
                            
                           ///busca semana para activarla
                            if(semana != 0)
                            {
                              for (int j = 0; j < vperi2.size(); j++) 
                            {
                                cperi4 = (cPeriodo) vperi2.elementAt(j);   
                               /*  if(cperi3.getEstado().equals("a") )*/
                                System.out.println("FECHAS " + cperi4.getFechaini()+" es .."+cperi2.getFechaini());
                                System.out.println("FECHAS " + cperi4.getFechafin()+" es .."+cperi2.getFechafin());
                                
                                if(cperi4.getFechaini().compareTo(cperi2.getFechaini())==0&& cperi4.getFechafin().compareTo(cperi2.getFechafin())==0)                                /*  if(cperi3.getEstado().equals("a") )*/
                                        
                                    {
                                       int vvcodigo=0; 
                                       vvcodigo=asis.aiste3(periodo, per.getIdMiembro());//verifica si ya se marco la asistencia
                                       System.out.println("asistencia " + vvcodigo+" del "+ per.getIdMiembro()) ;
                                       if (vvcodigo!= 0)    

                                       {%>
                                          <td  ><center><input type="checkbox" name="chb_<%=i%>" value="<%=per.getIdMiembro()%>"disabled class="asiste"></center></td>
                                       <%}else{%>
                                          <td ><center><input type="checkbox" name="chb_<%=i%>" value="<%=per.getIdMiembro()%>"></center></td>
                                       <%}
                                    }
                                else if(cperi4.getFechaini().compareTo(cperi2.getFechaini())==-1&& cperi4.getFechafin().compareTo(cperi2.getFechafin())==-1) 
                                    {
                                        int vvcodigo=0; 
                                        vvcodigo=asis.aiste3(cperi4.getIdPeriodo(), per.getIdMiembro());
                                        System.out.println("asistencia " + vvcodigo+" del "+ per.getIdMiembro()) ;
                                          if (vvcodigo!= 0) 
                                          {%>
                                          <td  ><center><img src="imganes/yes.png"/></center></td>
                                         <% }else
                                          {%>
                                          <td  ><center><img src="imganes/no.png"/></center></td>
                                          <%}
                                   }
                                else
                                {%>
                                
                                
                                 <td class="celda3"  ><center></center></td>

                                
                                <%}
                                   
                               }

                            } 
                            else {
                                
                                for (int j = 0; j < vperi2.size(); j++) 
                            {
                                cperi4 = (cPeriodo) vperi2.elementAt(j);  
                                              
                                if( cperi4.getFechafin().compareTo(cperi5.getFecha_actual())==-1) 
                                    {
                                        int vvcodigo=0; 
                                        vvcodigo=asis.aiste3(cperi4.getIdPeriodo(), per.getIdMiembro());
                                        System.out.println("asistencia " + vvcodigo+" del "+ per.getIdMiembro()) ;
                                          if (vvcodigo!= 0) 
                                          {%>
                                          <td class="celda1"  ><center></center></td>
                                         <% }else
                                          {%>
                                          <td class="celda2" ><center></center></td>
                                          <%}
                                   }
                              
                                else  
                                { %>
                              <td class="celda4"  ><center></center></td>
                             <%
                                
                                } 
                                
                                
                            }                      



                            }%>
                
                
                  </tr>
                    <%}%>
                    <input type="hidden" name="txtperiodo" value="<%=periodo%>">
                    <input type="hidden" name="hdTotalMiembros" value="<%=vmiembros.size()%>">
                    
              </table>
                    <br>
               <table  cellpadding="15" id="1"  >
                <tr>
                  <!--  <td width="772"><input type="button"  class="botonimagen" onclick="cerrar(this.form)" >  </td>
                    -->
                    <td><input type="button" class="BOTONCITOS" value="Cerrar" onclick="cerrar(this.form)"></td>
                    <td width="500" >&nbsp;</td>
                    <td ><input type="button" class="BOTONCITOS" value="Asistencia" onclick="Grabar(this.form)" ></td>
                    <td width="50" ><p>&nbsp;</p></td>
                    
                    <td width="50" >&nbsp;</td>
                    <td ><input type="button" class="BOTONCITOS" value="Nuevo" onClick="Ventana(this.form, '<%=vidcelula%>')" /></td>
                    
                </tr>
                
            </table>
                 </center>
                  <%if(vRespuesta.equals("2")){%>
                  <span class="Estilo1">SE GRABO CORRECTAMENTE<img src="imganes/yes.png"/></span>
        <%}%>
        </form>
    </body>
   
</html>
