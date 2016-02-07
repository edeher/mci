/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cCelula;
import Clases.cPersona;
import Clases.cTipoIdentidad;
import Clases.cTipoPersona;
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
@WebServlet(name = "sPersona", urlPatterns = {"/sPersona"})
public class sPersona extends HttpServlet {

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
        int codigo = 0;
        codigo =Integer.parseInt( request.getParameter("vcodigo"));
        System.out.println(" llego codigo = "+codigo) ; 
        cPersona per=new cPersona();   
        
        per.Buscar(codigo);
        System.out.println("persona  "+per.toString());
        
        cCelula objcel=new cCelula();
               
        Vector vCelula=objcel.Buscarnroscelu2(codigo);

         if(objcel!=null )
         {
              System.out.println("se encontro celula");
             int cont=0;      
             for(int i=0;i<vCelula.size();i++ ){
             objcel=(cCelula)vCelula.elementAt(i);
             
             System.out.println("se encontro");
             System.out.println("celula "+objcel.getIdCelula());
             System.out.println("nro "+(i+1));
             cont=i+1;

          }  
         
             if((cont)>=2)
             {
             
            request.setAttribute("per",per);
            rd= getServletContext().getRequestDispatcher("/numerocelulas.jsp");
            rd.forward(request,response);
             }
        
        
         else  
            {
                         

             if (per != null)
             {
                    
                 request.setAttribute("per",per);
                 rd= getServletContext().getRequestDispatcher("/celugrama.jsp?val=entro");
                 rd.forward(request,response);
                
                
            }
                
        
            }
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
