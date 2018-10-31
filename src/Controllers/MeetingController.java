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
    
    public boolean createMeetingBD(Meeting toInsert) {
        String newId = UUID.randomUUID().toString();
        String SQL = "reunion(reunionid, fecha, lugar, descripcion, organizadorid) VALUES (" +
                    newId + ", " + toInsert.getDate().toString() + ", " + toInsert.getPlace() + ", " + toInsert.getDescription() + 
                ", "+ toInsert.getUsuOrgId() + ");";
        DBConnection db = DBConnection.Instance();
        return db.insertData(SQL) != -1;
    }
    
    public boolean payMeeting(String meetingid, String deadline) {
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
            bc.createBill(meetingid, meetingAmount, deadline, meetingPurchase.getIdCompra(), service.getServiceId(), organizer.getUserName(), inv.getUserId(), true, true);//account for the organizer
            bc.createBill(meetingid, meetingAmount, deadline, meetingPurchase.getIdCompra(), service.getServiceId(), inv.getUserId(), organizer.getUserName(), false, false);//account for the invited
            
        }
        return true;
    }
    
    public boolean addInvitedToMeeting(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null) return false;
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        return db.insertData("invitados(reunionid, usuid) values(" + meetingId + ", " + invitedId + ");") != -1;
    }
    
    public boolean rejectInivitation(String invitedId, String meetingId) {
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting == null) return false;
        User invited = db.getUser(invitedId);
        if (invited == null) return false;
        String data = "where usuid = " + invitedId + "and reunionid = " + meetingId + ");";
        return db.deleteData("invitados",data) != -1;
    }
}
