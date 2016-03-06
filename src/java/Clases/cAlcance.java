/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.File;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author Ing. Edeher
 */
public class cAlcance {

    private int idAlcance;
    private int reto;
    private int alcance;
    private int idMiembro;

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }


    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }


    public int getReto() {
        return reto;
    }

    public void setReto(int reto) {
        this.reto = reto;
    }


    public int getIdAlcance() {
        return idAlcance;
    }

    public void setIdAlcance(int idAlcance) {
        this.idAlcance = idAlcance;
    }

    public cAlcance(int idAlcance, int reto, int alcance, int idMiembro) {
        this.idAlcance = idAlcance;
        this.reto = reto;
        this.alcance = alcance;
        this.idMiembro = idMiembro;
    }

    public cAlcance() {
    }

    public cAlcance(int reto, int alcance, int idMiembro) {
        this.reto = reto;
        this.alcance = alcance;
        this.idMiembro = idMiembro;
    }

    @Override
    public String toString() {
        return "cAlcance{" + "idAlcance=" + idAlcance + ", reto=" + reto + ", alcance=" + alcance + ", idMiembro=" + idMiembro + '}';
    }
    

    public boolean Crear(int reto,int alcance,int idMiembro) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_alcance_n(?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,reto);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,alcance);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,idMiembro);

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar el alcance";
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


        Vector<cAlcance> Lista = new Vector<cAlcance>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_alcance_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cAlcance (rs.getInt("idAlcance"), rs.getInt("reto"),
                                rs.getInt("alcance"),rs.getInt("idMiembro")));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
    
    public boolean Modificar(int idAlcance, int reto, int alcance, int idMiembro) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_alcance_m(?,?,?,?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.registerOutParameter(2, Types.INTEGER);
            st.registerOutParameter(3, Types.INTEGER);
            st.registerOutParameter(4, Types.INTEGER);
            st.setInt(1,idAlcance);
            st.setInt(2, reto);
            st.setInt(3, alcance);
            st.setInt(4, idMiembro);
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar EL ALCANCE";
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
            CallableStatement st=con.prepareCall("{call sp_alcance_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el alcance";
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
              CallableStatement st=con.prepareCall("{call sp_alcance_bco(?)}");
              
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdAlcance(rs.getInt("idAlcance"));
                  this.setReto(rs.getInt("reto"));
                  this.setAlcance(rs.getInt("Alcance"));
                  this.setIdMiembro(rs.getInt("idMiembro"));



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
     public String getFullPath(String path){
        String fullpath;

        String actualPath = this.getClass().getClassLoader().getResource(path).getPath();
        File f = new File(actualPath);

        fullpath = f.getParent();

        fullpath = fullpath.replaceAll("%20", " ");

        return fullpath;
    }
}
