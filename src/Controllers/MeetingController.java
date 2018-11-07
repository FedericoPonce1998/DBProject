/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    public long createMeeting(Timestamp date, String place, String description, String organizerId, boolean nopagan) {
        DBConnection db = DBConnection.Instance();
        String newId = "5";
        return db.insertData("reuniones(reunionid, fecha, lugar, descripcion, organizadorid, nopagan) "
        + "values('" + newId + "', TO_TIMESTAMP('" + date + "', 'YYYY-MM-DD HH24:MI:SS.FF'), '" + place + "', '" + description + "', '" + organizerId + "', " + nopagan + ")");
    }
    
    /**
     * El metodo se refiere a pagar los servicios y las compras de una reunionr
     * @param meetingid
     * @param deadline
     * @return 
     */
    public boolean payMeeting(String meetingid) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingid);
        if (meeting == null) return false;
        User organizer = db.getUser(meeting.getUsuOrgId());
        if (organizer == null) return false;
        MeetingPurchase meetingPurchase = db.getMeetingPurchase(meeting.getPurchaseId());
        MeetingService service = db.getMeetingService(meeting.getServiceId());
        ArrayList<Invited> invitedList = db.getInvited(meetingid);
        if (invitedList == null || invitedList.isEmpty()) {
            return false;
        }
        Double meetingAmount = meetingPurchase.getAmount() / (invitedList.size() + 1);
        BillController bc = BillController.instance();
        for (Invited inv : invitedList) {
            bc.createBill(meetingid, meetingAmount, null, meetingPurchase.getIdCompra(), service.getServiceId(), organizer.getUserName(), inv.getUserId(), true, true);//account for the organizer
            bc.createBill(meetingid, meetingAmount, null, meetingPurchase.getIdCompra(), service.getServiceId(), inv.getUserId(), organizer.getUserName(), false, false);//account for the invited
            
        }
        return true;
    }
    
    public boolean addInvitedToMeeting(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null) return false;
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        return db.insertData("invitados(reunionid, usuid, asistio) values(" + meetingId + ", " + invitedId + ", true);") != -1;
    }
    
    public boolean rejectInivitation(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null || meeting.getDate().after(new Date())) return false; //checks if the meeting is up to date
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        return db.updateData("invitados set asistio = false where reunionid = " + meetingId + " and usuid + " + invitedId + ");") != -1;
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
        return db.deleteData("reunion","where reunionid = '" + meetingId + "');") != -1;
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
    
    public ArrayList<MeetingPurchase> getMeetingPurchases(String meetingId){
        DBConnection db = DBConnection.Instance();
        try {
            return db.getMeetingPurchases(meetingId);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<MeetingService> getMeetingServices(String meetingId){
        DBConnection db = DBConnection.Instance();
        try {
            return db.getMeetingServices(meetingId);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
