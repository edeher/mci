/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cAsistencia;
import Clases.cCelula;
import Clases.cPeriodo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ing. Edeher
 */
@WebServlet(name = "sCelulaAsis", urlPatterns = {"/sCelulaAsis"})
public class sCelulaAsis extends HttpServlet {

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
        int idcelula = 0;
        String val = request.getParameter("val");
        idcelula = Integer.parseInt(request.getParameter("txtidcelula"));
        cCelula objcel = new cCelula();
        int ii = 0;
        int jj = 0;
        cAsistencia objasi = new cAsistencia();

        System.out.println("val" + val);
        objcel.Buscarcelu2(idcelula);

        if (val.equals("GRA")) 
        {
            int vCanMie = Integer.parseInt(request.getParameter("hdTotalMiembros"));
            int vPeriodo = Integer.parseInt(request.getParameter("txtperiodo"));
            System.out.println("entrando a grabar asistencia." + vPeriodo+" total de miembros es :"+vCanMie);
            for (int i = 0; i < vCanMie; i++) 
            {
                System.out.println("for  "+i);
                String vAsistencia = request.getParameter("chb_" + i);
                System.out.println("idmiembro de asistencia pes......" + vAsistencia);
                if (vAsistencia != null) {
                    objasi.Crear(vPeriodo, Integer.parseInt(vAsistencia), "a", "ok");
                    System.out.println("se grabo asisten.......");
                    System.out.println("se grabo.....dice...aaaa.");

                    
                }

            }
        if (objcel != null) {
                        System.out.println("servlets  prueba " + objcel.getDireccion());
                        request.setAttribute("objcel", objcel);
                        rd = getServletContext().getRequestDispatcher("/celugrama.jsp");

                        rd.forward(request, response);
                        System.out.println(" se va al jsp celugrama");

                    } else {

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
