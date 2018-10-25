/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.UUID;
import projectbd.DBConnection;
import projectbd.Models.Meeting;
import projectbd.Models.MeetingService;
import projectbd.Models.PersonalService;
import projectbd.Models.User;

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
        return db.deleteData("servicioreunion", serviceId) != -1;
    }
    
    public boolean deletePersonalService(String serviceId) {
        DBConnection db = DBConnection.Instance();
        return db.deleteData("serviciopersonal", serviceId) != -1;
    }
}
