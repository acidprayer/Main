/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.controllers.LoginController;

/**
 *
 * @author Ivan
 */
public class DBConnection {
    
    private Connection conn;
    
    {
        String dbname = "Resto";
        String user = "ricam";
        String pass = "RE8sto13";
        String connectionUrl =
                "jdbc:sqlserver://192.168.1.86;"
                        + "database=Resto;"
                        + "user=ricam;"
                        + "password=RE8sto13;";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public Connection getConnection(){
        return conn;
    }
    
}
