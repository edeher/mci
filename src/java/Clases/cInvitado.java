/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Vector;

/**
 *
 * @author Ing. Edeher
 */
public class cInvitado {
    
    private int idInvitado;
    private int idCelula;
    private int idPeriodo;
     private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private String sexo;
    private String direccion;
    private String referencia;
    private String fecha_nac;
    private int edad;
    private String telefono;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }


    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }


    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

   

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }


    public int getIdCelula() {
        return idCelula;
    }

    public void setIdCelula(int idCelula) {
        this.idCelula = idCelula;
    }


    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    public cInvitado() {
    }

    public cInvitado(int idInvitado, int idCelula, int idPeriodo, String nombres, String ape_paterno, String ape_materno, String sexo, String direccion, String referencia, String fecha_nac, int edad, String telefono, String estado) {
        this.idInvitado = idInvitado;
        this.idCelula = idCelula;
        this.idPeriodo = idPeriodo;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.sexo = sexo;
        this.direccion = direccion;
        this.referencia = referencia;
        this.fecha_nac = fecha_nac;
        this.edad = edad;
        this.telefono = telefono;
        this.estado = estado;
    }

   
    @Override
    public String toString() {
        return "cInvitado{" + "idInvitado=" + idInvitado + ", idCelula=" + idCelula + ", idPeriodo=" + idPeriodo + ", nombres=" + nombres + ", ape_paterno=" + ape_paterno + ", ape_materno=" + ape_materno + ", sexo=" + sexo + ", direccion=" + direccion + ", referencia=" + referencia + ", fecha_nac=" + fecha_nac + ", edad=" + edad + ", telefono=" + telefono + ", estado=" + estado + '}';
    }
   public String toString1() {
        return "cInvitado{" + "idInvitado=" + idInvitado + ", idCelula=" + idCelula + ", idPeriodo=" + idPeriodo + ", ape_paterno=" + ape_paterno + ", ape_materno=" + ape_materno + ", sexo=" + sexo + ", direccion=" + direccion + ", referencia=" + referencia + ", fecha_nac=" + fecha_nac + ", edad=" + edad + ", telefono=" + telefono + ", nombres=" + nombres + '}';
    }


     public boolean Crear(int idCelula, int idPeriodo,String nombres, String ape_paterno, String ape_materno, String sexo,String direccion, String referencia,String fecha_nac, String telefono, String estado) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_invitado_n(?,?,?,?,?,?,?,?,?,?,?)}");
            
            st.setInt(1,idCelula);
            st.setInt(2,idPeriodo);
            st.setString(3,nombres);
            st.setString(4,ape_paterno);
            st.setString(5,ape_materno);
            st.setString(6,sexo);
            st.setString(7,direccion);
            st.setString(8,referencia);
            st.setString(9,fecha_nac);
            st.setString(10,telefono);
            st.setString(11,estado);
                 
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar al invitado";
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
     public Vector BuscarTodot() {
        Vector<cInvitado> Lista = new Vector<cInvitado>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_invitado_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cInvitado (
                                rs.getInt("idInvitado"),
                                rs.getInt("idCelula") ,
                                rs.getInt("idPeriodo"),
                                rs.getString("nombres"),
                                rs.getString("ape_paterno"),
                                rs.getString("ape_materno"),
                                rs.getString("sexo"),
                                rs.getString("direccion"),
                                rs.getString("referencia"),
                                rs.getString("fecha_nac"),
                                rs.getInt("edad"),
                                rs.getString("telefono"),
                                rs.getString("estado")
                              
                        
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
     public Vector BuscarTodot2(String direccion) {
        Vector<cInvitado> Lista = new Vector<cInvitado>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_invitado_busdic(?)}");
            stm.registerOutParameter(1,Types.VARCHAR);
             stm.setString(1,direccion);
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cInvitado (
                                rs.getInt("idInvitado"),
                                rs.getInt("idCelula") ,
                                rs.getInt("idPeriodo"),
                                rs.getString("nombres"),
                                rs.getString("ape_paterno"),
                                rs.getString("ape_materno"),
                                rs.getString("sexo"),
                                rs.getString("direccion"),
                                rs.getString("referencia"),
                                rs.getString("fecha_nac"),
                                rs.getInt("edad"),
                                rs.getString("telefono"),
                                rs.getString("estado")
                              
                        
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
      public Vector BuscarTodot3(int codigo) {
        Vector<cInvitado> Lista = new Vector<cInvitado>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_Invitado_busidcel(?)}");
            stm.registerOutParameter(1,Types.INTEGER);
             stm.setInt(1,codigo);
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cInvitado (
                                rs.getInt("idInvitado"),
                                rs.getInt("idCelula") ,
                                rs.getInt("idPeriodo"),
                                rs.getString("nombres"),
                                rs.getString("ape_paterno"),
                                rs.getString("ape_materno"),
                                rs.getString("sexo"),
                                rs.getString("direccion"),
                                rs.getString("referencia"),
                                rs.getString("fecha_nac"),
                                rs.getInt("edad"),
                                rs.getString("telefono"),
                                rs.getString("estado")
                              
                        
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
      public boolean Buscar1(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_Invitado_busidcel(?)}");
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdInvitado(rs.getInt("idInvitado"));
                  this.setIdCelula(rs.getInt("idCelula"));
                   this.setIdPeriodo(rs.getInt("idPeriodo"));
                  this.setNombres(rs.getString("nombres"));
                  this.setApe_paterno(rs.getString("ape_paterno"));
                  this.setApe_materno(rs.getString("ape_materno"));
                  this.setSexo(rs.getString("sexo"));
                  this.setDireccion(rs.getString("direccion"));
                  this.setReferencia(rs.getString("referencia"));
                 this.setFecha_nac(rs.getString("fecha_nac"));
                  this.setEdad(rs.getInt("edad"));
                  this.setTelefono(rs.getString("telefono"));
                  this.setEstado(rs.getString("estado"));
                  

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
      public boolean Modificar(int idInvitado,int idCelula,int idPeriodo,String nombres,String ape_paterno,String ape_materno,String sexo, String direccion, String referencia,String fecha_nac, String telefono,  String estado) {
        String error = null; 

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_invitado_m(?,?,?,?,?,?,?,?,?,?,?,?)}");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idInvitado);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idCelula);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,idPeriodo);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,nombres);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,ape_paterno);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,ape_materno);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,sexo);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,direccion);
            st.registerOutParameter(9,Types.VARCHAR);
            st.setString(9,referencia);
            st.registerOutParameter(10,Types.VARCHAR);
            st.setString(10,fecha_nac);
            st.registerOutParameter(11,Types.VARCHAR);
            st.setString(11,telefono);
            st.registerOutParameter(12,Types.VARCHAR);
            st.setString(12,estado);
            
            

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar el invitado..";
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
            CallableStatement st=con.prepareCall("{call sp_invitado_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el Invitado";
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
