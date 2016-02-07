<%-- 
    Document   : PrincipalHD
    Created on : 12/03/2015, 03:49:14 PM
    Author     : Ing. Edeher
--%>

<%@page import="java.util.Vector"%>
<%@page import="Clases.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Celugrama</title>
        <link rel="stylesheet" type="text/css" href="css/estylo.css">
    </head>
    <%

        int codigo = 0;

        cUsuario usu = new cUsuario();
        cUsuario objusu = new cUsuario();
        usu = (cUsuario) session.getAttribute("usu");// recibe usuario
        objusu = (cUsuario) request.getAttribute("objusu");

        System.out.println("entro al iframe principalhd  ");
        System.out.println("usuario usu:    " + usu.toString());
        System.out.println("usuario objusu:   " + objusu.toString());

        int idUsuario = usu.getIdPersona();
        System.out.println("id:   " + idUsuario);
        cCelula objce2 = new cCelula();
        cCelula objcel = new cCelula();

       // objcel.Buscarcelu2(codigo);

        Vector vCelula = objce2.Buscarnroscelu2(usu.getIdPersona());

        String nombre = "";
        if (objce2 != null) {
            int cont = 0;
            for (int i = 0; i < vCelula.size(); i++) {
                objce2 = (cCelula) vCelula.elementAt(i);
                System.out.println("se encontro " + vCelula.size() + "  celulas ");
                System.out.println("celula nro " + objce2.getIdCelula());
                cont = i + 1;
                System.out.println("nro de celulas  " + (i + 1));

            }

            if ((cont) >= 2) {
                System.out.println("nro de celulas  " + cont);
                HttpSession sesion = request.getSession();
                sesion.removeAttribute("usu");//cualquier nombre
                sesion.setAttribute("usu", usu);
               // sesion.setAttribute("vCelula", vCelula);

                nombre = "numerocelulas.jsp";

            } else {

                if (usu != null) {
                    HttpSession sesion = request.getSession();
                    sesion.removeAttribute("usu");//cualquier nombre
                    sesion.setAttribute("usu", usu);
                    sesion.setAttribute("objusu", objusu);
                    System.out.println(" ");

                    if (usu.getTipo().equals("a")) {
                        nombre = "celugrama.jsp";
                    } else if (usu.getTipo().equals("U")) {
                        nombre = "demos2";
                    }
                }

            }
        } 
        /*else if (objcel != null) {
            HttpSession sesion = request.getSession();

            sesion.setAttribute("objcel", objcel);
            nombre = "celugrama.jsp";
        }*/


    %>
    <body>

        <table border="0" style="width:100%;">
            <TR> 
             <!--<td style="text-align: right">-->
                   <!--  <%=usu.getUsuario()%> --->
           <!--  <img src="imganes/<%=usu.getIdUsuario()%>.png" width="100" height="100" alt="Imagen10"/>-->
               <!-- </td>-->
            </TR>
            <tr>
                <td>
                    <iframe name="cuerpo" style="width:100%;height:1024px;" src="<%=nombre%>?val=entro" frameborder="0" >
                    </iframe>
                </td>
            </tr>
        </table>

    </body>
</html>
