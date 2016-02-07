/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author Ing. Edeher
 */
public class cPeriodo {

   private int idPeriodo;
   private int año;
   private int mes;
   private int semana;
   private Date fechaini;
   private Date fechafin;
   
   private String tema1;
   private String tema2;
   private String estado;
   private String mess;
   private Date fecha_actual;

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }
   
   
    public String getMess() {
        return mess;
    }
    public void setMess(String mess) {
        this.mess = mess;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTema2() {
        return tema2;
    }
    public void setTema2(String tema2) {
        this.tema2 = tema2;
    }
    public String getTema1() {
        return tema1;
    }
    public void setTema1(String tema1) {
        this.tema1 = tema1;
    }
   public Date getFechaini() {
        return fechaini;
    }
    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }
 public Date getFechafin() {
        return fechafin;
    }
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    public int getSemana() {
        return semana;
    }
    public void setSemana(int semana) {
        this.semana = semana;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public int getIdPeriodo() {
        return idPeriodo;
    }
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
    public cPeriodo() {
    }
    public cPeriodo(String mess) {
        this.mess = mess;
    }

    public cPeriodo(int semana) {
        this.semana = semana;
    }
    
    public cPeriodo(int idPeriodo, int año, int mes, int semana, Date fechaini, Date fechafin,String tema1, String tema2, String estado) {
        this.idPeriodo = idPeriodo;
        this.año = año;
        this.mes = mes;
        this.semana = semana;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.tema1 = tema1;
        this.tema2 = tema2;
        this.estado = estado;
    }

    public cPeriodo(int año, int mes, int semana) {
        this.año = año;
        this.mes = mes;
        this.semana = semana;
    }

    public cPeriodo(int año, int mes, int semana, Date fechaini,Date fechafin) {
        this.año = año;
        this.mes = mes;
        this.semana = semana;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
    }

    
    public cPeriodo(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

   
    
    public String toString() {
        return "cPeriodo{" + "idPeriodo=" + idPeriodo + ", a\u00f1o=" + año + ", mes=" + mes + ", semana=" + semana + ", fechaini=" + fechaini + ", fechafin=" + fechafin+ ", tema1=" + tema1 + ", tema2=" + tema2 + ", estado=" + estado + '}';
    }
    public String toString2() {
        return "cPeriodo{" +  " mess=" + mess + '}';
    }
public Vector BuscarTodo() {

//todos los periodos exiatentes
        Vector<cPeriodo> Lista = new Vector<cPeriodo>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_periodo_tt}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cPeriodo (
                                rs.getInt("idPeriodo"),
                                rs.getInt("año"), 
                                rs.getInt("mes"),
                                rs.getInt("semana"),
                                rs.getDate("fechaini") ,
                                rs.getDate("fechafin") ,
                                rs.getString("tema1"),
                                rs.getString("tema2"),
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

public Vector BuscarSemanaActual() {

//semana activa actual
        Vector<cPeriodo> Lista = new Vector<cPeriodo>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_perido_semana_actual}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cPeriodo (
                                
                                rs.getInt("semana")
                                
                        
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

public Vector BuscarTodo3() {

/*devuelve todo los periodos activos en el mes actual*/
        Vector<cPeriodo> Lista = new Vector<cPeriodo>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_periodo_ttf}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cPeriodo (
                                rs.getInt("idPeriodo"),
                                rs.getInt("año"), 
                                rs.getInt("mes"),
                                rs.getInt("semana"),
                                rs.getDate("fechaini") ,
                                rs.getDate("fechafin") ,
                                rs.getString("tema1"),
                                rs.getString("tema2"),
                                rs.getString("estado")
                                      )
                                );
                              }
            rs.close();
            stm.close();
            dbm = null;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return Lista;
    }
public Vector Buscar33(int mes,int anio) {
/*devuelve todos los periodos , ingresando mes y año*/
           Vector<cPeriodo> Lista = new Vector<cPeriodo>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_periodo_busMMAA(?,?)}");
              st.registerOutParameter(1,Types.INTEGER);
              st.setInt(1,mes);
              st.registerOutParameter(2,Types.INTEGER);
              st.setInt(2,anio);
              ResultSet rs = st.executeQuery();
              while(rs.next()){
                  Lista.addElement(new cPeriodo (
                                                    rs.getInt("idPeriodo"),
                                                    rs.getInt("año"), 
                                                    rs.getInt("mes"),
                                                    rs.getInt("semana"),
                                                    rs.getDate("fechaini") ,
                                                    rs.getDate("fechafin"),
                                                    rs.getString("tema1"),
                                                    rs.getString("tema2"),
                                                    rs.getString("estado")
                                                ));
                              }
              rs.close();
              st.close();
              dbm = null;
          }catch(Exception e){
              System.out.println("Error:"+e.getMessage());
          }
       return Lista;
    }
public boolean Crear(int año,int mes,int semana, String fecha,String tema1,String tema2,String estado) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_periodo_n(?,?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,año);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,mes);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,semana);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,fecha);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,tema1);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,tema2);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,estado);

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
public boolean Modificar(int idPeriodo,int año,int mes,int semana, String fecha,String tema1,String tema2,String estado) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_periodo_m(?,?,?,?,?,?,?,?) }");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idPeriodo);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,año);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,mes);
            st.registerOutParameter(4,Types.INTEGER);
            st.setInt(4,semana);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,fecha);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,tema1);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,tema2);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,estado);
            
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
            CallableStatement st=con.prepareCall("{call sp_periodo_e(?) }");
            st.registerOutParameter(1, Types.INTEGER);
            st.setInt(1,codigo);


            if (st.execute()) //devuelve verdadero si fallo
            {
                error = "No se puede Eliminar el periodo";
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
/*busca periodo por codigo*/
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_periodo_bco(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPeriodo(rs.getInt("idPeriodo"));
                  this.setAño(rs.getInt("año"));
                  this.setMes(rs.getInt("mes"));
                  this.setSemana(rs.getInt("semana"));
                  this.setFechaini(rs.getDate("fechaini"));
                   this.setFechafin(rs.getDate("fechafin"));
                  this.setTema1(rs.getString("tema1"));
                  this.setTema2(rs.getString("tema2"));
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
public boolean Buscar_actual() {
/*me muestra el  periodo activos actual*/
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_periodo_actual_total()}");
              
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPeriodo(rs.getInt("idPeriodo"));
                  this.setAño(rs.getInt("año"));
                  this.setMes(rs.getInt("mes"));
                  this.setSemana(rs.getInt("semana"));
                  this.setFechaini(rs.getDate("fechaini"));
                   this.setFechafin(rs.getDate("fechafin"));
                  this.setTema1(rs.getString("tema1"));
                  this.setTema2(rs.getString("tema2"));
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

public boolean Buscar_mes2() {
//devuelve el nombre mes actual
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call mes_periodo}");
              
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  
                  this.setMess(rs.getString("mess"));
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
public boolean Buscar_mes3(int mes) {
//devuelve el nombre del mes ingresando el numero de mes
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call mes_periodo_bus(?)}");
               st.registerOutParameter(1,Types.INTEGER);
              st.setInt(1,mes);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  
                  this.setMess(rs.getString("mes"));
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

public boolean periodo_actual123() {
 /* devuelve el año, mes y semana actual */
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_periodo_actual123()}");
              
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  
                  this.setAño(rs.getInt("año"));
                  this.setMes(rs.getInt("mes"));
                  this.setSemana(rs.getInt("semana"));
                   this.setFechaini(rs.getDate("fechaini"));
                   this.setFechafin(rs.getDate("fechafin"));

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
public boolean fecha_actual() {
 /* devuelve el año, mes y semana actual */
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_fecha_actual()}");
              
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  
                 
                  this.setFecha_actual(rs.getDate("fecha_actual"));
                               

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
public Vector BuscarTodo2() {


        Vector<cPeriodo> Lista = new Vector<cPeriodo>();
        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement stm=con.prepareCall("{call sp_periodo_actual_total}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                Lista.addElement(

                        new cPeriodo (
                                rs.getInt("idPeriodo"),
                                rs.getInt("año"), 
                                rs.getInt("mes"),
                                rs.getInt("semana"),
                                rs.getDate("fechaini") ,
                                 rs.getDate("fechafin") ,
                                rs.getString("tema1"),
                                rs.getString("tema2"),
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
 public Vector Buscar2(int mes, int semana) {

          Vector<cPeriodo> Lista = new Vector<cPeriodo>();
          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_periodo_bco1(?,?)}");
            st.registerOutParameter(1,Types.INTEGER);
             st.setInt(1,mes);
             st.registerOutParameter(1,Types.INTEGER);
             st.setInt(2,semana);
              ResultSet rs = st.executeQuery();

              while(rs.next())
                  Lista.addElement(
                          new cPeriodo(
                                  
                          rs.getInt("idPeriodo"),
                          
                          rs.getInt("año"),
                          rs.getInt("mes"),
                          rs.getInt("semana"),
                          rs.getDate("fechaini"),
                          rs.getDate("fechafin"),
                          rs.getString("tema1"),
                               rs.getString("tema2"),
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
 public boolean Crear2(int año,int mes,int semana, String fechaini,String fechafin,String tema1,String tema2,String estado) {
        String error = null;

        try {

            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_periodo_n(?,?,?,?,?,?,?,?)}");
            
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,año);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,mes);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,semana);
            st.registerOutParameter(4,Types.VARCHAR);
            st.setString(4,fechaini);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,fechafin);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,tema1);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,tema2);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,estado);

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
 public boolean Modificar2(int idPeriodo,int año,int mes,int semana, String fechaini,String fechafin,String tema1,String tema2,String estado) {
        String error = null;

        try {
            DBManager dbm = new DBManager();
            Connection con = dbm.getConnection();
            if (con == null) {
                throw new NullPointerException(dbm.getError());
            }
            CallableStatement st=con.prepareCall("{call sp_periodo_m(?,?,?,?,?,?,?,?,?) }");
            st.registerOutParameter(1,Types.INTEGER);
            st.setInt(1,idPeriodo);
            st.registerOutParameter(2,Types.INTEGER);
            st.setInt(2,año);
            st.registerOutParameter(3,Types.INTEGER);
            st.setInt(3,mes);
            st.registerOutParameter(4,Types.INTEGER);
            st.setInt(4,semana);
            st.registerOutParameter(5,Types.VARCHAR);
            st.setString(5,fechaini);
            st.registerOutParameter(6,Types.VARCHAR);
            st.setString(6,fechafin);
            st.registerOutParameter(7,Types.VARCHAR);
            st.setString(7,tema1);
            st.registerOutParameter(8,Types.VARCHAR);
            st.setString(8,tema2);
            st.registerOutParameter(9,Types.VARCHAR);
            st.setString(9,estado);
            
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
  public boolean Buscar54(int codigo) {

          try{
              DBManager dbm = new DBManager();
              Connection con = dbm.getConnection();
              if(con == null)
                  throw new NullPointerException(dbm.getError());
              CallableStatement st=con.prepareCall("{call sp_periodo_bco(?)}");
              st.registerOutParameter(1,Types.INTEGER);
                st.setInt(1,codigo);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
//                  return new cArea(rs.getString("idArea"),rs.getString("nombre"),rs.getString("abreviado"));
                  this.setIdPeriodo(rs.getInt("idPeriodo"));
                  this.setAño(rs.getInt("año"));
                  this.setMes(rs.getInt("mes"));
                  this.setSemana(rs.getInt("semana"));
                  this.setFechaini(rs.getDate("fechaini"));
                   this.setFechafin(rs.getDate("fechafin"));
                  this.setTema1(rs.getString("tema1"));
                  this.setTema2(rs.getString("tema2"));
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
}
