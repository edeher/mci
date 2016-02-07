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
public class cPersona {  private int idPersona;
    private String nomcompleto;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private String sexo;
    private String direccion;
    private String referencia;
    private int edad;
    private String fecha_nac;
    private String telefono;
    private String tipodoc;
    private String nro_identidad;
    private String profesion;
    private String estadocivil;
    private String observaciones;
    private String tipmiembro;
    private int idMiembro;
    private String estado;

    
    
   
    public String getEstado() {
        return estado;
    }

    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

   
    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getTipmiembro() {
        return tipmiembro;
    }
    public void setTipmiembro(String tipmiembro) {
        this.tipmiembro = tipmiembro;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getProfesion() {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    public String getNro_identidad() {
        return nro_identidad;
    }
    public void setNro_identidad(String nro_identidad) {
        this.nro_identidad = nro_identidad;
    }
   
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTipodoc() {
        return tipodoc;
    }
    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }
    public String getFecha_nac() {
        return fecha_nac;
    }
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
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
    public String getNomcompleto() {
        return nomcompleto;
    }
    public void setNomcompleto(String nomcompleto) {
        this.nomcompleto = nomcompleto;
    }
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public cPersona(int idPersona, String nomcompleto, String direccion, int edad, String telefono, String tipmiembro,int idMiembro) {
        this.idPersona = idPersona;
        this.nomcompleto = nomcompleto;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.tipmiembro = tipmiembro;
        this.idMiembro=idMiembro;
    }
    public cPersona(int idPersona, String nomcompleto, String direccion, int edad, String telefono, String tipmiembro) {
        this.idPersona = idPersona;
        this.nomcompleto = nomcompleto;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.tipmiembro = tipmiembro;
        
    }
    public cPersona(int idPersona, String nomcompleto, String direccion, int edad, String telefono) {
        this.idPersona = idPersona;
        this.nomcompleto = nomcompleto;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        
    }
   
    public cPersona(String tipmiembro) {
        this.tipmiembro = tipmiembro;
    }

    public cPersona(int idPersona, String nombres, String ape_paterno, String ape_materno, String sexo, String direccion, String referencia, int edad, String fecha_nac, String telefono, String tipodoc, String nro_identidad, String profesion, String observaciones) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.sexo = sexo;
        this.direccion = direccion;
        this.referencia = referencia;
        this.edad = edad;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.tipodoc = tipodoc;
        this.nro_identidad = nro_identidad;
        this.profesion = profesion;
        this.observaciones = observaciones;
    }

    public cPersona(int idPersona, String nombres, String ape_paterno, String ape_materno, String sexo, String direccion, String referencia, int edad, String fecha_nac, String telefono, String tipodoc, String nro_identidad, String profesion, String estadocivil, String observaciones) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.sexo = sexo;
        this.direccion = direccion;
        this.referencia = referencia;
        this.edad = edad;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.tipodoc = tipodoc;
        this.nro_identidad = nro_identidad;
        this.profesion = profesion;
        this.estadocivil = estadocivil;
        this.observaciones = observaciones;
    }

    public cPersona(int idPersona, String nombres, String ape_paterno, String ape_materno, String sexo, String direccion, String referencia, int edad, String fecha_nac, String telefono, String tipodoc, String nro_identidad, String profesion, String estadocivil, String observaciones, String estado) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.sexo = sexo;
        this.direccion = direccion;
        this.referencia = referencia;
        this.edad = edad;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.tipodoc = tipodoc;
        this.nro_identidad = nro_identidad;
        this.profesion = profesion;
        this.estadocivil = estadocivil;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    
    
    public cPersona() {
    }

    @Override
    public String toString() {
        return "cPersona{" + "idPersona=" + idPersona + ", nomcompleto=" + nomcompleto + ", direccion=" + direccion  + ", edad=" + edad + ", telefono=" + telefono + ", tipmiembro=" + tipmiembro+ ", idMiembro=" + idMiembro+ '}';
    }
    public String toString2() {
        return "cPersona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", ape_paterno=" + ape_paterno + ", ape_materno=" + ape_materno + ", sexo=" + sexo + ", direccion=" + direccion + ", referencia=" + referencia + ", edad=" + edad + ", fecha_nac=" + fecha_nac + ", telefono=" + telefono + ", tipodoc=" + tipodoc + ", nro_identidad=" + nro_identidad + ", profesion=" + profesion + ", estadocivil=" + estadocivil + ", observaciones=" + observaciones + '}';
    }
    public String toString3() {
        return "cPersona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", ape_paterno=" + ape_paterno + ", ape_materno=" + ape_materno + ", sexo=" + sexo + ", direccion=" + direccion + ", referencia=" + referencia + ", edad=" + edad + ", fecha_nac=" + fecha_nac + ", telefono=" + telefono + ", tipodoc=" + tipodoc + ", nro_identidad=" + nro_identidad + ", profesion=" + profesion + ", estadocivil=" + estadocivil + ", observaciones=" + observaciones + ", estado=" + getEstado() + '}';
    }

    
    
    
    public Vector BuscarTodo() {


        Vector<cPersona> Lista = new Vector<cPersona>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_persona_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cPersona (
                                rs.getInt("idPersona"),
                                rs.getString("nombres"), 
                                rs.getString("ape_paterno"),
                                rs.getString("ape_materno"),
                                rs.getString("sexo"),
                                rs.getString("direccion") ,
                                rs.getString("referencia"),
                                rs.getInt("edad"),
                                rs.getString("fecha_nac"),
                                rs.getString("telefono"),
                                rs.getString("TipoIdentidad"),
                                rs.getString("nro_identidad"),
                                rs.getString("profesion"),
                                rs.getString("estadocivil"),
                                rs.getString("observaciones"),
                                rs.getString("estado")
                        )
                        
                        );
            }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error 1:" + e.getMessage());
        }
        return Lista;
    }
   
    public boolean Crear(String nombres, String ape_paterno, String ape_materno, String sexo,String direccion, String referencia,String fecha_nac, String telefono, int idTipoIdentidad, String nro_identidad, int idTipoPersona,String profesion, String observaciones) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_persona_n(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.VARCHAR);
            st.setString(1,nombres);
            st.registerOutParameter(2,Types.VARCHAR);
            st.setString(2,ape_paterno);
            st.registerOutParameter(3,Types.VARCHAR);
            st.setString(3,ape_materno);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,sexo);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,direccion);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,referencia);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,fecha_nac);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,telefono);
            st.registerOutParameter(9,Types.INTEGER);
            st.setInt(9,idTipoIdentidad);
            st.registerOutParameter(10,Types.VARCHAR);
            st.setString(10,nro_identidad);
            st.registerOutParameter(11,Types.INTEGER);
            st.setInt(11,idTipoPersona);
            st.registerOutParameter(12,Types.VARCHAR);
            st.setString(12,profesion);
            st.registerOutParameter(13,Types.VARCHAR);
            st.setString(13,observaciones);

            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede registrar la persona";
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
    public int  Crear2(String nombres,
            String ape_paterno, 
            String ape_materno, 
            String sexo,
            String direccion,
            String referencia,
            String fecha_nac, 
            String telefono, 
            int idTipoIdentidad, 
            String nro_identidad,
            int idTipoPersona,
            String profesion, 
            String observaciones) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_persona_n2(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setString(2,nombres);
            st.setString(3,ape_paterno);
            st.setString(4,ape_materno);
            st.setString(5,sexo);
            st.setString(6,direccion);
            st.setString(7,referencia);
            st.setString(8,fecha_nac);
            st.setString(9,telefono);
            st.setInt(10,idTipoIdentidad);
            st.setString(11,nro_identidad);
            st.setInt(12,idTipoPersona);
            st.setString(13,profesion);
            
            st.setString(14,observaciones);
            
            
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
    public boolean Modificar( int idPersona,String nombres,  String ape_paterno, String ape_materno, String sexo,String direccion, String referencia,String fecha_nac, String telefono, int idTipoIdentidad, String nro_identidad, int idTipoPersona,String profesion,  String observaciones) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_persona_m(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idPersona);
            st.registerOutParameter(2,Types.VARCHAR);
            st.setString(2,nombres);
            st.registerOutParameter(3,Types.VARCHAR);
            st.setString(3,ape_paterno);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,ape_materno);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,sexo);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,direccion);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,referencia);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,fecha_nac);
            st.registerOutParameter(9,Types.VARCHAR);
            st.setString(9,telefono);
            st.registerOutParameter(10,Types.INTEGER);
            st.setInt(10,idTipoIdentidad);
            st.registerOutParameter(11,Types.VARCHAR);
            st.setString(11,nro_identidad);
            st.registerOutParameter(12,Types.INTEGER);
            st.setInt(12,idTipoPersona);
            st.registerOutParameter(13,Types.VARCHAR);
            st.setString(13,profesion);
            st.registerOutParameter(14,Types.VARCHAR);
            st.setString(14,observaciones);
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede modificar la persona";
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
            CallableStatement st=con.prepareCall("{call sp_persona_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar la persona";
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
              CallableStatement st=con.prepareCall("{call sp_persona_bco2(?)}");
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPersona(rs.getInt("idPersona"));
                  this.setNombres(rs.getString("nombres"));
                  this.setApe_paterno(rs.getString("ape_paterno"));
                  this.setApe_materno(rs.getString("ape_materno"));
                  this.setSexo(rs.getString("sexo"));
                  this.setDireccion(rs.getString("direccion"));
                  this.setReferencia(rs.getString("referencia"));
                  this.setEdad(rs.getInt("edad"));
                  this.setFecha_nac(rs.getString("fecha_nac"));
                  this.setTelefono(rs.getString("telefono"));
                  this.setTipodoc(rs.getString("TipoIdentidad"));
                  this.setNro_identidad(rs.getString("nro_identidad"));
                  this.setProfesion(rs.getString("profesion"));
                  this.setEstadocivil(rs.getString("estadocivil"));
                  this.setObservaciones(rs.getString("observaciones"));
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
    public boolean Buscar2(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_persona_bco1(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPersona(rs.getInt("idPersona"));
                  this.setNomcompleto(rs.getString("miembros"));
                  this.setDireccion(rs.getString("direccion"));
                  this.setEdad(rs.getInt("edad"));
                  this.setTelefono(rs.getString("telefono"));
                  


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
   
    public boolean Buscarlider(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idpersona4(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPersona(rs.getInt("idPersona"));
                  this.setNomcompleto(rs.getString("miembros"));
                  this.setDireccion(rs.getString("direccion"));
                  this.setEdad(rs.getInt("edad"));
                  this.setTelefono(rs.getString("telefono"));
                  this.setTipmiembro(rs.getString("tipmiembro"));

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
    public boolean Buscarlider2(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idcelula1(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPersona(rs.getInt("idPersona"));
                  this.setNomcompleto(rs.getString("miembros"));
                  this.setDireccion(rs.getString("direccion"));
                  this.setEdad(rs.getInt("edad"));
                  this.setTelefono(rs.getString("telefono"));
                  this.setTipmiembro(rs.getString("tipmiembro"));

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
    public Vector Buscarmiembro(int idPersona) {

           Vector<cPersona> Lista = new Vector<cPersona>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idpersona3(?)}");
                st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,idPersona);
                ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                          new cPersona(
                                  
                          rs.getInt("idPersona"),
                          
                          rs.getString("miembros"),
                          rs.getString("direccion"),
                          rs.getInt("edad"),
                          rs.getString("telefono"),
                          rs.getString("tipmiembro"),
                                  rs.getInt("idMiembro")
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
    public Vector Buscarmiembro3(int idPersona) {

           Vector<cPersona> Lista = new Vector<cPersona>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idpersona6(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,idPersona);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                          new cPersona(
                                  
                          rs.getInt("idPersona"),
                          rs.getString("miembros"),
                          rs.getString("direccion"),
                          rs.getInt("edad"),
                          rs.getString("telefono"),
                          rs.getString("tipmiembro"),
                                   rs.getInt("idMiembro")
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
    public Vector Buscarmiembro2(int idcelula) {

           Vector<cPersona> Lista = new Vector<cPersona>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_celulas_idcelula2(?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,idcelula);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                          new cPersona(
                                  
                          rs.getInt("idPersona"),
                          rs.getString("miembros"),
                          rs.getString("direccion"),
                          rs.getInt("edad"),
                          rs.getString("telefono"),
                          rs.getString("tipmiembro"),
                          rs.getInt("idMiembro")
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
    public boolean Buscar2(String nombres) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_persona_tttN(?)}");
              st.registerOutParameter(1,Types.VARCHAR);
                st.setString(1,nombres);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPersona(rs.getInt("idPersona"));
                  this.setNombres(rs.getString("nombres"));
                  this.setApe_paterno(rs.getString("ape_paterno"));
                  this.setApe_materno(rs.getString("ape_materno"));
                  this.setSexo(rs.getString("sexo"));
                  this.setDireccion(rs.getString("direccion"));
                  this.setReferencia(rs.getString("referencia"));
                  this.setEdad(rs.getInt("edad"));
                  this.setFecha_nac(rs.getString("fecha_nac"));
                  this.setTelefono(rs.getString("telefono"));
                  this.setTipodoc(rs.getString("TipoIdentidad"));
                  this.setNro_identidad(rs.getString("nro_identidad"));
                  this.setProfesion(rs.getString("profesion"));
                  this.setEstadocivil(rs.getString("estadocivil"));
                  this.setObservaciones(rs.getString("observaciones"));
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
    public Vector Buscar3(String nombres) {

           Vector<cPersona> Lista = new Vector<cPersona>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_persona_tttN(?)}");
            st.registerOutParameter(1,Types.VARCHAR);
             st.setString(1,nombres);

              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                          new cPersona(
                                  
                            rs.getInt("idPersona"),
                            rs.getString("nombres"),
                            rs.getString("ape_paterno"),
                            rs.getString("ape_materno"),
                            rs.getString("sexo"),
                            rs.getString("direccion"),
                            rs.getString("referencia"),
                            rs.getInt("edad"),
                            rs.getString("fecha_nac"),
                            rs.getString("telefono"),
                            rs.getString("TipoIdentidad"),
                            rs.getString("nro_identidad"),
                            rs.getString("profesion"),
                            rs.getString("estadocivil"),
                            rs.getString("observaciones"),
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
    public boolean Buscarlider3(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_persona_lid(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//         return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setTipmiembro(rs.getString("tipomiembro"));;

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
