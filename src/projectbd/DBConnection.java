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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Bill;
import Models.Friends;
import Models.IPurchase;
import Models.IService;
import Models.Invited;
import Models.Meeting;
import Models.MeetingPurchase;
import Models.MeetingService;
import Models.PersonalPurchase;
import Models.PersonalService;
import Models.PurchaseLine;
import Models.User;
import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

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
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
            }
        }
    }
    
    //example of params: CREATE TABLE IF NOT EXISTS user(user_id SERIAL NOT NULL PRIMARY KEY,username varchar(225) NOT NULL UNIQUE,password varchar(225)";
    public String writeDB(String params) {
        try (Connection conn = connection;
                PreparedStatement pstmt = conn.prepareStatement(params,
                Statement.RETURN_GENERATED_KEYS)) {
            
            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getString(1);
                        
                    }
                    
                } catch (SQLException ex) {
                    if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
            }
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
            }
        }
        return "";
    }
    
    public boolean createTable(String params) {
        try {
            //conectDB();
            PreparedStatement ps = connection.prepareStatement(params);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
            }
        }
        return false;
    }
    
    public String insertData(String data) {
        return writeDB("INSERT INTO " + data);
    }
    
    public String updateData(String data) {
        return writeDB("UPDATE " + data);
    }
    
    public String deleteData(String name, String data) {
        return writeDB("DELETE FROM " + name + " " + data);
    }
    
    public User getUser (String usuId) {
        String SQL = "select * from usuarios where usuid = '" + usuId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String usuNom = rs.getString("usunom"),
                       usuPass = rs.getString("usupass"),
                       usuAdd = rs.getString("usuDir"),
                       usuMail = rs.getString("usumail");
            
                return new User(usuId, usuNom, usuPass, usuAdd, usuMail);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getUser(usuId);
            }
        }
        return null;
    }
    
    public Meeting getMeeting (String reuId) {
        String SQL = "select * from reunion where reunionid = '" + reuId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String place = rs.getString("lugar"),
                       desc = rs.getString("descripcion"),
                       org = rs.getString("organizadorid");
                boolean dontpay = rs.getString("nopagan").equals("true");
                String date = rs.getString("fecha");
                Timestamp t = new Timestamp(0);
                
                return new Meeting(reuId, place, t.valueOf(date), desc, dontpay, org);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().toLowerCase().contains("this connection has been closed")) {
                this.conectDB();
                return this.getMeeting(reuId);
            }
        }
        return null;
    }
    
    public MeetingPurchase getMeetingPurchase (String purchaseid) {
        String SQL = "select * from comprareunion where compraid = '" + purchaseid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String meeting = rs.getString("meetingid"),
                       desc = rs.getString("descripcion"),
                       amount = rs.getString("precio");
                
                return new MeetingPurchase(purchaseid, meeting, desc, Double.parseDouble(amount));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getMeetingPurchase(purchaseid);
            }
        }
        return null;
    }
    
    public MeetingService getMeetingService (String serviceid) {
        String SQL = "select * from servicioreunion where compraid = '" + serviceid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String meeting = rs.getString("reunionid"),
                       company = rs.getString("empresa"),
                       name = rs.getString("nombre"),
                       desc = rs.getString("descripcion"),
                       price = rs.getString("precio");
                
                return new MeetingService(serviceid, name, company, desc, Double.parseDouble(price), meeting);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getMeetingService(serviceid);
            }
        }
        return null;
    }
    
    public PersonalPurchase getPersonalPurchase (String purchaseid) {
        String SQL = "select * from comprapersonal where compraid = '" + purchaseid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String desc = rs.getString("descripcion"),
                       user = rs.getString("usuid");
                
                return new PersonalPurchase(purchaseid, desc, user);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getPersonalPurchase(purchaseid);
            }
        }
        return null;
    }
    
    public ArrayList<IPurchase> getAllPersonalPurchase(String usuid) {
        String SQL = "select * from comprapersonal where usuid = '" + usuid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                ArrayList<IPurchase> output = new ArrayList<>();
                while (rs.next()) {
                    String desc = rs.getString("descripcion"),
                           pId = rs.getString("compraid");
                    PersonalPurchase p = new PersonalPurchase(pId, desc, usuid);
                    output.add(p);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getAllPersonalPurchase(usuid);
            }
        }
        return null;
    }
    
    public PersonalService getPersonalService (String serviceid) {
        String SQL = "select * from serviciopersonal where servicioid = '" + serviceid + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String userId = rs.getString("usuid"),
                       company = rs.getString("empresa"),
                       name = rs.getString("nombre"),
                       desc = rs.getString("descripcion"),
                       date = rs.getString("fechaprogramada");
                Timestamp v = new Timestamp(0);
                return new PersonalService(serviceid, name, company, desc, v.valueOf(date), userId);
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getPersonalService(serviceid);
            }
        }
        return null;
    }
    
    public PurchaseLine getPurchaseLine (String lineId, String purchaseId) {
        String SQL = "select * from comprapersonal where lineaid = '" + lineId + "' and compraid = '" + purchaseId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
                String product = rs.getString("nombre"),
                       quantity = rs.getString("cantidad");
                       
                return new PurchaseLine(purchaseId, product, Integer.parseInt(lineId), Double.parseDouble(quantity));
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getPurchaseLine(lineId, purchaseId);
            }
        }
        return null;
    }
    
    public ArrayList<PurchaseLine> getPurchaseLines (String purchaseId) {
        String SQL = "select * from lineacompra where compraid = '" + purchaseId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                ArrayList<PurchaseLine> output = new ArrayList<>();
                while (rs.next()) {
                    String product = rs.getString("nombre"),
                           quantity = rs.getString("cantidad"),
                           lineId = rs.getString("lineaid");
                    
                    PurchaseLine pl = new PurchaseLine(purchaseId, product, Integer.parseInt(lineId), Double.parseDouble(quantity));
                    output.add(pl);
                } 
                return output;
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getPurchaseLines(purchaseId);
            }
        }
        return null;
    }
    
    public Bill getBill(String billId) {
        String SQL = "select * from gasto where gastoid = '" + billId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                rs.next();
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
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getBill(billId);
            }
        }
        return null;
    }
    
    public ArrayList<Invited> getInvited(String meetingId) {
        String SQL = "select * from invitados where reunionid = '" + meetingId + "'";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                ArrayList<Invited> output = new ArrayList<>();
                while (rs.next()) { //mirar gettable
                    String usuid = rs.getString("usuid"),
                           assisted = rs.getString("asistio");
                   
                    Invited inv = new Invited(usuid, meetingId, assisted.equals("true"));
                    output.add(inv);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getInvited(meetingId);
            }
        }
        return null;
    }
    
    public ArrayList<Friends> getFriends(String userId) throws SQLException{
        String sqlSentence = "select * from amigos where usuiduno = '"+ userId+"' or usuiddos = '"+ userId+"';" ;
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlSentence)){
                    ArrayList<Friends> output = new ArrayList<>();
                    while (rs.next()){
                        String usuiIdUno = rs.getString("usuiduno");
                        String usuiIdDos = rs.getString("usuiddos");
                        if (usuiIdUno.equals(userId)){
                            Friends friend = new Friends(userId, usuiIdDos);
                            output.add(friend);
                        }
                        else {
                            Friends friend = new Friends(usuiIdUno, userId);
                            output.add(friend);
                        }
                    }
                    return output;
                } catch (SQLException ex){
                    System.out.println(ex.getMessage());
                    if (ex.getMessage().contains("This connection has been closed")) {
                        this.conectDB();
                        return this.getFriends(userId);
                    }
                }
        return null;
           
    }
    
    /**
     * 0 = todos
     * 1 = a pagar no pago
     * 2 = a pagar pago
     * 3 = ingreso no pago
     * 4 = ingreso pago
     * @param usuid
     * @param opcion
     * @return 
     */
    public ArrayList<Bill> getUsersBills(String usuid, int opcion) { 
        String SQL = "";
        switch(opcion){
            case 0:
                SQL = "select * from gasto where usuid = '" + usuid + "'";
                break;
            case 1: 
                SQL = "select * from gasto where usuid = '" + usuid + "' and estapago = " + false +" and esingreso = " +false;
                break;
            case 2:
                SQL = "select * from gasto where usuid = '" + usuid + "' and estapago = "+ true + " and esingreso = " + false;
                break;
            case 3:
                SQL = "select * from gasto where usuid = '" + usuid + "' and estapago = "+ false + " and esingreso = " + true;
                break;
            case 4:
                SQL = "select * from gasto where usuid = '" + usuid + "' and estapago = "+ true + " and esingreso = " + true;
                break;
        }
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)) {
            ArrayList<Bill> output = new ArrayList<>();
            while (rs.next()) { 
                String billId = rs.getString("gastoid");
                String name = rs.getString("motivo");
                Double price = Double.parseDouble(rs.getString("montofinal"));
                String deadline = rs.getString("fecha");
                String purchaseId = rs.getString("compraid");
                String serviceId = rs.getString("servicioid");
                String billReferenceId = rs.getString("gastoreferencia");
                boolean isPaid = rs.getString("estapago").equals("true");
                boolean isInput = rs.getString("esingreso").equals("true");
                Bill bill = new Bill(billId, name, price, deadline, purchaseId, serviceId, usuid, billReferenceId, isInput, isPaid);
                output.add(bill);
            }
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getUsersBills(usuid, opcion);
            }
        }
        return null;
    }
    
    public ArrayList<Bill> getByExpDate(String usuid){
        Date d = new Date();
        long difference = d.getTime() + 60000*1440*3; // tres dias en milisegundos
        Timestamp newDate = new Timestamp(difference);
        String SQL = "select * from gasto where usuid = '" + usuid + "' and estapago = "+ false+" and esingreso = "+false+ " and fecha < " + newDate + ";"; //Si falla este metodo, revisar el <newDate
        
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)) {
            ArrayList<Bill> output = new ArrayList<>();
            while (rs.next()) { 
                String billId = rs.getString("gastoid");
                String name = rs.getString("motivo");
                Double price = Double.parseDouble(rs.getString("montofinal"));
                String deadline = rs.getString("fecha");
                String purchaseId = rs.getString("compraid");
                String serviceId = rs.getString("servicioid");
                String billReferenceId = rs.getString("gastoreferencia");
                boolean isPaid = rs.getString("estapago").equals("true");
                boolean isInput = rs.getString("esingreso").equals("true");
                Bill bill = new Bill(billId, name, price, deadline, purchaseId, serviceId, usuid, billReferenceId, isInput, isPaid);
                output.add(bill);
            }
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getByExpDate(usuid);
            }
        }
        return null;
    }
    
    //All meetings a user assisted to
    public ArrayList<Meeting> getAllMeetings(String usuid) {
        String SQL = "select reunionid from invitados where usuid = '" + usuid + "';";
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)) {
            ArrayList<Meeting> output = new ArrayList<>();
            while (rs.next()) { 
                String meetingId = rs.getString(1); //is the reunionid (may be index 0)
                Meeting meeting = this.getMeeting(meetingId);
                output.add(meeting); //gets the meeting which the user was invited
            }
                //SQL = "select organizadorid from reunion where reunionid = '" + meetingId + "';"; //need to bring all meetings the user has organized
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getAllMeetings(usuid);
            }
        }
        return null;
    }
    
    public ArrayList<Meeting> getAllOrganizedBy(String usuid) {
        String SQL = "select * from reunion where organizadorid = '" + usuid + "';";
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)) {
            ArrayList<Meeting> output = new ArrayList<>();
            while (rs.next()) {
                String place = rs.getString("lugar"),
                       desc = rs.getString("descripcion"),
                       meetingid = rs.getString("reunionid"),
                       date = rs.getString("fecha");
                       boolean dontpay = rs.getString("asistio").equals("true");
                Timestamp v = new Timestamp(0);
                Meeting meeting = new Meeting(meetingid, place, v.valueOf(date), desc, dontpay, usuid);
                output.add(meeting); //gets the meeting which the user was invited
            }
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getAllMeetings(usuid);
            }
        }
        return null;
    }
    
    
    //all meetings a user assisted (or not)
    public ArrayList<Meeting> getAssisted(String usuid, boolean assisted) {
        String SQL = "select reunionid from invitados where usuid = '" + usuid + "' and asistio = " + assisted + ";";
        //String SQL = "select * from reunion where (select reunionid from invitados where usuid = " + usuid + " and asistio = " + assisted + " and invitados.reunionid = reunion.reunionid)";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                ArrayList<Meeting> output = new ArrayList<>();
                while (rs.next()) { //mirar gettable
                    String meetingid = rs.getString("reunionid");
                    Meeting meeting = this.getMeeting(meetingid);
                    output.add(meeting);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getAssisted(usuid, assisted);
            }
        }
        return null;
    }
    
    //get all invited to a meeting
    public ArrayList<Invited> getInvitesMeeting(String meetingId) throws SQLException{
        String sqlSentence = "select usuid, asistio from invitados where reunionid = '"+ meetingId+"';" ;
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSentence)){
                ArrayList<Invited> output = new ArrayList<>();
                while (rs.next()){
                    String usuiId = rs.getString("usuid");
                    String assist = rs.getString("asistio");
                    Invited inv = new Invited(usuiId, meetingId, assist.equals("true"));
                    output.add(inv);
                }
                return output;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getInvitesMeeting(meetingId);
            }
        }
        return null;
    }    
    
    public ArrayList<IPurchase> getMeetingPurchases(String meetingId) throws SQLException{
        String sqlSentence = "select * from comprareunion where reunionid = '"+ meetingId+"';" ;
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSentence)){
                ArrayList<IPurchase> output = new ArrayList<>();
                while (rs.next()){
                    String purchaseid = rs.getString("compraid");
                    String description = rs.getString("descripcion");
                    String cost = rs.getString("costo");
                    MeetingPurchase purchase = new MeetingPurchase(purchaseid, meetingId, description, Double.parseDouble(cost));
                    output.add(purchase);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getMeetingPurchases(meetingId);
            }
        }
        return null;
    }    
    
    public ArrayList<IService> getMeetingServices(String meetingId) throws SQLException{
        String sqlSentence = "select * from servicioreunion where reunionid = '"+ meetingId+"';" ;
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSentence)){
                ArrayList<IService> output = new ArrayList<>();
                while (rs.next()){
                    String serviceId = rs.getString("servicioid");
                    String company = rs.getString("empresa");
                    String name = rs.getString("nombre");
                    String description = rs.getString("descripcion");
                    String cost = rs.getString("costo");
                    MeetingService service = new MeetingService(serviceId, name, company, description, Double.parseDouble(cost), meetingId);
                    output.add(service);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getMeetingServices(meetingId);
            }
        }
        return null;
    }
    
    public ArrayList<IService> getPersonalServices(String usuId) throws SQLException{
        String sqlSentence = "select * from serviciopersonal where usuid = '"+ usuId+"';" ;
        try (
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSentence)){
                ArrayList<IService> output = new ArrayList<>();
                while (rs.next()){
                    String serviceId = rs.getString("servicioid");
                    String company = rs.getString("empresa");
                    String name = rs.getString("nombre");
                    String description = rs.getString("descripcion");
                    String date = rs.getString("fechaprogramada");
                    Timestamp t = new Timestamp(0);
                    PersonalService service = new PersonalService(serviceId, name, company, description, t.valueOf(date), usuId);
                    output.add(service);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("This connection has been closed")) {
                this.conectDB();
                return this.getPersonalServices(usuId);
            }
        }
        return null;
    }
    
    /* ESTA REPETIDO
    public ArrayList<Invited> getAssistedToMeeting(String meetingId){
        String SQL = "select * from invitados where meetingId = '" + meetingId + "' and asistio = " + true + ";";
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                ArrayList<Invited> output = new ArrayList<>();
                while (rs.next()) { //mirar gettable
                    String usuid = rs.getString("usuid");
                    Invited inv = new Invited(usuid, meetingId, true);
                    output.add(inv);
                }
                return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }*/
    
}
    
