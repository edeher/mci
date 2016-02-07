/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
/**
 *
 * @author Ing. Edeher
 */
public class pruebaconexion extends HttpServlet {
 public void init(ServletConfig conf)
    throws ServletException {
    super.init(conf);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

    Connection conexion = null;
    
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    try {
	//Leemos el driver de Oracle
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	//Nos conectamos a la BD local
	conexion = DriverManager.getConnection ("jdbc:sqlserver://LENOVO:1433:mci_new","sa","poderoso");

	/*//Nos conectamos a la BD de la ETSII
        String clave="claveSecretaETSII";
        conexion = DriverManager.getConnection (
		       	"jdbc:oracle:thin:@oracle0.ugr.es:1521:PRACTBD",
		  	"fjgarcia",clave);
         */


        //Decimos que nos hemos conectado 
    	out.println("<html>");
    	out.println("<body>");
    	out.println("<h1>¡Hemos conectado!</h1>");
    	out.println("</body>");
	out.println("</html>");

	} 
	catch (ClassNotFoundException e1) {
                //Error si no puedo leer el driver de Oracle 
		out.println("ERROR:No encuentro el driver de la BD: "+
				e1.getMessage());
	}
	catch (SQLException e2) {
                //Error SQL: login/passwd mal
		out.println("ERROR:Fallo en SQL: "+e2.getMessage());
	}
	finally {
                //Finalmente desconecto de la BD
		try {
			if (conexion!=null)
				conexion.close();
		} catch (SQLException e3) {
			out.println("ERROR:Fallo al desconectar de la BD: "+
				e3.getMessage());
		}
	
	}

  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    doGet(req, res);
  }
}