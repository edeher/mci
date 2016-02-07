/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cCelula;
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

/**
 *
 * @author Ing. Edeher
 */
@WebServlet(name = "sCelula", urlPatterns = {"/sCelula"})
public class sCelula extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd=null;
        int vcodigos=0;
        vcodigos=Integer.parseInt(request.getParameter("vcodigo"));
         
         cCelula objcel=new cCelula();
         objcel.Buscarcelu2(vcodigos);
         
         System.out.println("servlet sCelulas ..aca esta el codigo de celula "+ vcodigos);
         
         if(objcel.Buscarcelu2(vcodigos))
         {
         System.out.println("se encontro");
         System.out.println("servlet id de celula = "+objcel.getIdCelula());
         System.out.println(" direcion = "+objcel.getDireccion()) ;
         System.out.println(" referencia = "+objcel.getReferencia()) ;
         System.out.println(" dia= "+objcel.getDia_realiza()) ;
         System.out.println(" hora = "+objcel.getHora_realiza()) ;
         System.out.println(" fecha = "+objcel.getFecha_apertura()) ;
         System.out.println(" telefono = "+objcel.getTelefono()) ;
         System.out.println("servlet  tipo = "+objcel.getTipocelula()) ;
                             
        }     
         
         
         
          if (objcel.Buscarcelu2(vcodigos))
             {
         System.out.println("servlets  prueba celula : "+ objcel.getDireccion());
         request.setAttribute("objcel",objcel);
         System.out.println("servlet enviando id= "+objcel.getIdCelula());
         rd= getServletContext().getRequestDispatcher("/celugrama.jsp?val=entro");
         
         rd.forward(request,response);
         
         System.out.println(" se va al jsp celugrama DESDE EL SERVLET celula") ;
                 
             }
          else
          {
          
          out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet sUsuarios</title>");  
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>intentelo de nuevo</h3>");
                    out.println("</body>");
                    out.println("</html>");
                    out.close();
          
          }
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
