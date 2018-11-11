/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.IPurchase;
import Models.IService;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import projectbd.DBConnection;
import Models.Invited;
import Models.Meeting;
import Models.MeetingPurchase;
import Models.MeetingService;
import Models.User;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicoponcedeleon
 */
public class MeetingController {
    private static MeetingController instance;
    
    private MeetingController() {}
    
    public static MeetingController instance() {
        if (instance == null) {     
            instance = new MeetingController();
        }
        return instance;
    }
    
    
    //to create, date = new TimeStamp(currentmillis) o Timestamp value = Timestamp.valueOf("2014-07-02 06:14:00");
    public Meeting createMeeting(Timestamp date, String place, String description, String organizerId, boolean nopagan) {
        DBConnection db = DBConnection.Instance();
        String newId = UUID.randomUUID().toString();
        String result = db.insertData("reuniones(reunionid, fecha, lugar, descripcion, organizadorid, nopagan) "
        + "values('" + newId + "', TO_TIMESTAMP('" + date + "', 'YYYY-MM-DD HH24:MI:SS.FF'), '" + place + "', '" + description + "', '" + organizerId + "', " + nopagan + ")");
        if (result != "") {
            return new Meeting(newId, place, date, description, nopagan, organizerId);
        }
        return null;
    }
    
    /**
     * El metodo se refiere a pagar los servicios y las compras de una reunionr
     * @param meetingid
     * @param deadline
     * @return 
     */
    public boolean payMeeting(String meetingid) throws SQLException {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingid);
        if (meeting == null) return false;
        User organizer = db.getUser(meeting.getUsuOrgId());
        if (organizer == null) return false;
        ArrayList<IPurchase> meetingPurchases = db.getMeetingPurchases(meetingid);
        ArrayList<IService> meetingServices = db.getMeetingServices(meetingid);
        ArrayList<Invited> assistedList = db.getInvitesMeeting(meetingid);
        if (assistedList == null || assistedList.isEmpty()) {
            return false;
        }
        
        BillController bc = BillController.instance();
        for (Invited inv : assistedList) {
            for (IPurchase purchase : meetingPurchases) {
                Double toPayPerEach = purchase.getAmount() / (assistedList.size() + 1);
                String idUno = bc.createBill(meetingid, toPayPerEach, null, purchase.getIdCompra(), null, organizer.getUserName(), null, true, true);//account for the organizer
                String idDos = bc.createBill(meetingid, toPayPerEach, null, purchase.getIdCompra(), null, inv.getUserId(), null, false, false);//account for the invited
                if (!idUno.isEmpty() && !idDos.isEmpty()) {
                    db.updateData("gasto set gastoreferencia = " + idDos + " where gastoid = " + idUno + ");");
                    db.updateData("gasto set gastoreferencia = " + idUno + " where gastoid = " + idDos + ");");
                }
            }
            for (IService service : meetingServices) {
                Double toPayPerEach = service.getPrice()/ (assistedList.size() + 1);
                bc.createBill(meetingid, toPayPerEach, null, null, service.getServiceId(), organizer.getUserName(), inv.getUserId(), true, true);//account for the organizer
                bc.createBill(meetingid, toPayPerEach, null, null, service.getServiceId(), inv.getUserId(), organizer.getUserName(), false, false);//account for the invited
            }
        }
        return true;
    }
    
    public boolean addInvitedToMeeting(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null) return false;
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        return db.insertData("invitados(reunionid, usuid, asistio) values(" + meetingId + ", " + invitedId + ", true);") != "";
    }
    
    public boolean rejectInivitation(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null || meeting.getDate().after(new Date())) return false; //checks if the meeting is up to date
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        return db.updateData("invitados set asistio = false where reunionid = " + meetingId + " and usuid + " + invitedId + ");") != "";
    }
    
    public ArrayList<Meeting> getAllMeetings(String usuid) {
        DBConnection db = DBConnection.Instance();
        return db.getAllMeetings(usuid);
    }
    
    public Meeting getMeeting(String meetingid) {
        DBConnection db = DBConnection.Instance();
        return db.getMeeting(meetingid);
    }
    
    public boolean deleteMeeting(String meetingId){
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null) return false;
        return db.deleteData("reunion","where reunionid = '" + meetingId + "');") != "";
    }
    
    public ArrayList<Invited> getInvitedMeeting(String meetingId){
        DBConnection db = DBConnection.Instance();
        try {
            return db.getInvitesMeeting(meetingId);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<IPurchase> getMeetingPurchases(String meetingId){
        DBConnection db = DBConnection.Instance();
        try {
            return db.getMeetingPurchases(meetingId);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<IService> getMeetingServices(String meetingId){
        DBConnection db = DBConnection.Instance();
        try {
            return db.getMeetingServices(meetingId);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean deleteInvitedToMeeting(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null || meeting.getDate().after(new Date())) return false; //checks if the meeting is up to date
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        return db.deleteData("invitados","where reunionid = '" + meetingId + "' and usuid = '" + invitedId + "');") != "";
    }
    
    public ArrayList<Meeting> getAssisted(String meetingId) {
        DBConnection db = DBConnection.Instance();
        return db.getAssisted(meetingId, true);
    }
    
    public ArrayList<Meeting> getDidntAssisted(String usuId) {
        DBConnection db = DBConnection.Instance();
        return db.getAssisted(usuId, false);
    }
    
    public ArrayList<Meeting> getAllOrganizedBy(String usuId) {
        DBConnection db = DBConnection.Instance();
        return db.getAllOrganizedBy(usuId);
    }
}
