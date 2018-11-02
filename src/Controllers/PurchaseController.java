/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.time.LocalDateTime;
import java.util.UUID;
import projectbd.DBConnection;
import Models.Invited;
import Models.Meeting;
import Models.MeetingPurchase;
import Models.PersonalPurchase;
import Models.PurchaseLine;
import Models.User;
import java.util.ArrayList;

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
        String newId = UUID.randomUUID().toString();
        return db.insertData("comprareunion(compraid, descripcion, reunionid, costo) " 
                + "VALUES(" + newId + "," + meetingId + ", " + description + ", " + amount + ";");
    }
    
    public long createPersonalPurchase(String description, String userId) {
        DBConnection db = DBConnection.Instance();
        String newId = UUID.randomUUID().toString();
        return db.insertData("comprapersonal(compraid, descripcion, usuid) " 
                + "VALUES(" + newId + "," + description + ", " + userId + ";");
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
   
    /**
     * Creates a bill for every guest in a meeting
     * 
     * @param purchaseId
     * @param isPaid
     * @return 
     */
    public boolean payPersonalPurchase(String purchaseId, Double amount) {
        BillController bc = BillController.instance();
        DBConnection db = DBConnection.Instance();
        PersonalPurchase purchase = db.getPersonalPurchase(purchaseId);
        if (purchase == null) return false;
        User purchaseOwner = db.getUser(purchase.getUserId());
        if (purchaseOwner == null) return false;
        return bc.createBill(purchase.getDescription(), amount, null, purchaseId, null, purchaseOwner.getUserName(), null, false, true) != -1;
    }
    
    public boolean addPersonalPurchaseLine(String puchaseId, String name, Double quantity) {
        DBConnection db = DBConnection.Instance();
        PersonalPurchase purchase = db.getPersonalPurchase(puchaseId);
        if (purchase == null) return false;
        String newId = UUID.randomUUID().toString();
        return db.insertData("compralinea(lineaid, compraid, nombre, cantidad) values(" + newId + ", " + puchaseId + ", " + name+ ", " 
        + quantity + ");") != -1;
    }
    //VER!!!    
    public boolean deletePersonalPurchaseLine(String puchaseId, String lineId) {
        DBConnection db = DBConnection.Instance();
        PurchaseLine pl = db.getPurchaseLine(lineId, puchaseId);
        return db.deleteData(lineId, lineId) != -1;
    }
    
    public boolean addMeetingPurchaseLine(String puchaseId, String name, Double quantity) {
        DBConnection db = DBConnection.Instance();
        MeetingPurchase purchase = db.getMeetingPurchase(puchaseId);
        if (purchase == null) return false;
        String newId = UUID.randomUUID().toString();
        return db.insertData("compralinea(lineaid, compraid, nombre, cantidad) values(" + newId + ", " + puchaseId + ", " + name+ ", " 
        + quantity + ");") != -1;
    }
    
    public ArrayList<PersonalPurchase> getAllPersonalPurchase(String usuId) {
        DBConnection db = DBConnection.Instance();
        return db.getAllPersonalPurchase(usuId);
    }
   
}
