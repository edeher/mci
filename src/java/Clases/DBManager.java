/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Ing Edeher
 */
public class DBManager {private String URL;
    private String Driver;
    private String Error;

    public DBManager() {
//        Driver = "sun.jdbc.odbc.JdbcOdbcDriver";
//        URL ="jdbc:odbc:toyo_demo";
        Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        URL="jdbc:sqlserver://LENOVO:1433;databaseName=mci_5.3";
    }

    public Connection getConnection(){
        try{
            Class.forName(Driver).newInstance();
            return DriverManager.getConnection(URL,"sa","poderoso");
        }catch(Exception e){
        System.out.println("error 1 :"+e.getMessage());
        System.out.println("error 2 :"+e.getMessage());
        Error=e.getMessage();
        }
        return null;

    }
    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }


    public String getDriver() {
        return Driver;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }


}
