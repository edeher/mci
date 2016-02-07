/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cCelula;
import Clases.cPeriodo;
import Clases.cUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import org.apache.catalina.Session;

/**
 *
 * @author Ing. Edeher
 */
@WebServlet(name = "sLogin", urlPatterns = {"/sLogin"})
public class sLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        String val = request.getParameter("val");
        cUsuario objusu = new cUsuario();
        cUsuario usu = new cUsuario();
        HttpSession sesion = request.getSession();
        
        String login = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        
        Vector vUsuario = new Vector();
        objusu.validar(login, clave);
        usu.validar(login, clave);
        System.out.println(" Valor = " + val);
        System.out.println(" usuario= " +objusu.toString());
        if (val.equals("ING")) 
        {
            if (objusu.getIdUsuario() != 0) 
            {
                System.out.println("se encontro al usuario en el servlet");
                System.out.println("tipo "+objusu.getTipo());
                if(objusu.getTipo().equals("a"))
                {

                    sesion.removeAttribute("usu");//cualquier nombre
                    sesion.setAttribute("usu", usu);
                    request.setAttribute("objusu", objusu);
                    rd = getServletContext().getRequestDispatcher("/PrincipalHD.jsp");
                    System.out.println("se mando al iframe principalhd");
                    rd.forward(request, response);
                }
                else
                if(objusu.getTipo().equals("s"))
                        {

                         sesion.removeAttribute("usu");//cualquier nombre
                         sesion.setAttribute("usu", usu);
                         request.setAttribute("objusu", objusu);
                         rd = getServletContext().getRequestDispatcher("/PrincipalHD1.jsp");
                         System.out.println("se mando al iframe principalhd");
                         rd.forward(request, response);     

                        }
//            
            
            }
            else     {
                 rd = getServletContext().getRequestDispatcher("/login.jsp?vel=nos");
             rd.forward(request, response);}
           /*  else
          {
          
          out.println("<html>");
                    out.println("<head>");
                     
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>intentelo de nuevo</h3>");
                    out.println("</body>");
                    out.println("</html>");
                    out.close();
          
          }*/
          
         } 
        else if (val.equals("CE")) 
        {
            cUsuario usi=new cUsuario();
           // HttpSession sesion = request.getSession();
          
            sesion.getAttribute("usu");
            sesion.invalidate();
            
            System.out.println(" cerrado");
            rd = getServletContext().getRequestDispatcher("/login2.jsp");
            rd.forward(request, response);

        }
       

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
