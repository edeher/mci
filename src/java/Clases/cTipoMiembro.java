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
public class cTipoMiembro {
    
    private int idTipoMiembro;
    
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


    public int getIdTipoMiembro() {
        return idTipoMiembro;
    }

    public void setIdTipoMiembro(int idTipoMiembro) {
        this.idTipoMiembro = idTipoMiembro;
    }

    public cTipoMiembro(int idTipoMiembro, String descripcion, String estado) {
        this.idTipoMiembro = idTipoMiembro;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public cTipoMiembro() {
    }

    public Vector BuscarTodo() {


        Vector<cTipoMiembro> Lista = new Vector<cTipoMiembro>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_tipomiembro_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cTipoMiembro (
                                rs.getInt("idTipoMiembro"),
                                rs.getString("descripcion"),
                                rs.getString("estado")));
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
