/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.util.Vector;

/**
 *
 * @author Ing. Edeher
 */
public class prueba_metodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBManager obj=new DBManager();
        obj.getConnection();
        
        
        
         cPersona per=new cPersona();
        
        
         cAsistencia asis = new cAsistencia();
        cAsistencia asis2 = new cAsistencia();
        
        cPeriodo cperi = new cPeriodo();
         cPeriodo cperi2 = new cPeriodo();
        Vector vperi = new Vector();
        // vperi = cperi.BuscarTodo2();
        cperi2.Buscar_actual();
        int periodo = cperi2.getIdPeriodo();
        
        Vector vmiembros = new Vector();
        
         vmiembros = per.Buscarmiembro2(1); 
          System.out.println("  buscando todos los miembros");
          
         for (int i = 0; i < vmiembros.size(); i++) 
                        {
                            per = (cPersona) vmiembros.elementAt(i);
                            cPersona per2 = new cPersona();
                            per2.Buscarlider3(per.getIdPersona());
                             System.out.println("  persona "+per.getIdPersona());
                            if (per2.getTipmiembro() != null) 
                                {
                                     System.out.println("  " +per.getNomcompleto()+"  es un lider "+per2.getTipmiembro());
                                }
                            else 
                                {
                                     System.out.println("  " + per.getNomcompleto()+"  no  es lider "+per2.getTipmiembro() );
                                }
                            
                                int vvcodigo=0; 
                                vvcodigo=asis.aiste3(periodo, per.getIdMiembro());
                           if (vvcodigo!= 0)    
                                {
                                   System.out.println(""+per.getNomcompleto() +"     asistio " ) ;
                                }
                           else
                                {
                                    System.out.println(""+per.getNomcompleto() +"    noooo asistio " ) ;
                                }
                        }
        
    }
    
}
