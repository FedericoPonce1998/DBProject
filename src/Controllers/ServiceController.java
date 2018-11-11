/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.UUID;
import projectbd.DBConnection;
import Models.Meeting;
import Models.MeetingService;
import Models.PersonalPurchase;
import Models.PersonalService;
import Models.User;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicoponcedeleon
 */
public class ServiceController {
    private static ServiceController instance;
    
    private ServiceController() {}
    
    public static ServiceController instance() {
        if (instance == null) {     
            instance = new ServiceController();
        }
        return instance;
    }
    
    public String createMeetingService(String name, String company, String description, Double price, String meetingId) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the meeting exists
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting != null) {
            String newId;
            try {
                newId = MainController.getHash(name+company+description+price+meetingId);
            } catch (NoSuchAlgorithmException ex) {
                newId = UUID.randomUUID().toString();
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return db.insertData("serviciosreuniones(servicioid, nombre, empresa, descripcion, costo, reunionid) " 
                    + "VALUES('" + newId + "', '" + name + "', '" + company + "', '" + description + "', " + price + ", '" + meetingId + "');");
        }
        return "";
    }
    
    public String createPersonalService(String name, String company, String description, Timestamp date, String userId) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the user exists
        User user = db.getUser(userId);
        if (user != null) {
            String newId;
            try {
                newId = MainController.getHash(name+company+description+date.toString()+userId);
            } catch (NoSuchAlgorithmException ex) {
                newId = UUID.randomUUID().toString();
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return db.insertData("servicioscompras(servicioid, empresa, nombre, fechaprogramada, descripcion, usuid) " 
                    + "VALUES('" + newId + "', '" + company + "', '" + name + "', TO_TIMESTAMP('" + date + "', 'YYYY-MM-DD HH24:MI:SS.FF'), '" + description + "', '" + userId + "');");
        }
        return "";
    }
    
    public MeetingService getMeetingService(String serviceId) {
        DBConnection db = DBConnection.Instance();
        return db.getMeetingService(serviceId);
    }
    
    public PersonalService getPersonalService(String serviceId) {
        DBConnection db = DBConnection.Instance();
        return db.getPersonalService(serviceId);
    }
    
    public boolean deleteMeetingService(String serviceId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE servicioid = '" + serviceId + "'";
        return !db.deleteData("serviciosreuniones", sqlSentence).isEmpty();
    }
    
    public boolean deletePersonalService(String serviceId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE servicioid = '" + serviceId + "'";
        return !db.deleteData("serviciospersonales",  sqlSentence).isEmpty();
    }
    
    public boolean payPersonalService(String serviceId, Double amount) {
        BillController bc = BillController.instance();
        DBConnection db = DBConnection.Instance();
        PersonalService service = db.getPersonalService(serviceId);
        if (service == null) return false;
        User purchaseOwner = db.getUser(service.getReferenceId());
        if (purchaseOwner == null) return false;
        return !bc.createBill(service.getDescription(), amount, service.getDate(), null, service.getServiceId(), purchaseOwner.getUserName(), null, false, true).isEmpty();
    }
}
