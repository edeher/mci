/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author Ing. Edeher
 */
public class cAsistencia {

    private int idAsistencia;
    private int idPeriodo;
   
    private int idMiembro;
    
    private String estado;
    
    private String observaciones;

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getIdMiembro() {
        return idMiembro;
    }
    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }
    public int getIdPeriodo() {
        return idPeriodo;
    }
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
    public int getIdAsistencia() {
        return idAsistencia;
    }
    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    public cAsistencia() {
    }
    public cAsistencia(int idAsistencia, int idPeriodo, int idMiembro, String estado, String observaciones) {
        this.idAsistencia = idAsistencia;
        this.idPeriodo = idPeriodo;
        this.idMiembro = idMiembro;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public cAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    
    public String toString() {
        return "cAsistencia{" + "idAsistencia=" + idAsistencia + ", idPeriodo=" + idPeriodo + ", idMiembro=" + idMiembro + ", estado=" + estado + ", observaciones=" + observaciones + '}';
    }
     public String toString2() {
        return "cAsistencia{" + "idAsistencia=" + idAsistencia + '}';
    }
    public boolean Crear(int idPeriodo,int idMiembro,String estado, String observaciones) {
             String error=null;
        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_asistencia_n(?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idPeriodo);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idMiembro);
            st.registerOutParameter(3,Types.VARCHAR);
            st.setString(3,estado);
            st.registerOutParameter(3,Types.VARCHAR);
            st.setString(4,observaciones);

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar LA ASISTENCIA";
            }
            st.close();
            con.close();
            dbm = null;
        } catch (Exception e) {
            error = e.toString();
            System.out.println(e.getMessage());
        }
        return (error == null);
    }
    public Vector BuscarTodo() {


        Vector<cAsistencia> Lista = new Vector<cAsistencia>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_asistencia_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cAsistencia (
                                rs.getInt("idAsistencia"),
                                rs.getInt("idPeriodo"), 
                                rs.getInt("idMiembro"), 
                                rs.getString("estado"),
                                rs.getString("observaciones")));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
    public boolean Modificar(int idAsistencia, int idPeriodo,int idMiembro,String estado ,String observaciones) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_asistencia_m(?,?,?,?,?) }");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idAsistencia);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idPeriodo);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,idMiembro);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,estado);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,observaciones);
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar la asistencia";
            }
            st.close();
            con.close();
            dbm = null;
        } catch (Exception e) {
            error = e.toString();
            System.out.println(e.getMessage());
        }
        return (error == null);
    }
    public boolean Eliminar(int codigo) {
        String error = null;
        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_asistencia_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar la asitencia";
            }
            st.close();
            con.close();
            dbm = null;
        } catch (Exception e) {
            error = e.toString();
            System.out.println(e.getMessage());
        }
        return (error == null);
    }
    public boolean Buscar(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_asistencia_bco(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdAsistencia(rs.getInt("idAsistencia"));
                  this.setIdPeriodo(rs.getInt("idPeriodo"));
                  this.setIdMiembro(rs.getInt("idMiembro"));
                  this.setEstado(rs.getString("estado"));
                  this.setObservaciones(rs.getString("observaciones"));
               



                  return true;
              }
              rs.close();
              st.close();
              dbm = null;
          }catch(Exception e){
              System.out.println("Error:"+e.getMessage());
          }
       return false;
    }
    
     public Vector Buscar333(int mes) {

           Vector<cAsistencia> Lista = new Vector<cAsistencia>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_asistencia_bco3(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,mes);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                           new cAsistencia (
                                rs.getInt("idAsistencia"),   
                                rs.getInt("idPeriodo"),
                                rs.getInt("idMiembro"), 
                                rs.getString("estado"),
                                   rs.getString("observaciones")
                                )
                             );
              rs.close();
              st.close();
              dbm = null;
          }catch(Exception e){
              System.out.println("Error:"+e.getMessage());
          }
       return Lista;
    }
     public boolean Buscarasistente(int mes, int idMiembro) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_asistencia_bco4(?,?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,mes);
                st.registerOutParameter(2,Types.INTEGER);
                st.setInt(2,idMiembro);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdAsistencia(rs.getInt("idAsistencia"));;

                  return true;
              }
              
              rs.close();
              st.close();
              dbm = null;
          }catch(Exception e){
              System.out.println("Error:"+e.getMessage());
          }
       return false;
    }
     public int  aiste2(int mes, int idMiembro) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_asistencia_bco5(?,?,?)}");
            
           
           st.registerOutParameter(1,Types.INTEGER);
            st.setInt(2,mes);
             st.setInt(3,idMiembro);
            
            st.execute();
           System.out.println("esta es la clase:kk"+mes);
           System.out.println("esta es la clasekk:"+idMiembro);
           
            int vCodigo=st.getInt(1);
            
            st.close();
           
           
            System.out.println("esta es la clase:"+vCodigo);
            return vCodigo;
        } catch (Exception e) {
            error = e.toString();
            System.out.println("esta es la clase2:"+e.getMessage());
            System.out.println(e.getMessage());
             return 0;
        }
       
    }
     public int  aiste3(int periodo, int idMiembro) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_asistencia_bco6(?,?,?)}");
            
           
           st.registerOutParameter(1,Types.INTEGER);
            st.setInt(2,periodo);
             st.setInt(3,idMiembro);
            
            st.execute();
           System.out.println("periodo para buscar "+periodo);
           System.out.println("miembro para buscar :"+idMiembro);
           
            int vCodigo=st.getInt(1);
            
            st.close();
           
           
            System.out.println("codigo de asistencia retornado :"+vCodigo);
            return vCodigo;
        } catch (Exception e) {
            error = e.toString();
            System.out.println("esta es la clase2:"+e.getMessage());
            System.out.println(e.getMessage());
             return 0;
        }
       
    }
}
