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
public class cTipoCelula {

    private int idTipoCelula;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getIdTipoCelula() {
        return idTipoCelula;
    }

    public void setIdTipoCelula(int idTipoCelula) {
        this.idTipoCelula = idTipoCelula;
    }

    public cTipoCelula(int idTipoCelula, String descripcion) {
        this.idTipoCelula = idTipoCelula;
        this.descripcion = descripcion;
    }

    public cTipoCelula() {
    }

    @Override
    public String toString() {
        return "cTipoCelula{" + "idTipoCelula=" + idTipoCelula + ", descripcion=" + descripcion + '}';
    }
    
     public boolean Crear(String descripcion) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_tipocelula_n(?)}");
            
            st.registerOutParameter(1,Types.VARCHAR);
            st.setString(1,descripcion);
           

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar el TIPO";
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


        Vector<cTipoCelula> Lista = new Vector<cTipoCelula>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_tipocelula_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cTipoCelula (rs.getInt("idTipoCelula"), rs.getString("descripcion")));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
    public boolean Modificar(int idTipoCelula, String descripcion) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_tipocelula_m(?,?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.registerOutParameter(2, Types.VARCHAR);
            
            st.setInt(1,idTipoCelula);
            st.setString(2,descripcion);
         
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar la EL TIPO";
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
            CallableStatement st=con.prepareCall("{call sp_tipocelula_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el tipo";
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
              CallableStatement st=con.prepareCall("{call sp_tipocelula_bco(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdTipoCelula(rs.getInt("idTipoCelula"));
                  this.setDescripcion(rs.getString("descripcion"));
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
}
