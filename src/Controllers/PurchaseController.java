/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.time.LocalDateTime;
import java.util.UUID;
import projectbd.DBConnection;
import projectbd.Models.Invited;
import projectbd.Models.Meeting;
import projectbd.Models.MeetingPurchase;
import projectbd.Models.PersonalPurchase;
import projectbd.Models.User;

/**
 *
 * @author federicoponcedeleon
 */
public class PurchaseController {
    private static PurchaseController instance;
    
    private PurchaseController() {}
    
    public static PurchaseController instance() {
        if (instance == null) {     
            instance = new PurchaseController();
        }
        return instance;
    }
    
    public long createMeetingPurchase(String meetingId, String description, Double amount) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the meeting exists
        Meeting meeting = db.getMeeting(meetingId);
        if (meeting != null) {
            String newId = UUID.randomUUID().toString();
            return db.insertData("comprareunion(usuid, usunom, usudir, usumail, usupass) " 
                    + "VALUES(" + newId + "," + meetingId + ", " + description + ", " + amount + ";");
        }
        return -1;
    }
    
    public long createPersonalPurchase(String description, String userId) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the user exists
        User user = db.getUser(userId);
        if (user != null) {
            String newId = UUID.randomUUID().toString();
            return db.insertData("comprapersonal(compraid, descripcion, usuid) " 
                    + "VALUES(" + newId + "," + description + ", " + userId + ";");
        }
        return -1;
    }
    
    public MeetingPurchase getMeetingPurchase(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        return db.getMeetingPurchase(purchaseId);
    }
    
    public PersonalPurchase getPersonalPurchase(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        return db.getPersonalPurchase(purchaseId);
    }
    
    public boolean deleteMeetingPurchase(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE compraid = " + purchaseId;
        return db.deleteData("comprareunion",purchaseId) != -1;
    }
    
    public boolean deletePersonalPurchase(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE compraid = " + purchaseId;
        return db.deleteData("comprapersonal", sqlSentence) != -1;
    }
    
    public boolean payPersonalPurchase(String purchaseId, Double amount) {
        PersonalPurchase purchase = DBConnection.Instance().getPersonalPurchase(purchaseId);
        if (purchase == null) return false;
        DBConnection db = DBConnection.Instance();
        String newId = UUID.randomUUID().toString();
        db.insertData("Gasto(gastoid, motivo, montofinal, estapago, esingreso, fecha, compraid, servicioid, usuid, usuidreferencia) VALUES "
                + "(" + newId + ", " + purchase.getDescription() + ", " + amount + ", " + true + ", "+ false + ", "+ LocalDateTime.now().toString() + ", "+
                purchaseId + ", "+ null + ", "+ purchase.getUserId() + ", " + null + ");");
        return true;
    }
    
    /*
    public boolean payMeetingPurchase(String purchaseId, boolean isPaid) {
        MeetingPurchase purchase = DBConnection.Instance().getMeetingPurchase(purchaseId);
        BillController bc = BillController.instance();
        DBConnection db = DBConnection.Instance();
        Meeting meeting = db.getMeeting(purchase.getMeetingId());
        String meetingOrganizer = meeting.getUsuOrgId();
        String newId = UUID.randomUUID().toString();
        Invited inv = db.getInvited(meeting.getMeetingId(), meetingOrganizer);
        Double amountPerEach = purchase.getAmount() / inv.
        db.insertData("Gasto(gastoid, motivo, montofinal, estapago, esingreso, fecha, compraid, servicioid, usuid, usuidreferencia) VALUES "
                + "(" + newId + ", " + purchase.getDescription() + purchase.getAmount() + ", " + isPaid + ", "+ false + ", "+ meeting.getDate() + ", "+
                purchaseId + ", "+ purchase + ", "+ newId + ", "");");
        bc.createBill(purchaseId, Double.NaN, purchaseId, purchaseId, purchaseId, purchaseId, purchaseId, true, true)
                
    }*/
}
