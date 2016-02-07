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
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBManager obj=new DBManager();
        obj.getConnection();
        
        
        cAlcance objAl= new cAlcance();
        cOfrendaInvitados objOfre =new cOfrendaInvitados();
        cAsistencia objAs=new cAsistencia();
        cPeriodo objperiodo=new cPeriodo();
        cMiembro objmi=new cMiembro();
        cPersona objper=new cPersona();
        
        cUsuario objusu=new cUsuario();
        cCelula objcel=new cCelula();
        cMiembro objmie=new cMiembro();
        cInvitado objin=new cInvitado();
        
        
                
//------------------------------------------------------------------------------------------------        
        ///ALCANCE
//        objAl.Crear(1, 2, 3);
        //tipo de celula
//        objtipoc.Crear("prueba");
        ///TIPO PERSONA
//        objTiPer.Crear("ese"," yes");
        //asistencia
//         objAs.Crear(1,6,"a"," yes");
//        periodo
//               objPer.Crear(2014,5,4,"26-05-2014","amor","amor mas","A"); 
        //miembro
//        objmi.Crear("a", "e", "es nuevesito", 1, 1);
        //persona
//      int vCodigo= objper.Crear2("prueba de retorno", "ponce", "v","morales", "jr. cipres", "por el grifo", "10-07-1982", "961030029", 1,"43056714", 1, "sistemas", "mmmmm");
//        System.out.println("aca toy:"+vCodigo);
      //tipo identidad
//       objtipoide.Crear("carnet extrangeria"); 
//        objin.Crear(1, 1,"aaa", "aaa","aaaa","v","aaaa", "aaaa","10-07-1982","22222","a");
//----------------------------------------------------------------------------------------------        
              ///ALCANCE
//Vector vAlcance=objAl.BuscarTodo();
//System.out.println("se encontrado");
//         if(objAl!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vAlcance.size();i++ ){
//                 System.out.println("entrando al for");
//                     objAl=(cAlcance)vAlcance.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objAl.toString());
//
//        }   }    
         ///TIPO PERSONA
//        Vector vTipoPersona=objTiPer.BuscarTodo();
//System.out.println("se encontrado");
//         if(objTiPer!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vTipoPersona.size();i++ ){
//                 System.out.println("entrando al for");
//                     objTiPer=(cTipoPersona)vTipoPersona.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objTiPer.toString());
//
//        }   }  
        //tipo celula
//         Vector vTipoCelula=objtipoc.BuscarTodo();
//System.out.println("se encontrado");
//         if(objTiPer!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vTipoCelula.size();i++ ){
//                 System.out.println("entrando al for");
//                     objtipoc=(cTipoCelula)vTipoCelula.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objtipoc.toString());
//
//        }   }  
        //asistencia
//        Vector vAsistencia=objAs.BuscarTodo();
//System.out.println("se encontrado");
//         if(objAs!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vAsistencia.size();i++ ){
//                 System.out.println("entrando al for");
//                     objAs=(cAsistencia)vAsistencia.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objAs.toString());
//
//        }   }  
        //periodo
//        Vector vPeriodo=objPer.BuscarTodo();
//        objPer.mostrar_periodo_actual();
//       System.out.println("periodo "+objPer.toString());
//System.out.println("se encontrado");
//         if(objPer!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vPeriodo.size();i++ ){
//                 System.out.println("entrando al for");
//                     objPer=(cPeriodo)vPeriodo.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objPer.toString());
//
//        }   }  
        //miembro
//         Vector vMiembro=objmi.BuscarTodo();
//System.out.println("se encontrado");
//         if(objmi!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vMiembro.size();i++ ){
//                 System.out.println("entrando al for");
//                     objmi=(cMiembro)vMiembro.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objmi.toString());
//
//        }   }  
        //persona
//        Vector vPersona=objper.BuscarTodo();
//System.out.println("se encontrado");
//         if(objper!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vPersona.size();i++ ){
//                 System.out.println("entrando al for");
//                     objper=(cPersona)vPersona.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objper.toString());
//
//        }   }  
        
//           Vector vPersona=objper.BuscarTodot();
//System.out.println("se encontrado en prueba");
//         if(objper!=null){
//             System.out.println("entrando al if de prueba");
//             for(int i=0;i<vPersona.size();i++ ){
//                 System.out.println("entrando al for deprueba");
//                     objper=(cPersona)vPersona.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objper.toString2());
//
//        }   } 
        
        
//        
//                   Vector vredtrabajo=objred.BuscarTodo();
//System.out.println("se encontrado en prueba");
//         if(objper!=null){
//             System.out.println("entrando al if de prueba");
//             for(int i=0;i<vredtrabajo.size();i++ ){
//                 System.out.println("entrando al for deprueba");
//                     objred=(cRedTrabajo)vredtrabajo.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objred.toString());
//
//        }   } 
//        
        
//                  Vector vPersona=objper.Buscar3("p");
//System.out.println("se encontrado");
//         if(objper!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vPersona.size();i++ ){
//                 System.out.println("entrando al for");
//                     objper=(cPersona)vPersona.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objper.toString2());
//
//        }   }  
        
        //MIEMBRO
//                          Vector vMiembro=objmie.Buscar3(2);
//System.out.println("se encontrado");
//         if(objmie!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vMiembro.size();i++ ){
//                 System.out.println("entrando al for");
//                     objmie=(cMiembro)vMiembro.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objmie.toString2());
//
//        }   }  
        
        
        //tipo identidad
//        Vector vTipoIdentidad=objtipoide.BuscarTodo();
//System.out.println("se encontrado");
//         if(objtipoide!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vTipoIdentidad.size();i++ ){
//                 System.out.println("entrando al for");
//                     objtipoide=(cTipoIdentidad)vTipoIdentidad.elementAt(i);
//         System.out.println("se encontro");
//         System.out.println("codigo "+objtipoide.toString());
//
//        }   }  
        //periodo
 
//--------------------------------------------------------------------------------------------------------
         ///ALCANCE
//        objAl.Eliminar(4);
        ///TIPO PERSONA
//        objTiPer.Eliminar(3);
        //tipo celula
//        objtipoc.Eliminar(6);
        //asistencia
//        objAs.Eliminar(6);
        //periodo
//        objPer.Eliminar(4);
        //miembro
//        objmi.Eliminar(6);
        //persona
        //objper.Eliminar(3);
        //tipo identidad
//        objtipoide.Eliminar(2);
//----------------------------------------------------------------------------------------------------
         ///ALCANCE
//        objAl.Modificar(1, 5, 5, 5);
        ///TIPO PERSONA
//        objTiPer.Modificar(2,"aca","ta");
        //tipo de celula
//        objtipoc.Modificar(2,"pruebita");
        //asistencia
//        objAs.Modificar(2,1,2,"a","yata");
        //periodo

//         objPer.Modificar(2, 2014,5, 2, "2014-05-05","amorcito","amorsote", "a");
        //miembro
//        objmi.Modificar(2, "o", "o", "0", 2, 2);
        //persona
//        objper.Modificar(1,"Patricia Amotito", "Lopez", "Vasquez", "m","jr.Ayacucho #315", "por el grifo", "10-07-1989", "961030029", 1,"43056714", 1, "sistemas", "mmmmm");
        //tipo identidad
//        objtipoide.Modificar(1, "dnis");
//-----------------------------------------------------------------------------------------------------
         ///ALCANCE
//        objAl.Buscar(1);
//         if(objAl!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objAl.toString());
//
//         }
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
        //usuario
//       objusu.validar("eponce","poderoso");
//         if(objper!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("Producto "+objusu.toString());
//
//
//        }     
//         objcel.Buscarcelu2(2);
//         if(objcel!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("celula "+objcel.toString());
//
//
//        }   
         
//                 objper.Buscarlider3(3);
//         if(objper!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("miembro "+objper.getTipmiembro());
//
//
//        }
//        objper.Buscarlider(2);
//         if(objper!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("lider "+objper.toString3());
//
//
//        }   
//        MIEMBRO
//        objmie.Buscar1(2);
//         if(objmie!=null)
//         {
//         System.out.println("se encontro");
//         System.out.println("lider "+objmie.toString());
//
//
//        }   
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
        
        
        
        
//        Vector vCelula=objcel.Buscarnroscelu(1);
//
//         if(objcel!=null ){
//                       
//             for(int i=0;i<vCelula.size();i++ ){
//                          
//                             
//                     objcel=(cCelula)vCelula.elementAt(i);
//                     
//         System.out.println("se encontro");
//         System.out.println("celula "+objcel.getIdCelula());
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
//        objin.Modificar(1,2,2,"rossetti","lopez","vasquez","x","alli","dee" ,"2014-05-05","55555","h");
//        Vector vPeriodo=objperiodo.BuscarTodo3();
//            System.out.println("se encontrado");
//             if(objperiodo!=null){
//             System.out.println("entrando al if");
//             for(int i=0;i<vPeriodo.size();i++ )
//                {
//                     System.out.println("entrando al for");
//                     objperiodo=(cPeriodo)vPeriodo.elementAt(i);
//                     System.out.println("se encontro");
//                     System.out.println("Periodo"+objperiodo.toString());
//                     System.out.println("numero"+vPeriodo.size());
//
//                }  
//         }    
//        objperiodo.Buscar_mes3(5);
//        System.out.println("mes  " +objperiodo.getMess())  ;
//        
//        objperiodo.periodo_actual123();
//        System.out.println("año " +objperiodo.getAño()+",mes "+objperiodo.getMes()+" y semana"+objperiodo.getSemana()   );
//    System.out.println("fecha ini " +objperiodo.getFechaini()+",fecha fin "+objperiodo.getFechafin()   );
//         objperiodo.Buscar_mes2();
//        System.out.println("mes  " +objperiodo.getMess())  ;
//        objperiodo.fecha_actual();
//        System.out.println("fecha " +objperiodo.getFecha_actual())  ;
//        objcel.Modificar(1, 1, "cambiado", "cambiado", "lunes", "8:30 pm", "10-07-2014", "452652",3);
        
       objOfre.Crear2(1, 45, 2.5, 5);
       objOfre.Buscar_por_idce_idperi(1,46);   
       System.out.println("celula "+objOfre.toString());
}
}
         
    
