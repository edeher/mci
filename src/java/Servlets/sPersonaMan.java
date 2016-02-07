/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
 * @author Mi Laptop
 */
@WebServlet(name = "sPersonaMan", urlPatterns = {"/sPersonaMan"})
public class sPersonaMan extends HttpServlet {

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
        
        cPersona objP=new cPersona();
        Vector vPersona=new Vector();
        cTipoPersona objtper=new cTipoPersona();
        Vector vtipopersona=new Vector();
        cTipoIdentidad objtide=new cTipoIdentidad();
        Vector vtipoidentidad=new Vector();
        String nombre="";
        String ano= " ";
        String fecha="";
        String apaterno="";
        String amaterno="";
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
        if(val.equals("MOS"))
        {
            vPersona=objP.BuscarTodo();
           if(objP!=null){
             System.out.println("entrando al if");
             for(int i=0;i<vPersona.size();i++ ){
                 System.out.println("entrando al for de servlet");
                     objP=(cPersona)vPersona.elementAt(i);
         System.out.println("se encontro");
         System.out.println("codigo "+objP.toString());

                 }   
           }  
            request.setAttribute("vPersona",vPersona);
            rd= getServletContext().getRequestDispatcher("/manPersonas.jsp");
            rd.forward(request,response);
        }
        
         if(val.equals("BUS"))
        {

            vPersona=objP.Buscar3(request.getParameter("txtNombre").toString().toUpperCase());
            if(objP!=null){
             System.out.println("entrando al if de buscar");
             for(int i=0;i<vPersona.size();i++ ){
                 System.out.println("entrando al for de buscar");
                     objP=(cPersona)vPersona.elementAt(i);
         System.out.println("se encontro");
         System.out.println("codigo "+objP.toString());

                 }   
           } 
            request.setAttribute("vPersona",vPersona);
            rd= getServletContext().getRequestDispatcher("/manPersonas.jsp");
            rd.forward(request,response);
        }
        
       /* if(val.equals("N"))
        {
            System.out.println(" entrando al servlet POR PRIMERA VEZ");
            vtipopersona=objtper.BuscarTodo();
            vtipoidentidad=objtide.BuscarTodo();
            
            request.setAttribute("vtipopersona",vtipopersona);
            request.setAttribute("vtipoidentidad",vtipoidentidad);
            System.out.println(" llamando al frm");
            rd= getServletContext().getRequestDispatcher("/frmPersonas.jsp?val=NUE");
            rd.forward(request,response);
        }*/
        if(val.equals("NUE"))

        {
            
            System.out.println("este es val ENTRANDO POR SEGUNDA VEZ:"+val);
         
            if(objP.Crear(
                    request.getParameter("txtnombres").toString().toUpperCase(),
                    request.getParameter("txtapepaterno").toString().toUpperCase(),
                    request.getParameter("txtapematerno").toString().toUpperCase(),
                    request.getParameter("txtsexo"),
                    request.getParameter("txtdireccion").toString().toUpperCase(),
                    request.getParameter("txtreferencia").toString().toUpperCase(),
                    request.getParameter("txtfechanac").toString().toUpperCase(),
                    request.getParameter("txttelefono").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotiidentidad")),
                    request.getParameter("txtnroidentidad").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotitipopersona")),
                    request.getParameter("txtprofesion").toString().toUpperCase(),
                    request.getParameter("txtobservacion").toString().toUpperCase()
                    )
                    
                    )
                
            {
                vPersona=objP.BuscarTodo();
                request.setAttribute("vPersona",vPersona);
                rd= getServletContext().getRequestDispatcher("/manPersonas.jsp");
                rd.forward(request,response);
            }
            
            else
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }
            System.out.println("CREADO LA PERSONA:");
        }
        
         if(val.equals("M"))
        {
//
            System.out.println(" entrando al servlet");
           int vcodigo=Integer.parseInt(request.getParameter("vcodigo"));

            System.out.println(" codigo es: "+vcodigo);

            objP.Buscar(vcodigo);
               
            if(objP!=null){
            System.out.println("la persona es:"+objP.toString());
            vtipopersona=objtper.BuscarTodo();
            vtipoidentidad=objtide.BuscarTodo();
            
            request.setAttribute("vtipopersona",vtipopersona);
            request.setAttribute("vtipoidentidad",vtipoidentidad);
            request.setAttribute("objP",objP);
             System.out.println(" en caminno ");
            rd= getServletContext().getRequestDispatcher("/frmPersonas.jsp?val=MOD");
            rd.forward(request,response);
            }
        }
         if(val.equals("MOD"))
        {
            String vcodigo=request.getParameter("txtCodigo");
            System.out.println("este es el codigo : "+vcodigo);
             System.out.println("este es val ENTRANDO POR tercera VEZ : "+val);
           
           
            apaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
             amaterno=request.getParameter("txtapematerno").toString().toUpperCase();
             sexo=request.getParameter("txtsexo").toString().toUpperCase();
             direcion=request.getParameter("txtdireccion").toString().toUpperCase();
             referencia=request.getParameter("txtreferencia").toString().toUpperCase();
             
            telefono=request.getParameter("txttelefono").toString().toUpperCase();
            idtipo=Integer.parseInt(request.getParameter("cbotiidentidad"));
            nro=request.getParameter("txtnroidentidad").toString().toUpperCase();
            idper=Integer.parseInt(request.getParameter("cbotitipopersona"));
            System.out.println("ano :"+ano);
            System.out.println("fecha :"+fecha);
            System.out.println("nombres :"+nombre);
            System.out.println("paterno :"+apaterno);
            System.out.println("materno :"+amaterno);
            System.out.println("direccion :"+direcion);
            System.out.println("referencia :"+referencia);
            System.out.println("telefono :"+telefono);
            System.out.println("tipo 1 :"+idtipo);
            System.out.println("nro :"+nro);
            System.out.println("idper :"+idper);
            System.out.println("sexo en el servlet :"+sexo);
              System.out.println("modificando ");
            if(
                  
                    objP.Modificar(
                            
                    Integer.parseInt(request.getParameter("txtCodigo")),
                    request.getParameter("txtnombres").toString().toUpperCase(),
                    request.getParameter("txtapepaterno").toString().toUpperCase(),
                    request.getParameter("txtapematerno").toString().toUpperCase(),
                    request.getParameter("txtsexo"),
                    request.getParameter("txtdireccion").toString().toUpperCase(),
                    request.getParameter("txtreferencia").toString().toUpperCase(),
                    request.getParameter("txtfechanac").toString().toUpperCase(),
                    request.getParameter("txttelefono").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotiidentidad")),
                    request.getParameter("txtnroidentidad").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotitipopersona")),
                    request.getParameter("txtprofesion").toString().toUpperCase(),
                    request.getParameter("txtobservacion").toString().toUpperCase()
                    )
                    )
            {
                vPersona=objP.BuscarTodo();
                request.setAttribute("vPersona",vPersona);
                rd= getServletContext().getRequestDispatcher("/manPersonas.jsp");
                rd.forward(request,response);
                  System.out.println("modificdo ");
            }
            else
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }

//
         }
           if(val.equals("E"))
        {
            int vcodigo=Integer.parseInt(request.getParameter("vcodigo"));

            if(objP.Eliminar(vcodigo))
            {
                vPersona=objP.BuscarTodo();
                request.setAttribute("vPersona",vPersona);
                rd= getServletContext().getRequestDispatcher("/mensaje.jsp?vel=sPersonas");
                rd.forward(request,response);
            }
            else
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }
        }
        try {
            /* TODO output your page here */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sPersonas</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sPersonas at " + request.getContextPath () + "</h1>");
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
