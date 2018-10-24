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
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectbd.Models.Meeting;
import projectbd.Models.MeetingPurchase;
import projectbd.Models.User;

/**
 *
 * @author federicoponcedeleon
 */
public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
            
    public Connection conectDB() {
        String url = "jdbc:postgresql://localhost:5432/",
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
    
    public void createDataBase () {
        try {
            //conectDB();
            String createDBase = "CREATE DATABASE project";
            PreparedStatement ps = connection.prepareStatement(createDBase);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //example of params: CREATE TABLE IF NOT EXISTS user(user_id SERIAL NOT NULL PRIMARY KEY,username varchar(225) NOT NULL UNIQUE,password varchar(225)";
    public boolean writeDB(String params) {
        try {
            //conectDB();
            PreparedStatement ps = connection.prepareStatement(params);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery(params);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean createTable(String params) {
        try {
            //conectDB();
            PreparedStatement ps = connection.prepareStatement(params);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet getTable() {
        String SQL = "SELECT * FROM Usuarios WHERE LOWER(usunom)='enzo'";
 
        try (Connection conn = connection;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(rs.getString("usuid") + " " + rs.getString("usunom") + " " + rs.getString("usupass")+  "\t" );
        }
            return rs;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void insertUser() {
        String SQL = "INSERT INTO Usuarios(usuid, usunom, usudir, usumail, usupass) VALUES(120,'Enzo', 'pepito', '@gmail', 'soygato');";
 
        long id = 0;
 
        try (Connection conn = connection;
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            
            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                        System.out.println("Se agrego con id: " + id);
                    }
                    
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public User getUser (String usuId) {
        String SQL = "select * from usuarios where usuid = '" + usuId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String usuNom = rs.getString("usunom"),
                       usuPass = rs.getString("usupass"),
                       usuAdd = rs.getString("usuDir"),
                       usuMail = rs.getString("usumail");
            
                return new User(usuId, usuNom, usuPass, usuAdd, usuMail);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Meeting getMeeting (String reuId) {
        String SQL = "select * from reunion where reunionid = '" + reuId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String place = rs.getString("lugar"),
                       desc = rs.getString("descripcion"),
                       org = rs.getString("organizador"),
                       date = rs.getString("fecha");
                
                return new Meeting(reuId, place, date, desc, org);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public MeetingPurchase getMeetingPurchase (String purchaseid) {
        String SQL = "select * from comprareunion where compraid = '" + purchaseid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String meeting = rs.getString("meetingid"),
                       desc = rs.getString("descripcion"),
                       amount = rs.getString("precio");
                
                return new MeetingPurchase(purchaseid, meeting, desc, Double.parseDouble(amount));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
