/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Ing. Edeher
 */
public class cRedTrabajo {
    
    private int idRedTrabajo;
    
    private String descripcion;
    
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getIdRedTrabajo() {
        return idRedTrabajo;
    }

    public void setIdRedTrabajo(int idRedTrabajo) {
        this.idRedTrabajo = idRedTrabajo;
    }

    public cRedTrabajo(int idRedTrabajo, String descripcion) {
        this.idRedTrabajo = idRedTrabajo;
        this.descripcion = descripcion;
    }

    public cRedTrabajo(int idRedTrabajo, String descripcion, String estado) {
        this.idRedTrabajo = idRedTrabajo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public cRedTrabajo() {
    }

    @Override
    public String toString() {
        return "cRedTrabajo{" + "idRedTrabajo=" + idRedTrabajo + ", descripcion=" + descripcion + '}';
    }
    
public Vector BuscarTodo() {


        Vector<cRedTrabajo> Lista = new Vector<cRedTrabajo>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_red_trabajo_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cRedTrabajo(rs.getInt("idRedTrabajo"), rs.getString("descripcion")));
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
    
}
