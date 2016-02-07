<%-- 
    Document   : nereporteeee
    Created on : 22/10/2014, 11:28:23 AM
    Author     : Ing. Edeher
--%>

<%@page import="net.sf.jasperreports.engine.export.*"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Clases.*" %>
<%@page import="net.sf.*"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.sql.* " %>

<% /*Parametros para realizar la conexión*/
    try {
        DBManager dbm = new DBManager();
        Connection con = dbm.getConnection();
        /*Establecemos la ruta del reporte*/
        File reportFile = new File(application.getRealPath("/Reportes/Celugrama.jasper"));
        /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba 
        cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
        Map parameters = new HashMap();
        parameters.put("idCelula", 2);
        /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
        byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con);
        /*Indicamos que la respuesta va a ser en formato PDF*/
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream ouputStream = response.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        /*Limpiamos y cerramos flujos de salida*/
        ouputStream.flush();
        ouputStream.close();

    } finally {
        System.out.println("error");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Prueba</title>
        <link rel="stylesheet" type="text/css" href="css/estylo.css">
    </head>
    <body>
      
    </body>
</html>
