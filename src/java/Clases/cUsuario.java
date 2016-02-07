/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Ing. Edeher
 */
public class cUsuario {

    private int idUsuario;
    private int idPersona;
    private String usuario;
    private String clave;
    private String tipo;
    private int cod_1;
    private int cod_2;
    private int cod_3;

    public int getCod_3() {
        return cod_3;
    }

    public void setCod_3(int cod_3) {
        this.cod_3 = cod_3;
    }


    public int getCod_2() {
        return cod_2;
    }

    public void setCod_2(int cod_2) {
        this.cod_2 = cod_2;
    }


    public int getCod_1() {
        return cod_1;
    }

    public void setCod_1(int cod_1) {
        this.cod_1 = cod_1;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public cUsuario(int idUsuario, int idPersona, String usuario, String clave, String tipo, int cod_1, int cod_2, int cod_3) {
        this.idUsuario = idUsuario;
        this.idPersona = idPersona;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.cod_1 = cod_1;
        this.cod_2 = cod_2;
        this.cod_3 = cod_3;
    }

    public cUsuario() {
    }

    public cUsuario(int idUsuario, int idPersona, String usuario, String clave, String tipo) {
        this.idUsuario = idUsuario;
        this.idPersona = idPersona;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public cUsuario(int idPersona) {
        this.idPersona = idPersona;
    }

    
    @Override
    public String toString() {
        return "cUsuario{" + "idUsuario=" + idUsuario + ", idPersona=" + idPersona + ", usuario=" + usuario + ", clave=" + clave + ", tipo=" + tipo + ", cod_1=" + cod_1 + ", cod_2=" + cod_2 + ", cod_3=" + cod_3 + '}';
    }

    public boolean validar(String  usuario,String clave) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_validar_user(?,?)}");
              st.registerOutParameter(1,Types.VARCHAR);
                st.setString(1,usuario);
                st.registerOutParameter(2,Types.VARCHAR);
                st.setString(2,clave);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdUsuario(rs.getInt("idUsuario"));
                  this.setIdPersona(rs.getInt("idPersona"));
                  this.setUsuario(rs.getString("usuario"));
                  this.setClave(rs.getString("clave"));
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
