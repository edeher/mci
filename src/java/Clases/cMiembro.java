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
public class cMiembro {

    private int idMiembro;
    
    private int idPersona;
    private String nombres;
    private int idCelula;
    private int idTipoMiembro;
    private String tipo;
    private String estado;
    private String antecedentes;
    
    private String lider12;

    
   
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    public String getLider12() {
        return lider12;
    }

    public void setLider12(String lider12) {
        this.lider12 = lider12;
    }
    public int getIdCelula() {
        return idCelula;
    }

    public void setIdCelula(int idCelula) {
        this.idCelula = idCelula;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdTipoMiembro() {
        return idTipoMiembro;
    }

    public void setIdTipoMiembro(int tipo) {
        this.idTipoMiembro = idTipoMiembro;
    }
 public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public cMiembro(int idMiembro, int idPersona, int idCelula, int idTipoMiembro, String estado, String antecedentes,String lider12) {
        this.idMiembro = idMiembro;
        this.idPersona = idPersona;
        this.idCelula = idCelula;
        this.idTipoMiembro = idTipoMiembro;
        this.estado = estado;
        this.antecedentes = antecedentes;
        this.lider12=lider12;
    }

    public cMiembro(int idMiembro, int idPersona, int idCelula, String tipo, String estado, String antecedentes,String lider12) {
        this.idMiembro = idMiembro;
        this.idPersona = idPersona;
        this.idCelula = idCelula;
        this.tipo = tipo;
        this.estado = estado;
        this.antecedentes = antecedentes;
         this.lider12=lider12;
    }

    public cMiembro(int idPersona) {
        this.idPersona = idPersona;
    }

    public cMiembro(int idMiembro,int idPersona, String nombres) {
        this.idMiembro = idMiembro;
        this.idPersona=idPersona;
        this.nombres = nombres;
    }

     

    public cMiembro() {
    }

    @Override
    public String toString() {
        return "cMiembro{" + "idMiembro=" + idMiembro + ", idPersona=" + idPersona + ", idCelula=" + idCelula + ", idTipoMiembro=" + idTipoMiembro + ", estado=" + estado + ", antecedentes=" + antecedentes+ ", lider12=" + lider12 + '}';
    }

  public String toString2() {
        return "cMiembro{" + "idMiembro=" + idMiembro + ", idPersona=" + idPersona + ", idCelula=" + idCelula + ", tipo=" + tipo + ", estado=" + estado + ", antecedentes=" + antecedentes + '}';
    }
    
public Vector BuscarTodo() {
        Vector<cMiembro> Lista = new Vector<cMiembro>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_miembro_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cMiembro (
                                rs.getInt("idMiembro"),
                                rs.getInt("idPersona") ,
                                rs.getInt("idCelula"),
                                rs.getInt("idTipoMiembro"),
                                rs.getString("estado"),
                                rs.getString("antecedentes"),
                                rs.getString("lider12")));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
public Vector BuscarTodot() {
        Vector<cMiembro> Lista = new Vector<cMiembro>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_miembro_ttt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cMiembro (
                                rs.getInt("idMiembro"),
                                rs.getInt("idPersona") ,
                                rs.getInt("idCelula"),
                                rs.getString("tipo"),
                                rs.getString("estado"),
                                rs.getString("antecedentes"),
                                rs.getString("lider12")));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
    public boolean Crear(int idPersona, int idCelula,int idTipoMiembro,String estado,String antecedentes,String lider12 ) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_miembro_n(?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idPersona);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idCelula);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,idTipoMiembro);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,estado);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,antecedentes);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,lider12);
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar el periodo";
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
    
public boolean Modificar(int idMiembro, int idPersona, int idCelula,int  idTipoMiembro,String estado,String antecedentes,String lider12) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_miembro_m(?,?,?,?,?,?,?) }");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idMiembro);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idPersona);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,idCelula);
            st.registerOutParameter(4,Types.INTEGER);
            st.setInt(4,idTipoMiembro);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,estado);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,antecedentes);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,lider12);
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar el periodo";
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
            CallableStatement st=con.prepareCall("{call sp_miembro_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el Miembro";
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
    public Vector Buscar(int idMiembro) {

           Vector<cMiembro> Lista = new Vector<cMiembro>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_miembro_bco2(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,idMiembro);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                           new cMiembro (
                                rs.getInt("idMiembro"),
                                rs.getInt("idPersona"), 
                                rs.getInt("idCelula"),
                                rs.getString("tipo"),
                                rs.getString("estado") ,
                                rs.getString("antecedentes"),
                                   rs.getString("lider12")
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
     public Vector Buscar2(String tipo) {

           Vector<cMiembro> Lista = new Vector<cMiembro>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_miembro_bco3(?)}");
            st.registerOutParameter(1,Types.VARCHAR);
             st.setString(1,tipo);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                           new cMiembro (
                                rs.getInt("idMiembro"),
                                rs.getInt("idPersona"), 
                                rs.getInt("idCelula"),
                                rs.getString("tipo"),
                                rs.getString("estado") ,
                                rs.getString("antecedentes"),
                                  rs.getString("lider12")  
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
      public Vector Buscar3(int tipo) {

           Vector<cMiembro> Lista = new Vector<cMiembro>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_miembro_bco4(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,tipo);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                           new cMiembro (
                                  
                                rs.getInt("idMiembro"),
                                rs.getInt("idPersona"), 
                                rs.getInt("idCelula"),
                                rs.getString("tipo"),
                                rs.getString("estado") ,
                                rs.getString("antecedentes"),
                                   rs.getString("lider12")
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
     public boolean Buscar1(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_miembro_bco(?)}");
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdMiembro(rs.getInt("idMiembro"));
                  this.setIdPersona(rs.getInt("idPersona"));
                   this.setIdCelula(rs.getInt("idCelula"));
                  this.setIdTipoMiembro(rs.getInt("idTipoMiembro"));
                  this.setEstado(rs.getString("estado"));
                  this.setAntecedentes(rs.getString("antecedentes"));
                  this.setLider12(rs.getString("lider12"));

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
      public boolean BuscarMiembroRepetido(int dni) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_miembro_discipulado_bus(?)}");
                st.setInt(1,dni);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  
                  this.setIdPersona(rs.getInt("idPersona"));

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
       public Vector Lideres() {

           Vector<cMiembro> Lista = new Vector<cMiembro>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_miembro_lideres}");
           ResultSet rs=st.executeQuery();
              while(rs.next())
                  Lista.addElement(
                           new cMiembro (
                                  
                                rs.getInt("idMiembro"),
                                   rs.getInt("idPersona"),
                                rs.getString("nombres")
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
public boolean CelulaDoble(int idPersona, int idTipoCelula) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_CelulaDoble(?,?)}");
               st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,idPersona);
             st.registerOutParameter(2,Types.INTEGER);
             st.setInt(2,idTipoCelula);


                
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  
                  this.setIdMiembro(rs.getInt("idMiembro"));
                  this.setIdCelula(rs.getInt("idCelula"));
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