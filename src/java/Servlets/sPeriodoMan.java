/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.cPeriodo;
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
@WebServlet(name = "sPeriodoMan", urlPatterns = {"/sPeriodoMan"})
public class sPeriodoMan extends HttpServlet {

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
        
        cPeriodo objPeri=new cPeriodo();
        Vector vPeriodo=new Vector();
        
        int cboint=0;
        if(val.equals("MOS"))
        {
            vPeriodo=objPeri.BuscarTodo();
           if(objPeri!=null)
           {
             System.out.println("entrando al if");
             for(int i=0;i<vPeriodo.size();i++ )
             {
                System.out.println("entrando al for de servlet");
                objPeri=(cPeriodo)vPeriodo.elementAt(i);
                System.out.println("se encontro");
                System.out.println("todos "+objPeri.toString());

                 }   
           }  
            request.setAttribute("vPeriodo",vPeriodo);
            rd= getServletContext().getRequestDispatcher("/manPeriodo.jsp");
            rd.forward(request,response);
            System.out.println("se va al man de periodo ");
        }
        
         if(val.equals("MOS1"))
        {

            vPeriodo=objPeri.BuscarTodo2();
            
            if(objPeri!=null){
             System.out.println("entrando al if de buscar por id");
             for(int i=0;i<vPeriodo.size();i++ ){
                 System.out.println("entrando al for de buscar por id");
                     objPeri=(cPeriodo)vPeriodo.elementAt(i);
         System.out.println("se encontro por id");
         System.out.println("Miembro por codigo "+objPeri.toString2());

                 }   
           } 
            request.setAttribute("vPeriodo",vPeriodo);
            rd= getServletContext().getRequestDispatcher("/manPeriodo.jsp");
            rd.forward(request,response);
        }
         if(val.equals("BUS1"))
         {
             int mes=Integer.parseInt(request.getParameter("txtmes"));
             int semana=Integer.parseInt(request.getParameter("txtsemana"));
             System.out.println("mes y semana"+mes+""+semana);
             vPeriodo=objPeri.Buscar2(mes, semana);
             
             if(objPeri!=null)
             {
             System.out.println("entrando al if de buscar por id");
             for(int i=0;i<vPeriodo.size();i++ )
             {
                System.out.println("entrando al for de buscar por mes y semana");
                objPeri=(cPeriodo)vPeriodo.elementAt(i);
                System.out.println("se encontro por mes y semana");
                System.out.println("periodo por mes y semana "+objPeri.toString2());

                 }   
           } 
            request.setAttribute("vPeriodo",vPeriodo);
            rd= getServletContext().getRequestDispatcher("/manPeriodo.jsp");
            rd.forward(request,response);
         }
       
        if(val.equals("NUE"))

        {
            
            System.out.println("este es val ENTRANDO POR SEGUNDA VEZ:"+val);
            
            if(objPeri.Crear2(
                    Integer.parseInt(request.getParameter("txtaño")),
                    Integer.parseInt(request.getParameter("txtmes")),
                    Integer.parseInt(request.getParameter("txtsemana")),
                    request.getParameter("txtfechaini").toString().toUpperCase(),
                    request.getParameter("txtfechafin").toString().toUpperCase(),
                    request.getParameter("txttema1").toString().toUpperCase(),
                    request.getParameter("txttema2").toString().toUpperCase(),
                    request.getParameter("txtestado").toString().toUpperCase()
                    )
                    
                    )
                
            {
                vPeriodo=objPeri.BuscarTodo();
                request.setAttribute("vPeriodo",vPeriodo);
                rd= getServletContext().getRequestDispatcher("/manPeriodo.jsp");
                rd.forward(request,response);
            }
            
            else
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }
            System.out.println("CREANDO EL PERIODO:");
        }

         
         
         if(val.equals("MOD"))
        {
            String vcodigo=request.getParameter("txtcodigo");
            System.out.println("este es el codigo : "+vcodigo);
             System.out.println(" ENTRANDO POR tercera VEZ : "+val);
             String fechaini=request.getParameter("txtfechaini").toString().toUpperCase();
             String fechafin=request.getParameter("txtfechafin").toString().toUpperCase();
             System.out.println(" fecha inicio : "+fechaini+" fecha fin :"+fechafin+" y el año: ");
            if(                
                    objPeri.Modificar2(
                    Integer.parseInt(request.getParameter("txtcodigo")),        
                    Integer.parseInt(request.getParameter("txtanio")),
                    Integer.parseInt(request.getParameter("txtmes")),
                    Integer.parseInt(request.getParameter("txtsemana")),
                    fechaini,
                    fechafin,
                    request.getParameter("txttema1").toString().toUpperCase(),
                    request.getParameter("txttema2").toString().toUpperCase(),
                    request.getParameter("txtestado").toString().toUpperCase()
                    )
                    )
            {
                vPeriodo=objPeri.BuscarTodo();
                request.setAttribute("vPeriodo",vPeriodo);
                rd= getServletContext().getRequestDispatcher("/manPeriodo.jsp");
                rd.forward(request,response);
                  System.out.println("modificdo ");
            }
            else
            {
                rd= getServletContext().getRequestDispatcher("/Error.jsp");
                rd.forward(request,response);
            }


         }
           if(val.equals("E"))
        {
            int vcodigo=Integer.parseInt(request.getParameter("vcodigo"));

            if(objPeri.Eliminar(vcodigo))
            {
                vPeriodo=objPeri.BuscarTodo();
                request.setAttribute("vPeriodo",vPeriodo);
                rd= getServletContext().getRequestDispatcher("/manMiembro.jsp?val=MOS");
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
            out.println("<title>Servlet sCelulas</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sCelulas at " + request.getContextPath () + "</h1>");
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
