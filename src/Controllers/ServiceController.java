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
    
    public long createMeetingService(String name, String company, String description, Double price, String meetingId) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the meeting exists
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting != null) {
            String newId = UUID.randomUUID().toString();
            return db.insertData("servicioreunion(servicioid, nombre, empresa, descripcion, precio, reunionid) " 
                    + "VALUES(" + newId + "," + name + ", " + company + ", " + description + ", " + price + ", " + meetingId + ";");
        }
        return -1;
    }
    
    public long createPersonalService(String name, String company, String description, String date, String userId) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the user exists
        User user = db.getUser(userId);
        if (user != null) {
            String newId = UUID.randomUUID().toString();
            return db.insertData("serviciocompra(servicioid, empresa, nombre, fechaprogramada, descripcion, usuid) " 
                    + "VALUES(" + newId + "," + company + ", " + name + ", " + date + ", " + description + ", " + userId + ";");
        }
        return -1;
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
        String sqlSentence = "WHERE idservicio = " + serviceId;
        return db.deleteData("servicioreunion", sqlSentence) != -1;
    }
    
    public boolean deletePersonalService(String serviceId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE idservicio = " + serviceId;
        return db.deleteData("serviciopersonal",  sqlSentence) != -1;
    }
    
    public boolean payPersonalService(String serviceId, Double amount) {
        BillController bc = BillController.instance();
        DBConnection db = DBConnection.Instance();
        PersonalService service = db.getPersonalService(serviceId);
        if (service == null) return false;
        User purchaseOwner = db.getUser(service.getUserId());
        if (purchaseOwner == null) return false;
        return bc.createBill(service.getDescription(), amount, service.getDate().toString(), null, service.getServiceId(), purchaseOwner.getUserName(), null, false, true) != -1;
    }
}
