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
public class cTipoPersona {

    private int idTipoPersona;
    private String descripcion;
    private String tipo;

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public cTipoPersona(int idTipoPersona, String descripcion, String tipo) {
        this.idTipoPersona = idTipoPersona;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    


    public cTipoPersona() {
    }

    @Override
    public String toString() {
        return "cTipoPersona{" + "idTipoPersona=" + idTipoPersona + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
    
     public boolean Crear(String descripcion, String tipo) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_tipopersona_n(?,?)}");
            
            st.registerOutParameter(1,Types.VARCHAR);
            st.setString(1,descripcion);
            st.registerOutParameter(2,Types.VARCHAR);
            st.setString(2,tipo);
            

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar el tipo";
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


        Vector<cTipoPersona> Lista = new Vector<cTipoPersona>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_tipopersona_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cTipoPersona (rs.getInt("idTipoPersona"), rs.getString("descripcion"),
                               rs.getString("tipo") ));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
       public boolean Modificar(int idTipoPersona, String descripcion,String tipo) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_tipopersona_m(?,?,?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.registerOutParameter(2, Types.VARCHAR);
            st.registerOutParameter(3, Types.VARCHAR);
            
            st.setInt(1,idTipoPersona);
            st.setString(2, descripcion);
            st.setString(3, tipo);
           
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar la tipo";
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
            CallableStatement st=con.prepareCall("{call sp_tipopersona_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el TIPO";
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
              CallableStatement st=con.prepareCall("{call sp_tipopersona_bco(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdTipoPersona(rs.getInt("idTipoPersona"));
                  this.setDescripcion(rs.getString("descripcion"));
                  this.setTipo(rs.getString("tipo"));
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
