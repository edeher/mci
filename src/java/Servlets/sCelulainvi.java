/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Clases.cInvitado;
import Clases.cMiembro;
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

/**
 *
 * @author Ing. Edeher
 */
@WebServlet(name = "sCelulainvi", urlPatterns = {"/sCelulainvi"})
public class sCelulainvi extends HttpServlet {

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
        
        cInvitado objinvi=new cInvitado();
        Vector vInvitado=new Vector();
//        cTipoPersona objtper=new cTipoPersona();
//        Vector vtipopersona=new Vector();
//        cTipoIdentidad objtide=new cTipoIdentidad();
//        Vector vtipoidentidad=new Vector();
//        cMiembro objmie=new cMiembro();
        String nombre="";
        String ano= " ";
        String fecha="";
        String apaterno="";
        String amaterno="";
        int idcelula=0;
        int idperiodo=0;
        String direcion="";
        String referencia="";
        String telefono="";
        int idtipo=0;
        String nro="";
        int idper=0;
        String profesio="";
        String obser="";
        String sexo="";
        int cboint=0;
        String estado="A";
         if(val.equals("NUE"))

        {
            
            System.out.println("este es val ENTRANDO POR SEGUNDA VEZ:"+val);
            ano=request.getParameter("txtano").toString().toUpperCase();
            fecha=request.getParameter("txtdia")+"-"+request.getParameter("txtmes")+"-"+request.getParameter("txtano");
            nombre=request.getParameter("txtnombres").toString().toUpperCase();
             apaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
             amaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
             sexo= request.getParameter("txtsexo");
             direcion=request.getParameter("txtdireccion").toString().toUpperCase();
            referencia=request.getParameter("txtreferencia").toString().toUpperCase();
            telefono=request.getParameter("txttelefono").toString().toUpperCase();
             idcelula= Integer.parseInt(request.getParameter("txtidcelula"));
             idperiodo=Integer.parseInt(request.getParameter("txtidperiodo"));
             System.out.println("nombre :"+nombre);
            System.out.println("apaterno :"+apaterno);
            System.out.println("amaterno :"+amaterno);
            System.out.println("sexo:"+sexo);
            System.out.println("direccion :"+direcion);
            System.out.println("referencia :"+referencia);
            System.out.println("telefono:"+telefono);
            System.out.println("idcelula:"+idcelula);
             System.out.println("idPeriodo:"+idperiodo);
            System.out.println("fecha :"+fecha);
            System.out.println("ano mod :"+ano);
            System.out.println("fecha mod:"+fecha);
            
//          int vcodigo=objP.Crear2(
//                    request.getParameter("txtnombres").toString().toUpperCase(),
//                    request.getParameter("txtapepaterno").toString().toUpperCase(),
//                    request.getParameter("txtapematerno").toString().toUpperCase(),
//                    request.getParameter("txtsexo"),
//                    request.getParameter("txtdireccion").toString().toUpperCase(),
//                    request.getParameter("txtreferencia").toString().toUpperCase(),
//                    fecha,
//                    request.getParameter("txttelefono").toString().toUpperCase(),
//                    Integer.parseInt(request.getParameter("cbotipodoc")),
//                    request.getParameter("txtnrodni").toString().toUpperCase(),
//                    Integer.parseInt(request.getParameter("cbotipoper")),
//                    request.getParameter("txtprofesion").toString().toUpperCase(),
//                    request.getParameter("txtobservacion").toString().toUpperCase()
//                    );
                    
                    
                
                
              
            if(
               objinvi.Crear(idcelula, idperiodo, nombre, apaterno, amaterno, sexo, direcion, referencia, fecha, telefono, estado)
                       )
                
             {
                 int idCelula=Integer.parseInt(request.getParameter("txtidcelula"));
                  int idPeriodo=Integer.parseInt(request.getParameter("txtidperiodo"));
                rd= getServletContext().getRequestDispatcher("/frmCelulaInvi.jsp?idcelula="+idCelula+"&idperiodo="+idPeriodo);
                rd.forward(request,response);
                
            }
           
           else 
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }
//                
           
            
        }
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet sCelulainvi</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet sCelulainvi at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {
//            out.close();
//        }
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
