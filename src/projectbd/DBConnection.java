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
import java.util.logging.Level;
import java.util.logging.Logger;
import projectbd.Models.Bill;
import projectbd.Models.Meeting;
import projectbd.Models.MeetingPurchase;
import projectbd.Models.MeetingService;
import projectbd.Models.PersonalPurchase;
import projectbd.Models.PersonalService;
import projectbd.Models.PurchaseLine;
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
    public long writeDB(String params) {
        try (Connection conn = connection;
                PreparedStatement pstmt = conn.prepareStatement(params,
                Statement.RETURN_GENERATED_KEYS)) {
            
            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getLong(1);
                        
                    }
                    
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
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
    
    public long insertData(String data) {
        return writeDB("INSERT INTO " + data);
    }
    
    public long deleteData(String name, String data) {
        return writeDB("DELETE FROM " + name + " " + data);
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
    
    public MeetingService getMeetingService (String serviceid) {
        String SQL = "select * from servicioreunion where compraid = '" + serviceid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String meeting = rs.getString("reunionid"),
                       company = rs.getString("empresa"),
                       name = rs.getString("nombre"),
                       desc = rs.getString("descripcion"),
                       price = rs.getString("precio");
                
                return new MeetingService(serviceid, name, company, desc, Double.parseDouble(price), meeting);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public PersonalPurchase getPersonalPurchase (String purchaseid) {
        String SQL = "select * from comprapersonal where compraid = '" + purchaseid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String desc = rs.getString("descripcion"),
                       user = rs.getString("usuid");
                
                return new PersonalPurchase(purchaseid, desc, user);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public PersonalService getPersonalService (String serviceid) {
        String SQL = "select * from comprapersonal where compraid = '" + serviceid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String userId = rs.getString("usuid"),
                       company = rs.getString("empresa"),
                       name = rs.getString("nombre"),
                       desc = rs.getString("descripcion"),
                       date = rs.getString("fecha");
                
                return new PersonalService(serviceid, name, company, desc, date, userId);
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public PurchaseLine getPurchaseLine (String lineId, String purchaseId) {
        String SQL = "select * from comprapersonal where lineaid = '" + lineId + "' and compraid = '" + purchaseId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String product = rs.getString("nombre"),
                       quantity = rs.getString("cantidad");
                       
                return new PurchaseLine(purchaseId, product, Integer.parseInt(lineId), Double.parseDouble(quantity));
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Bill getBill(String billId) {
        String SQL = "select * from gasto where gastoid = '" + billId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                String name = rs.getString("nombre"),
                       price = rs.getString("precio"),
                       deadline = rs.getString("fecha"),
                       purchaseId = rs.getString("compraid"),
                       serviceId = rs.getString("servicioid"),
                       usuId = rs.getString("usuid"),
                       usuRef = rs.getString("usureferenciaid"),
                       paid = rs.getString("estapago"),
                       input = rs.getString("esingreso");
                       
                return new Bill(billId, name, Double.parseDouble(price), deadline, purchaseId, serviceId, usuId, usuRef, input.equals("true"), paid.equals("true"));
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public boolean dropMeetingService(String serviceId) {
        return false;
    }
    
    public boolean dropPersonalService(String serviceId) {
        return false;
    }
    
    public boolean dropMeetingPurchase(String purchaseId) {
        return false;
    }
    
    public boolean dropPersonalPurchase(String purchaseId) {
        return false;
    }
}
