/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.IPurchase;
import java.time.LocalDateTime;
import java.util.UUID;
import projectbd.DBConnection;
import Models.Invited;
import Models.Meeting;
import Models.MeetingPurchase;
import Models.PersonalPurchase;
import Models.PurchaseLine;
import Models.User;
import java.sql.SQLException;
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
    
    public String createMeetingPurchase(String meetingId, String description, Double amount) {
        DBConnection db = DBConnection.Instance();
        String newId = UUID.randomUUID().toString();
        return db.insertData("comprareunion(compraid, descripcion, reunionid, costo) " 
                + "VALUES(" + newId + "," + meetingId + ", " + description + ", " + amount + ";");
    }
    
    public String createPersonalPurchase(String description, String userId) {
        DBConnection db = DBConnection.Instance();
        String newId = UUID.randomUUID().toString();
        return db.insertData("comprapersonal(compraid, descripcion, usuid) " 
                + "VALUES(" + newId + "," + description + ", " + userId + ";");
    }
    
    public IPurchase getMeetingPurchase(String purchaseId) {
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
        return (db.deleteData("comprareunion",sqlSentence) != "")&&(db.deleteData("lineacompra", sqlSentence)!= "");
    }
    
    public boolean deletePersonalPurchase(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE compraid = '" + purchaseId+"';";
        return (db.deleteData("comprapersonal", sqlSentence) != "") && (db.deleteData("lineacompra", sqlSentence)!= "");
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
        User purchaseOwner = db.getUser(purchase.getReferenceId());
        if (purchaseOwner == null) return false;
        return bc.createBill(purchase.getDescription(), amount, null, purchaseId, null, purchaseOwner.getUserName(), null, false, true) != "";
    }
    
    public boolean addPersonalPurchaseLine(String newId, String puchaseId, String name, Double quantity) {
        DBConnection db = DBConnection.Instance();
        PersonalPurchase purchase = db.getPersonalPurchase(puchaseId);
        if (purchase == null) return false;
        return db.insertData("compralinea(lineaid, compraid, nombre, cantidad) values(" + newId + ", " + puchaseId + ", " + name+ ", " 
        + quantity + ");") != "";
    }
    
    public boolean deletePurchaseLine(String puchaseId, String lineId) {
        DBConnection db = DBConnection.Instance();
        PurchaseLine pl = db.getPurchaseLine(lineId, puchaseId);
        String sqlSentence = "where lineId = '"+ lineId + "';";
        return db.deleteData("lineacompra", sqlSentence) != "";
    }

    
    public boolean addMeetingPurchaseLine(String newId, String puchaseId, String name, Double quantity) {
        DBConnection db = DBConnection.Instance();
        MeetingPurchase purchase = db.getMeetingPurchase(puchaseId);
        if (purchase == null) return false;
        return db.insertData("compralinea(lineaid, compraid, nombre, cantidad) values(" + newId + ", " + puchaseId + ", " + name+ ", " 
        + quantity + ");") != "";
    }
    
    public ArrayList<IPurchase> getAllPersonalPurchase(String usuId) {
        DBConnection db = DBConnection.Instance();
        return db.getAllPersonalPurchase(usuId);
    }
    
     public ArrayList<IPurchase> getAllMeetingPurchase(String meetingId) throws SQLException {
        DBConnection db = DBConnection.Instance();
        return db.getMeetingPurchases(meetingId);
    }
    
    
    
    public ArrayList<PurchaseLine> getAllLines(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        return db.getPurchaseLines(purchaseId);
    }
    
   
}
