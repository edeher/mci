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
 * @author Mi Laptop
 */
public class cOfrendaInvitados {
    
    private int idOfrenda ;
    private int idCelula;
    private int idPeriodo;
    private double monto;
    private int nroinvitados;
    private String estado;

    /**
     * @return the idOfrenda
     */
    public int getIdOfrenda() {
        return idOfrenda;
    }

    /**
     * @param idOfrenda the idOfrenda to set
     */
    public void setIdOfrenda(int idOfrenda) {
        this.idOfrenda = idOfrenda;
    }

    /**
     * @return the idCelula
     */
    public int getIdCelula() {
        return idCelula;
    }

    /**
     * @param idCelula the idCelula to set
     */
    public void setIdCelula(int idCelula) {
        this.idCelula = idCelula;
    }

    /**
     * @return the idPeriodo
     */
    public int getIdPeriodo() {
        return idPeriodo;
    }

    /**
     * @param idPeriodo the idPeriodo to set
     */
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the nroinvitados
     */
    public int getNroinvitados() {
        return nroinvitados;
    }

    /**
     * @param nroinvitados the nroinvitados to set
     */
    public void setNroinvitados(int nroinvitados) {
        this.nroinvitados = nroinvitados;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public cOfrendaInvitados(int idOfrenda, int idCelula, int idPeriodo, double monto, int nroinvitados, String estado) {
        this.idOfrenda = idOfrenda;
        this.idCelula = idCelula;
        this.idPeriodo = idPeriodo;
        this.monto = monto;
        this.nroinvitados = nroinvitados;
        this.estado = estado;
    }

    public cOfrendaInvitados(int idOfrenda, int idCelula, int idPeriodo, double monto, int nroinvitados) {
        this.idOfrenda = idOfrenda;
        this.idCelula = idCelula;
        this.idPeriodo = idPeriodo;
        this.monto = monto;
        this.nroinvitados = nroinvitados;
    }

    public cOfrendaInvitados() {
    }

    @Override
    public String toString() {
        return "cOfrendaInvitados{" + "idOfrenda=" + idOfrenda + ", idCelula=" + idCelula + ", idPeriodo=" + idPeriodo + ", monto=" + monto + ", nroinvitados=" + nroinvitados + ", estado=" + estado + '}';
    }
    
    public Vector BuscarTodo() {

//todos los periodos exiatentes
        Vector<cOfrendaInvitados> Lista = new Vector<cOfrendaInvitados>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_ofrendainvi_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cOfrendaInvitados(
                                rs.getInt("idPOfrenda"),
                                rs.getInt("idCelula"), 
                                rs.getInt("idPeriodo"),
                                rs.getDouble("monto"),
                                rs.getInt("fnroinvitados") ,
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
    public boolean Buscar_por_idce_idperi(int idCelula, int idPeriodo) {
/*busca periodo por codigo*/
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_ofrendainvi_bco_idce_idperi(?,?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,idCelula);
                st.registerOutParameter(2,Types.INTEGER);
                st.setInt(2,idPeriodo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdOfrenda(rs.getInt("idOfrenda"));
                  this.setIdCelula(rs.getInt("idCelula"));
                  this.setIdPeriodo(rs.getInt("idPeriodo"));
                  this.setMonto(rs.getDouble("monto"));
                  this.setNroinvitados(rs.getInt("nroinvitados"));
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
    public boolean Crear2(int idCelula,int idPeriodo,double monto, int nroinvitados) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_ofrendainvi_n(?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idCelula);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,idPeriodo);
            st.registerOutParameter(3,Types.DOUBLE);
            st.setDouble(3,monto);
            st.registerOutParameter(4,Types.INTEGER);
            st.setInt(4,nroinvitados);
           
           

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
}
