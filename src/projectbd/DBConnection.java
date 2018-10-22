/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicoponcedeleon
 */
public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
            
    public Connection conectDB() {
        String url = "",
           user = "postgres",
           password = "postgres";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    
    private DBConnection() { }
    
    public static DBConnection Instance() { 
        if (instance == null) {     
            instance = new DBConnection();
        }
        return instance;
    }   
    
    public void createDataBasae () {
        try {
            String createDBase = "CREATE DATABASE dbproject";
            PreparedStatement ps = connection.prepareStatement(createDBase);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //example of params: CREATE TABLE IF NOT EXISTS user(user_id SERIAL NOT NULL PRIMARY KEY,username varchar(225) NOT NULL UNIQUE,password varchar(225)";
    public boolean writeDB(String params) {
        try {
            conectDB();
            PreparedStatement ps = connection.prepareStatement(params);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery(params);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
