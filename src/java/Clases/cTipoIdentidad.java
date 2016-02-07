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
public class cTipoIdentidad {

    private int idTipoIdentidad;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getIdTipoIdentidad() {
        return idTipoIdentidad;
    }

    public void setIdTipoIdentidad(int idTipoIdentidad) {
        this.idTipoIdentidad = idTipoIdentidad;
    }

    public cTipoIdentidad(int idTipoIdentidad, String descripcion) {
        this.idTipoIdentidad = idTipoIdentidad;
        this.descripcion = descripcion;
    }

    public cTipoIdentidad() {
    }

    @Override
    public String toString() {
        return "cTipoIdentidad{" + "idTipoIdentidad=" + idTipoIdentidad + ", descripcion=" + descripcion + '}';
    }

    public Vector BuscarTodo() {


        Vector<cTipoIdentidad> Lista = new Vector<cTipoIdentidad>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_tipoidentidad_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cTipoIdentidad (rs.getInt("idTipoIdentidad"), rs.getString("descripcion")
                                ));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
    public boolean Crear(String descripcion) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_tipoidentidad_n(?)}");
            
            
            st.registerOutParameter(1,Types.VARCHAR);
            st.setString(1,descripcion);
           

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar el tipo de identidad";
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
    public boolean Modificar(int idTipoIdentidad, String descripcion) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_tipoidentidad_m(?,?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.registerOutParameter(2, Types.VARCHAR);
           
            st.setInt(1,idTipoIdentidad);
            st.setString(2, descripcion);
           
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar el tipo de identidad";
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
            CallableStatement st=con.prepareCall("{call sp_tipoidentidad_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el tipo de identidad";
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
              CallableStatement st=con.prepareCall("{call sp_tipoidentidad_bco(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
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
