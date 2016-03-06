/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Clases.cCelula;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ing. Edeher
 */
@WebServlet(name = "sCelulainte", urlPatterns = {"/sCelulainte"})
public class sCelulainte extends HttpServlet {

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
       
        
        cMiembro objmie=new cMiembro();
        String nombre="";
        HttpSession sesion = request.getSession();
        String fechanac="";
        String apaterno="";
        String amaterno="";
        int idcelula=0;
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
        //menu con switch
//        switch (val)
//        {
//            case "NUE":
//                        cMiembro objmi=new cMiembro();
//                        int dni=Integer.parseInt(request.getParameter("txtnrodni"));
//                        idcelula= Integer.parseInt(request.getParameter("txtidcelula"));
//                        System.out.println("DNI :"+dni);
//                        if(objmi.BuscarMiembroRepetido(dni))
//
//                        {
//                             System.out.println("esta en otra celula.......");
//                                 rd = getServletContext().getRequestDispatcher("/frmCelulaInte1.jsp?idcelula="+idcelula+"&vRespuesta=1");
//                                 rd.forward(request,response);
//                        } 
//                        else 
//                         {    
//                            System.out.println("este es val ENTRANDO POR SEGUNDA VEZ2:"+val);
//                            fechanac=request.getParameter("txtfecha").toString().toUpperCase();
//                            nombre=request.getParameter("txtnombres").toString().toUpperCase();
//                            apaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
//                            amaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
//                            sexo= request.getParameter("txtsexo");
//                            direcion=request.getParameter("txtdireccion").toString().toUpperCase();
//                            referencia=request.getParameter("txtreferencia").toString().toUpperCase();
//                            telefono=request.getParameter("txttelefono").toString().toUpperCase();
//                            idtipo=Integer.parseInt(request.getParameter("cbotipodoc"));
//                            nro=request.getParameter("txtnrodni").toString().toUpperCase();
//                            idper=Integer.parseInt(request.getParameter("cbotipoper"));
//                            profesio=request.getParameter("txtprofesion").toString().toUpperCase();
//                            obser= request.getParameter("txtobservacion").toString().toUpperCase();
//                            idcelula= Integer.parseInt(request.getParameter("txtidcelula"));
//                            System.out.println("fecha de nacimiento :"+fechanac);
//                            int vcodigo=objP.Crear2
//                                (
//                                request.getParameter("txtnombres").toString().toUpperCase(),
//                                request.getParameter("txtapepaterno").toString().toUpperCase(),
//                                request.getParameter("txtapematerno").toString().toUpperCase(),
//                                request.getParameter("txtsexo"),
//                                request.getParameter("txtdireccion").toString().toUpperCase(),
//                                request.getParameter("txtreferencia").toString().toUpperCase(),
//                                request.getParameter("txtfecha").toString().toUpperCase(),
//                                request.getParameter("txttelefono").toString().toUpperCase(),
//                                Integer.parseInt(request.getParameter("cbotipodoc")),
//                                request.getParameter("txtnrodni").toString().toUpperCase(),
//                                Integer.parseInt(request.getParameter("cbotipoper")),
//                                request.getParameter("txtprofesion").toString().toUpperCase(),
//                                request.getParameter("txtobservacion").toString().toUpperCase()
//                                );
//                            System.out.println(" persona en servlet : "+vcodigo);
//                            if(objmie.Crear(vcodigo,Integer.parseInt(request.getParameter("txtidcelula")),2,"a"," ","n"))
//
//                                {
//                                  cCelula objcel=new cCelula();
//                                  objcel.Buscarcelu2(idcelula);
//                                  request.setAttribute("objcel",objcel);
//                                  rd= getServletContext().getRequestDispatcher("/frmCelulaInte1.jsp?idcelula="+idcelula+"&vRespuesta=2");
//                                  rd.forward(request,response);
//
//                                 }
//                            }
//                                 break;
//            case "RECARGA":
//                             rd = getServletContext().getRequestDispatcher("/celugrama.jsp?val=entro&vRespuesta=2");
//                             rd.forward(request,response);
//                             break;
//            case "BUS1":
//                             String anio= request.getParameter("txtyear");
//                             String mes= request.getParameter("txtmoht");
//                             System.out.println("servlet , año : "+anio+ ", mes :"+mes);
//                             rd= getServletContext().getRequestDispatcher("/celugrama.jsp?val=BUS1&anio="+anio+"&mes="+mes+"");
//                             rd.forward(request,response);
//                            break;
//            case "busca":
//                            cMiembro objmi2=new cMiembro();
//                            int dni2=Integer.parseInt(request.getParameter("txtnrodni"));
//                            System.out.println("DNI :"+dni2);
//                            objmi2.BuscarMiembroRepetido(dni2);
//                            System.out.println("persona :"+objmi2.getIdPersona());
//
//                            if(objmi2!=null)
//                            {
//                            rd= getServletContext().getRequestDispatcher("/frmCelulaInte.jsp?vel=entro");
//                            rd.forward(request,response);  
//                            }
//                            else
//                                {
//                            rd= getServletContext().getRequestDispatcher("/frmCelulaInte.jsp");
//                            rd.forward(request,response);
//                            }
//
//
//        }
//      
         System.out.println("este es val ENTRANDO POR SEGUNDA VEZ:"+val);
        if(val.equals("NUE"))

        {           
            cMiembro objmi=new cMiembro();
            int dni=Integer.parseInt(request.getParameter("txtnrodni"));
            idcelula= Integer.parseInt(request.getParameter("txtidcelula"));
            System.out.println("DNI :"+dni);
            
            
            if(objmi.BuscarMiembroRepetido(dni))
            
            {
                 System.out.println("esta en otra celula.......");
                     rd = getServletContext().getRequestDispatcher("/frmCelulaInte1.jsp?idcelula="+idcelula+"&vRespuesta=1");
                     rd.forward(request,response);
                    
                     
               
            } 
            else 
             {    
                System.out.println("este es val ENTRANDO POR SEGUNDA VEZ2:"+val);
                fechanac=request.getParameter("txtfecha").toString().toUpperCase();
                nombre=request.getParameter("txtnombres").toString().toUpperCase();
                apaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
                amaterno=request.getParameter("txtapepaterno").toString().toUpperCase();
                sexo= request.getParameter("txtsexo");
                direcion=request.getParameter("txtdireccion").toString().toUpperCase();
                referencia=request.getParameter("txtreferencia").toString().toUpperCase();
                telefono=request.getParameter("txttelefono").toString().toUpperCase();
                idtipo=Integer.parseInt(request.getParameter("cbotipodoc"));
                nro=request.getParameter("txtnrodni").toString().toUpperCase();
                idper=Integer.parseInt(request.getParameter("cbotipoper"));
                profesio=request.getParameter("txtprofesion").toString().toUpperCase();
                obser= request.getParameter("txtobservacion").toString().toUpperCase();
                idcelula= Integer.parseInt(request.getParameter("txtidcelula"));
                System.out.println("fecha de nacimiento :"+fechanac);
                      int vcodigo=objP.Crear2
                    (
                    request.getParameter("txtnombres").toString().toUpperCase(),
                    request.getParameter("txtapepaterno").toString().toUpperCase(),
                    request.getParameter("txtapematerno").toString().toUpperCase(),
                    request.getParameter("txtsexo"),
                    request.getParameter("txtdireccion").toString().toUpperCase(),
                    request.getParameter("txtreferencia").toString().toUpperCase(),
                    request.getParameter("txtfecha").toString().toUpperCase(),
                    request.getParameter("txttelefono").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotipodoc")),
                    request.getParameter("txtnrodni").toString().toUpperCase(),
                    Integer.parseInt(request.getParameter("cbotipoper")),
                    request.getParameter("txtprofesion").toString().toUpperCase(),
                    request.getParameter("txtobservacion").toString().toUpperCase()
                    );
                    System.out.println(" persona en servlet : "+vcodigo);
                    if(objmie.Crear(vcodigo,Integer.parseInt(request.getParameter("txtidcelula")),2,"a"," ","n")
                           )

                    {
                      cCelula objcel=new cCelula();
                      objcel.Buscarcelu2(idcelula);
                      request.setAttribute("objcel",objcel);
                      rd= getServletContext().getRequestDispatcher("/frmCelulaInte1.jsp?idcelula="+idcelula+"&vRespuesta=2");
                      rd.forward(request,response);

                     }
             }
        }  
       
        if(val.equals("RECARGA"))
        {
            rd = getServletContext().getRequestDispatcher("/celugrama.jsp?val=entro&vRespuesta=2");
            rd.forward(request,response);

        }
        if(val.equals("BUS1"))
            {
                 String anio= request.getParameter("txtyear");
                 String mes= request.getParameter("txtmoht");
                 System.out.println("servlet , año : "+anio+ ", mes :"+mes);

                rd= getServletContext().getRequestDispatcher("/celugrama.jsp?val=BUS1&anio="+anio+"&mes="+mes+"");
                rd.forward(request,response);
                
            }
        
            if(val.equals("busca"))
            {
                cMiembro objmi=new cMiembro();
             
                int dni=Integer.parseInt(request.getParameter("txtnrodni"));
                System.out.println("DNI :"+dni);
                objmi.BuscarMiembroRepetido(dni);
                System.out.println("persona :"+objmi.getIdPersona());
                
                if(objmi!=null)
                {
                rd= getServletContext().getRequestDispatcher("/frmCelulaInte.jsp?vel=entro");
                rd.forward(request,response);
                }
                else
                    {
                rd= getServletContext().getRequestDispatcher("/frmCelulaInte.jsp");
                rd.forward(request,response);
                }
            }
            
      
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sCelulainte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>no existe asistencia </h1>");
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
