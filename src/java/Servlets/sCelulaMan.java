/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cCelula;
import Clases.cMiembro;
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

/**
 *
 * @author Mi Laptop
 */
@WebServlet(name = "sCelulaMan", urlPatterns = {"/sCelulaMan"})
public class sCelulaMan extends HttpServlet {

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
        cMiembro objmie=new cMiembro();
        cCelula objcel=new cCelula();
        Vector vCelula=new Vector();
        cTipoCelula objtcel=new cTipoCelula();
        Vector vtipocelula=new Vector();
        cRedTrabajo objred=new cRedTrabajo();
        Vector vredtrabajo=new Vector();
        String tipocel="";
        String ano= " ";
        String fecha="";
        String direccion="";
        String referencia="";
        String diarea="";
       int codigopersona=0;
            int tipocelula=0;  
        String telefono="";
        int tipocell=0;
        String nro="";
        int red=0;
        String estado="";
        String hora="";
        
        
        int cboint=0;
        if(val.equals("MOS"))
        {
            vCelula=objcel.BuscarTodot();
           if(objcel!=null){
             System.out.println("entrando al if");
             for(int i=0;i<vCelula.size();i++ ){
                 System.out.println("entrando al for de servlet");
                     objcel=(cCelula)vCelula.elementAt(i);
         System.out.println("se encontro");
         System.out.println("codigo "+objcel.toString());

                 }   
           }  
            request.setAttribute("vCelula",vCelula);
            rd= getServletContext().getRequestDispatcher("/manCelulas.jsp");
            rd.forward(request,response);
        }
        
         if(val.equals("BUS"))
        {

            vCelula=objcel.Buscar3(request.getParameter("txtNombre").toString().toUpperCase());
            if(objcel!=null){
             System.out.println("entrando al if de buscar");
             for(int i=0;i<vCelula.size();i++ ){
                 System.out.println("entrando al for de buscar");
                     objcel=(cCelula)vCelula.elementAt(i);
         System.out.println("se encontro");
         System.out.println("codigo "+objcel
                 .toString());

                 }   
           } 
            request.setAttribute("vCelula",vCelula);
            rd= getServletContext().getRequestDispatcher("/manCelulas.jsp");
            rd.forward(request,response);
        }
        if(val.equals("BUS1"))
        {

            vCelula=objcel.Buscar4(Integer.parseInt(request.getParameter("txtid")));
            if(objcel!=null){
             System.out.println("entrando al if de buscar");
             for(int i=0;i<vCelula.size();i++ ){
                 System.out.println("entrando al for de buscar");
                     objcel=(cCelula)vCelula.elementAt(i);
         System.out.println("se encontro");
         System.out.println("codigo "+objcel
                 .toString());

                 }   
           } 
            request.setAttribute("vCelula",vCelula);
            rd= getServletContext().getRequestDispatcher("/manCelulas.jsp");
            rd.forward(request,response);
        }
      
        if(val.equals("NUE"))

        {
            
            System.out.println("este es val ENTRANDO POR SEGUNDA VEZ:"+val);
            
           
            hora=request.getParameter("txthora")+":"+request.getParameter("txtmin")+" "+request.getParameter("txtpm");
         
            codigopersona=Integer.parseInt(request.getParameter("cbolider"));
            tipocelula=Integer.parseInt(request.getParameter("cbotipocel"));
            System.out.println("idpersona :"+codigopersona);
            System.out.println("tipocelula  :"+tipocelula);
            
            if(objmie.CelulaDoble(codigopersona,tipocelula) )
            {
                
             System.out.println("tiene discipulado."+objmie.getIdMiembro());
                     rd = getServletContext().getRequestDispatcher("/frmCelulas.jsp?&vRespuesta=1");
                     rd.forward(request,response);
            }
            else
            {
            int codigocelula=objcel.Crear2(
                    Integer.parseInt(request.getParameter("cbotipocel")),
                    request.getParameter("txtdireccion").toString().toUpperCase(),
                    request.getParameter("txtreferencia").toString().toUpperCase(),
                    request.getParameter("txtdiarea").toString().toUpperCase(),
                    hora,
                    request.getParameter("txtfechaape").toString().toUpperCase(),
                    request.getParameter("txttelefono").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotipored"))
                    );
             if(objmie.Crear(codigopersona,codigocelula,1,"a"," ","n")
                           )
            {
                rd= getServletContext().getRequestDispatcher("/frmCelulas.jsp?&vRespuesta=2");
                      rd.forward(request,response);
            }
            
            
        }
        }
        if(val.equals("MOD"))
        {
             System.out.println("entrando a modificar:"+val);
            
           
            hora=request.getParameter("txthora")+":"+request.getParameter("txtmin")+" "+request.getParameter("txtpm");
         
//            codigopersona=Integer.parseInt(request.getParameter("cbolider"));
//            tipocelula=Integer.parseInt(request.getParameter("cbotipocel"));
//            System.out.println("idpersona :"+codigopersona);
//            System.out.println("tipocelula  :"+tipocelula);
            
//            if(objmie.CelulaDoble(codigopersona,tipocelula) )
//            {
//                
//             System.out.println("tiene discipulado."+objmie.getIdMiembro());
//                     rd = getServletContext().getRequestDispatcher("/frmCelulas.jsp?&vRespuesta=1");
//                     rd.forward(request,response);
//            }
//            else
            if( objcel.Modificar(Integer.parseInt(request.getParameter("txtcodigo")),
                    Integer.parseInt(request.getParameter("cbotipocel")),
                    request.getParameter("txtdireccion").toString().toUpperCase(),
                    request.getParameter("txtreferencia").toString().toUpperCase(),
                    request.getParameter("txtdiarea").toString().toUpperCase(),
                    hora,
                    request.getParameter("txtfechaape").toString().toUpperCase(),
                    request.getParameter("txttelefono").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotipored"))
                    )
                    )
            
            {
                int vidCelula=Integer.parseInt(request.getParameter("txtcodigo"));
                 System.out.println("codigo enviando si o si  :"+vidCelula);
                rd= getServletContext().getRequestDispatcher("/frmCelulas.jsp?val=MOD&vidCelula="+vidCelula+"&vRespuesta=2");
                      rd.forward(request,response);
            }
            
               
        
        }
        if(val.equals("RECARGA"))
        {
             vCelula=objcel.BuscarTodot();
             request.setAttribute("vCelula",vCelula);
            rd = getServletContext().getRequestDispatcher("/manCelulas.jsp?&vRespuesta=2");
            rd.forward(request,response);

        }
        
           if(val.equals("E"))
        {
            int vcodigo=Integer.parseInt(request.getParameter("vcodigo"));

            if(objcel.ModificarEstado(vcodigo))
            {
                vCelula=objcel.BuscarTodot();
                request.setAttribute("vCelula",vCelula);
                rd= getServletContext().getRequestDispatcher("/mensaje.jsp?vel=sCelulaMan");
                rd.forward(request,response);
            }
            else
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }
        }
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ScelulaMan</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sCelulaMan at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
