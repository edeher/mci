/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Ing. Edeher
 */
public class cCelula {

    private int idCelula;
    private int idMinisterio;
    private String tipocelula;
    private String direccion;
    private String lider;
    private String referencia;
    private String dia_realiza;
    private String hora_realiza;
    private String fecha_apertura;
    private String telefono;
    private String red;
    private String ministerio;
    private String estado;
    
   public int getIdMinisterio() {
        return idMinisterio;
    }

   
    public void setIdMinisterio(int idMinisterio) {
        this.idMinisterio = idMinisterio;
    }

   
    public String getTipocelula() {
        return tipocelula;
    }
   
    public void setTipocelula(String tipocelula) {
        this.tipocelula = tipocelula;
    }
    public String getMinisterio() {
        return ministerio;
    }
    
    public void setMinisterio(String ministerio) {
        this.ministerio = ministerio;
    }
    public cCelula(int idCelula) {
        this.idCelula = idCelula;
    }

    public cCelula() {
    }

    public String getLider() {
        return lider;
    }
   
    public void setLider(String lider) {
        this.lider = lider;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getHora_realiza() {
        return hora_realiza;
    }

    public void setHora_realiza(String hora_realiza) {
        this.hora_realiza = hora_realiza;
    }

        public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDia_realiza() {
        return dia_realiza;
    }

    public void setDia_realiza(String dia_realiza) {
        this.dia_realiza = dia_realiza;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   public int getIdCelula() {
        return idCelula;
    }

    public void setIdCelula(int idCelula) {
        this.idCelula = idCelula;
    }

    public cCelula(int idCelula, int idMinisterio, String tipocelula, String direccion, String referencia, String dia_realiza, String hora_realiza, String fecha_apertura, String telefono, String red, String ministerio) {
        this.idCelula = idCelula;
        this.idMinisterio = idMinisterio;
        this.tipocelula = tipocelula;
        this.direccion = direccion;
        this.referencia = referencia;
        this.dia_realiza = dia_realiza;
        this.hora_realiza = hora_realiza;
        this.fecha_apertura = fecha_apertura;
        this.telefono = telefono;
        this.red = red;
        this.ministerio = ministerio;
    }

    public cCelula(int idCelula, String tipocelula, String direccion, String referencia, String dia_realiza, String hora_realiza, String fecha_apertura, String telefono, String red, String ministerio) {
        this.idCelula = idCelula;
        this.tipocelula = tipocelula;
        this.direccion = direccion;
        this.referencia = referencia;
        this.dia_realiza = dia_realiza;
        this.hora_realiza = hora_realiza;
        this.fecha_apertura = fecha_apertura;
        this.telefono = telefono;
        this.red = red;
        this.ministerio = ministerio;
    }

    

    public cCelula(int idCelula, String tipocelula, String direccion) {
        this.idCelula = idCelula;
        this.tipocelula = tipocelula;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "cCelula{" + "idCelula=" + idCelula + ", tipocelula=" + tipocelula + ", direccion=" + direccion + ", referencia=" + referencia + ", dia_realiza=" + dia_realiza + ", hora_realiza=" + hora_realiza + ", fecha_apertura=" + fecha_apertura + ", telefono=" + telefono + ", red=" + red + ", ministerio=" + ministerio + '}';
    }
    
public String toString2() {
        return "cCelula{" + "idCelula=" + idCelula +", idMinisterio" + idMinisterio +  ", tipocelula=" + tipocelula + ", direccion=" + direccion + ", referencia=" + referencia + ", dia_realiza=" + dia_realiza + ", hora_realiza=" + hora_realiza + ", fecha_apertura=" + fecha_apertura + ", telefono=" + telefono + ", red=" + red + ", ministerio=" + ministerio + '}';
    }
      
    
public boolean Crear(int idTipoCelula, String direccion, String referencia, String dia_realiza, String hora_realiza,String fecha_apertura, String telefono, int idRedTrabajo, String estado) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celula_n(?,?,?,?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idTipoCelula);
            st.registerOutParameter(2,Types.VARCHAR);
            st.setString(2,direccion);
            st.registerOutParameter(3,Types.VARCHAR);
            st.setString(3,referencia);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,dia_realiza);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,hora_realiza);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,fecha_apertura);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,telefono);
            st.registerOutParameter(8,Types.INTEGER);
            st.setInt(8,idRedTrabajo);
            st.registerOutParameter(9,Types.VARCHAR);
            st.setString(9,estado);
            

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar la celula";
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
public int  Crear2(int idTipoCelula, 
                    String direccion, 
                    String referencia,
                    String dia_realiza,
                    String hora_realiza, 
                    String fecha_apertura,
                    String telefono, 
                    int idRedTrabajo) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celula_n2(?,?,?,?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(2,idTipoCelula);
            st.setString(3,direccion);
            st.setString(4,referencia);
            st.setString(5,dia_realiza);
            st.setString(6,hora_realiza);
            st.setString(7,fecha_apertura);
            st.setString(8,telefono);
            st.setInt(9,idRedTrabajo);
            System.out.println("uno"); 
            
            st.execute();
            System.out.println("dos"); 
            int vCodigo=st.getInt(1);
            System.out.println("tres"); 
            st.close();
            con.close();
            
            dbm = null;
            return vCodigo;
        } catch (Exception e) {
            error = e.toString();
            System.out.println(e.getMessage());
             return 0;
        }
       
    }
public boolean Modificar(int idCelula,int idTipoCelula, String direccion, String referencia, String dia_realiza, String hora_realiza,String fecha_apertura, String telefono, int idRedTrabajo) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celula_m(?,?,?,?,?,?,?,?,?)}");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idCelula);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idTipoCelula);
            st.registerOutParameter(3,Types.VARCHAR);
            st.setString(3,direccion);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,referencia);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,dia_realiza);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,hora_realiza);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,fecha_apertura);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,telefono);
            st.registerOutParameter(9,Types.INTEGER);
            st.setInt(9,idRedTrabajo);
            

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar la celula";
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

public boolean ModificarEstado(int idCelula ) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celula_mEstado(?)}");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idCelula);
           if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar estado de la celula";
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

public boolean Buscarcelu(int idPersona) {
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idpersona(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,idPersona);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
                  this.setIdCelula(rs.getInt("idCelula"));
                  this.setIdMinisterio(rs.getInt("idMinisterio"));
                  this.setTipocelula(rs.getString("TipoCelula"));
                  this.setDireccion(rs.getString("direcelula"));
                  this.setReferencia(rs.getString("referencia"));
                  this.setDia_realiza(rs.getString("diarealiza"));
                  this.setHora_realiza(rs.getString("horarealiza"));
                  this.setFecha_apertura(rs.getString("feapertura"));
                  this.setTelefono(rs.getString("telcelula"));
                  this.setRed(rs.getString("RedTrabajo"));
                  this.setMinisterio(rs.getString("ministerio"));
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
public boolean Buscarcelu3(int idPersona) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idpersona5(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,idPersona);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//      
                 this.setIdCelula(rs.getInt("idCelula"));
                 this.setIdMinisterio(rs.getInt("idMinisterio"));
                  this.setTipocelula(rs.getString("TipoCelula"));
                  this.setDireccion(rs.getString("direcelula"));
                  this.setReferencia(rs.getString("referencia"));
                  this.setDia_realiza(rs.getString("diarealiza"));
                  this.setHora_realiza(rs.getString("horarealiza"));
                  this.setFecha_apertura(rs.getString("feapertura"));
                  this.setTelefono(rs.getString("telcelula"));
                  this.setRed(rs.getString("RedTrabajo"));
                  this.setMinisterio(rs.getString("ministerio"));
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
public Vector Buscarnroscelu(int idPersona) {


        Vector<cCelula> Lista = new Vector<cCelula>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celulas_IDD(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,idPersona);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cCelula (rs.getInt("idCelula")));
            }
            rs.close();
            st.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }

public Vector Buscarnroscelu2(int idPersona) {


        Vector<cCelula> Lista = new Vector<cCelula>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celulas_IDD2(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,idPersona);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cCelula (
                                rs.getInt("idCelula"),
                                rs.getString("TipoCelula"),
                                rs.getString("direccion"))
                                );
            }
            rs.close();
            st.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
public boolean Buscarcelu2(int idCelula) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idcelula(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,idCelula);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//      
                 this.setIdCelula(rs.getInt("idCelula"));
                 this.setIdMinisterio(rs.getInt("idMinisterio"));
                  this.setTipocelula(rs.getString("TipoCelula"));
                  this.setDireccion(rs.getString("direcelula"));
                  this.setReferencia(rs.getString("referencia"));
                  this.setDia_realiza(rs.getString("diarealiza"));
                  this.setHora_realiza(rs.getString("horarealiza"));
                  this.setFecha_apertura(rs.getString("feapertura"));
                  this.setTelefono(rs.getString("telcelula"));
                  this.setRed(rs.getString("RedTrabajo"));
                  this.setMinisterio(rs.getString("ministerio"));
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
public Vector BuscarTodot() {
        Vector<cCelula> Lista = new Vector<cCelula>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_celula_ttt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cCelula(
                                rs.getInt("idCelula"),
                                rs.getString("direccion"),
                                rs.getString("lider"),
                                rs.getString("dia_realiza"),
                                rs.getString("hora_realiza"),
                                rs.getString("fecha_apertura"),
                                rs.getString("telefono"),
                                rs.getString("tipoCel"),
                                rs.getString("Red"),
                                rs.getString("estado")
                        )
                        
                        );
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error 2:" + e.getMessage());
        }
        return Lista;
    }
public Vector Buscar3(String direcion) {

           Vector<cCelula> Lista = new Vector<cCelula>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celula_tdire(?)}");
            st.registerOutParameter(1,Types.VARCHAR);
             st.setString(1,direcion);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                           new cCelula (
                                rs.getInt("idCelula"),
                                rs.getString("direccion"), 
                                rs.getString("referencia"),
                                rs.getString("dia_realiza"),
                                rs.getString("hora_realiza") ,
                                rs.getString("fecha_apertura"),
                                rs.getString("telefono"),
                                rs.getString("tipoCel"),
                                rs.getString("Red"),
                                rs.getString("estado")
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
public Vector Buscar4(int idCelula) {

           Vector<cCelula> Lista = new Vector<cCelula>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
            CallableStatement st=con.prepareCall("{call sp_celula_ttcod(?)}");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idCelula);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                           new cCelula (
                                rs.getInt("idCelula"),
                                rs.getString("direccion"), 
                                rs.getString("referencia"),
                                rs.getString("dia_realiza"),
                                rs.getString("hora_realiza") ,
                                rs.getString("fecha_apertura"),
                                rs.getString("telefono"),
                                rs.getString("tipoCel"),
                                rs.getString("Red"),
                                rs.getString("estado")
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
public boolean Buscar(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celula_bco2(?)}");
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdCelula(rs.getInt("idCelula"));
                  
                  this.setDireccion(rs.getString("direccion"));
                  this.setReferencia(rs.getString("referencia"));
                  this.setDia_realiza(rs.getString("dia_realiza"));
                  this.setHora_realiza(rs.getString("hora_realiza"));
                  this.setFecha_apertura(rs.getString("fecha_apertura"));
                  this.setTelefono(rs.getString("telefono"));
                  this.setTipocelula(rs.getString("TipoCelula"));
                  this.setRed(rs.getString("RedTrabajo"));
                  


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
public boolean Eliminar(int codigo) {
        String error = null;
        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_celula_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar la Celula";
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

    
    

    
}
