/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.Vector;
/**
 *
 * @author Ing. Edeher
 */
public class pruebasBuscar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBManager obj=new DBManager();
        obj.getConnection();
        
        
        cAlcance objAl= new cAlcance();
        cTipoPersona objTiPer=new cTipoPersona();
        cTipoCelula objtipoc=new cTipoCelula();
        cAsistencia objAs=new cAsistencia();
        cPeriodo objperiodo=new cPeriodo();
        cCelula objcel=new cCelula();
        cMiembro objlider=new cMiembro();
       
        
        
                

//        periodo
//        objPer.Buscar_mes2();
//         if(objPer!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objPer.toString2());
//
//         }
//               Vector vTipoPer=objPer.Buscar_mes();
//
//         if(objPer!=null){
//            
//             for(int i=0;i<vTipoPer.size();i++ ){
//                 System.out.println("entrando al for");
//                     objPer=(cPeriodo)vTipoPer.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objPer.toString2());
//
//        }   }  
                
          ///TIPO PERSONA
//        objTiPer.Buscar(2);
//         if(objTiPer!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objTiPer.toString());
//
//         }
        
        
//        tipo celula
//        objtipoc.Buscar(2);
//         if(objtipoc!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objtipoc.toString());
//
//         }
        //asistencia
//         objAs.Buscar(2);
//         if(objAs!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("asistencia "+objAs.toString());
//
//         }
//                            objAs.Buscarasistente(10,5);
//                             if(objAs.getIdAsistencia()!=0)
//                             {
//                             
//                             System.out.println("si asistencia "+objAs.getIdAsistencia());
//
//                             }else
//                                 System.out.println("no asistencia "+objAs.getIdAsistencia()); 
        
        
        //periodo
//        objperiodo.Buscar(2);
//         if(objperiodo!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objperiodo.toString());
//
//         }
        //miembro
//        objmi.Buscar(2);
//         if(objmi!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objmi.toString());
//
//         }
        //persona
//                objper.Buscar(2);
//         if(objper!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Persona encontrada  "+objper.getFecha_nac());
//
//         }
//          objper.Buscar2("p");
//         if(objper!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objper.toString());
//
//         }
        //tipo de identidad
//          objtipoide.Buscar(1);
//         if(objtipoide!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objtipoide.toString());
//
//         }
        
//        
//        Vector vPersona=objper.Buscarmiembro3(3);
//
//         if(objper!=null ){
//                       
//             for(int i=0;i<vPersona.size();i++ ){
//                          
//                              
//                     objper=(cPersona)vPersona.elementAt(i);
//                     
//         System.out.println("se encontro");
//         System.out.println("miembros "+objper.toString3());
//
//          } }  
//        
        
//        
//        Vector vAsistencia=objAs.Buscar333(10);
//
//         if(objper!=null ){
//                       
//             for(int i=0;i<vAsistencia.size();i++ ){
//                          
//                              
//                     objAs=(cAsistencia)vAsistencia.elementAt(i);
//                     
//         System.out.println("se encontro");
//         System.out.println("Asistentes "+objAs.toString());
//
//          } 
//         }  
        
//        Vector vCelula=objcel.BuscarTodot();
//
//         if(objcel!=null ){
//                       
//             for(int i=0;i<vCelula.size();i++ ){
//                          
//                             
//                     objcel=(cCelula)vCelula.elementAt(i);
//                     
//         System.out.println("se encontro");
//          System.out.println("celula "+objcel.getIdCelula());
//         System.out.println("celula "+objcel.getLider());
//         System.out.println("nro "+(i+1));
//
//          } }  
//            Vector vlideres=objlider.Lideres();
//
//         if(objlider!=null ){
//                       
//             for(int i=0;i<vlideres.size();i++ ){
//                          
//                             
//                     objlider=(cMiembro)vlideres.elementAt(i);
//                     
//         System.out.println("se encontro");
//          System.out.println("idMiembro "+objlider.getIdMiembro());
//         System.out.println("idPersona "+objlider.getIdPersona());
//            System.out.println("nombres "+objlider.getNombres()
//            );
//         System.out.println("nro "+(i+1));
//
//          } }  
        
//         Vector vmiembros=new Vector();
//          Vector vmiembros2=new Vector();
//        vmiembros=objper.Buscarmiembro2(2);
//        for(int i=0; i<vmiembros.size();i++)
//              {
//                       objper=(cPersona)vmiembros.elementAt(i);
//                       
//                       cPersona objper2=new cPersona();
//                       objper2.Buscarlider3(objper.getIdPersona() );
//                       
//                      
//                       if(objper2.getTipmiembro()!=null) 
//                            System.out.println("tiene celula  " +objper2.getTipmiembro())  ;  
//                       else 
//                            System.out.println("no tiene celula  "+objper2.getTipmiembro())  ;       
//              }
        
//        objper2.Buscarlider3(3);
//        System.out.println("tiene celula  " +objper2.getTipmiembro())  ;
        
        
        
        
        
        //**************************************************
        
      /*  Vector vMiembro=objper.Buscarmiembro(2);
        if(objper!=null)
        {
          
             for(int i=0;i<vMiembro.size();i++ )
             {           
                        objper=(cPersona)vMiembro.elementAt(i);
                        
                        System.out.println("miembro "+objper.getIdMiembro());
                        
                       int vcodigo= objAs.aiste2(10, objper.getIdMiembro());
                       
                        System.out.println("su asistencia es: "+vcodigo);
                             if(vcodigo!=0)
                             System.out.println("si asistio ");
                             if(vcodigo==0){
                             System.out.println("no asistio "); }
                       
              } 
      }  
*/
        
        
//        if(objlider.CelulaDoble(1, 1))
//        {
//          
//             
//                        System.out.println("miembro "+objlider.getIdMiembro());
//                        System.out.println("idcelula "+objlider.getIdCelula());
//          }  

       //invitado
//Vector vInvitado=objin.BuscarTodot();
//System.out.println("se encontrado");
//         if(objin!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vInvitado.size();i++ ){
//                 System.out.println("entrando al for");
//                     objin=(cInvitado)vInvitado.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objAl.toString());
//
//        }   }      
        
        
         
//         Vector vInvitado=objin.BuscarTodot2("f");
//System.out.println("se encontrado");
//         if(objin!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vInvitado.size();i++ ){
//                 System.out.println("entrando al for");
//                     objin=(cInvitado)vInvitado.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objin.toString());
//
//        }   }      
//          Vector vPeriodo=objperiodo.Buscar33(07,2014);
//            System.out.println("se encontrado");
//             if(objperiodo!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vPeriodo.size();i++ )
//                {
//                     System.out.println("entrando al for");
//                     objperiodo=(cPeriodo)vPeriodo.elementAt(i);
//                     System.out.println("se encontro");
//                     System.out.println("Periodo"+objperiodo.toString());
//
//                }  
//         }   
//             Vector vPeriodo=objperiodo.BuscarSemanaActual();
//            System.out.println("se encontrado");
//             if(objperiodo!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vPeriodo.size();i++ )
//                {
//                     System.out.println("entrando al for");
//                     objperiodo=(cPeriodo)vPeriodo.elementAt(i);
//                     System.out.println("se encontro");
//                     System.out.println("semana"+objperiodo.getSemana());
//
//                }  
//         } 
//        objin.Modificar(1,2,2,"rossetti","lopez","vasquez","x","alli","dee" ,"2014-05-05","55555","h");
        
//        int codigocel=objcel.Crear2(1, "pruebisimas", "ac", "ac","ac", "20-05-2015", "ac", 1);
//         System.out.println("celula nueva :"+codigocel);
}
}
         
    
