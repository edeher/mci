<%-- 
    Document   : frmInformation
    Created on : 08/07/2015, 04:19:45 PM
    Author     : Mi Laptop
--%>

<%@page import="Clases.cPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persona</title>
           <script language="javaScript">

           
            function cerrarse()
            {
                window.close()
            } 
         
    </script>
    </head>
    <%
     int vidPerson= Integer.parseInt(request.getParameter("idPersona"));
     cPersona objper=new cPersona();
     int vidPersona=0;
     String nombres;
     String apePaterno;
     String apeMaterno;
     String sexo;
     String direccion;
     String referencia;
     int edad=0;
     String fechanac;
     String telefono;
     String tipodoc;
     String nro;
     String profesion;
     String observaciones;
     //busqueda de persona
     objper.Buscar3(vidPerson);
     nombres=objper.getNombres();
     apePaterno=objper.getApe_paterno();
     apeMaterno=objper.getApe_materno();
     
   if(objper.getSexo().equals("v"))
   {
         sexo="Masculino";
           
   }
   else
       sexo="Femenino";
   
     direccion=objper.getDireccion();
     referencia=objper.getReferencia();
     edad=objper.getEdad();
     fechanac=objper.getFecha_nac();
     telefono=objper.getTelefono();
     tipodoc=objper.getTipodoc();
     nro=objper.getNro_identidad();
     profesion=objper.getProfesion();
     observaciones=objper.getObservaciones();
     System.out.println("PERSONA nombres "+nombres);
     System.out.println("PERSONA apePaterno "+apePaterno);
     System.out.println("PERSONA apeMaterno "+apeMaterno);
     System.out.println("PERSONA sexo "+sexo);
     System.out.println("PERSONA direccion "+direccion);
     System.out.println("PERSONA  referencia "+referencia);
     System.out.println("PERSONA edad "+edad);
     System.out.println("PERSONA fechanac"+fechanac);
     System.out.println("PERSONA telefono "+telefono);
     System.out.println("PERSONA tipodoc"+tipodoc);
     System.out.println("PERSONA profesion"+profesion);
     System.out.println("PERSONA observaciones "+observaciones);
    
     %>
    <body>
        <form name="f" method="post"  >
    <table width="295" border="1">
          <tr>
            <td colspan="2"><blockquote>
              <p>Datos Personales</p>
            </blockquote></td>
          </tr>
          <tr>
            <td width="83"><p>Nombre</p></td>
            <td ><%=nombres%></p>
            </td>
          </tr>
          <tr>
            <td>Apellido Paterno</td>
            <td><%=apePaterno%></td>
          </tr>
          <tr>
            <td>Apellido Materno</td>
            <td><%=apeMaterno%></td>
          </tr>
          <tr>
            <td>Genero</td>
            <td><%=sexo%></td>
          </tr>
          <tr>
            <td>Direccion</td>
            <td><%=direccion%></td>
          </tr>
          <tr>
            <td>Referencia</td>
            <td><%=referencia%></td>
          </tr>
          <tr>
            <td>Edad</td>
            <td><%=edad%></td>
          </tr>
          <tr>
            <td>Fecha de Nacimiento</td>
            <td><%=fechanac%></td>
          </tr>
          <tr>
            <td>Telefono</td>
            <td><%=telefono%></td>
          </tr>
          <tr>
            <td>Tipo de Documento</td>
            <td><%=tipodoc%></td>
          </tr>
          <tr>
            <td>Nro de Documento</td>
            <td><%=nro%></td>
          </tr>
          <tr>
            <td>Profesion</td>
            <td><%=profesion%></td>
          </tr>
          <tr>
            <td>observaciones</td>
            <td><%=observaciones%></td>
          </tr>
    </table>
          <input type="button" value="Cerrar" class="Boton" onclick="cerrarse()">
        </form>
    </body>
</html>
