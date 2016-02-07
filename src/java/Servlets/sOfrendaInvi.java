/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cCelula;
import Clases.cMiembro;
import Clases.cOfrendaInvitados;
import Clases.cRedTrabajo;
import Clases.cTipoCelula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;

/**
 *
 * @author Mi Laptop
 */
@WebServlet(name = "sOfrendaInvi", urlPatterns = {"/sOfrendaInvi"})
public class sOfrendaInvi extends HttpServlet {

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
        RequestDispatcher rd=null;
        String val=request.getParameter("val");
        
       int nroinvitados=Integer.parseInt(request.getParameter("txtnroinvitados"));
       int vidcelulaOfrenda=Integer.parseInt(request.getParameter("txtidcelula"));
       int vidperiodoofrenda=Integer.parseInt(request.getParameter("txtperiodoactual"));
       double vmonto=Double.parseDouble(request.getParameter("txtmonto"));
      
       switch (val)
       {
           case "BUS1":
                cOfrendaInvitados objOfre= new cOfrendaInvitados();
                System.out.println("entro a la opcion de grabar");
                if(objOfre.Crear2(vidcelulaOfrenda,vidperiodoofrenda,vmonto,nroinvitados))
                {
                rd = getServletContext().getRequestDispatcher("/celugrama.jsp?val=entro");
                rd.forward(request, response);
                }
           break;
           default:
               System.out.println("opcion no ingresada");
               break;
       
       
       }
        
//       
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
