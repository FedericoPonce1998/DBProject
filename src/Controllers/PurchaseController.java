/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.IPurchase;
import java.util.UUID;
import projectbd.DBConnection;
import Models.MeetingPurchase;
import Models.PersonalPurchase;
import Models.PurchaseLine;
import Models.User;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String newId;
        try {
            newId = MainController.getHash(meetingId+description+amount);
        } catch (NoSuchAlgorithmException ex) {
            newId = UUID.randomUUID().toString();
            Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db.insertData("comprasreuniones(compraid, descripcion, reunionid, costo) " 
                + "VALUES('" + newId + "', '" + meetingId + "', '" + description + "', " + amount + ");");
    }
    
    public String createPersonalPurchase(String description, String userId) {
        DBConnection db = DBConnection.Instance();
        String newId;
        try {
            newId = MainController.getHash(description+userId);
        } catch (NoSuchAlgorithmException ex) {
            newId = UUID.randomUUID().toString();
            Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db.insertData("compraspersonales(compraid, descripcion, usuid) " 
                + "VALUES('" + newId + "', '" + description + "', '" + userId + "');");
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
        String sqlSentence = "WHERE compraid = '" + purchaseId + "'";
        return (!db.deleteData("comprasreuniones",sqlSentence).isEmpty())&&(!db.deleteData("lineascompra", sqlSentence).isEmpty());
    }
    
    public boolean deletePersonalPurchase(String purchaseId) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "WHERE compraid = '" + purchaseId+"';";
        return (!db.deleteData("compraspersonales", sqlSentence).isEmpty()) && (!db.deleteData("lineascompra", sqlSentence).isEmpty());
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
        return !bc.createBill(purchase.getDescription(), amount, null, purchaseId, null, purchaseOwner.getUserName(), null, false, true).isEmpty();
    }
    
    public boolean addPersonalPurchaseLine(String puchaseId, String name, Double quantity) {
        DBConnection db = DBConnection.Instance();
        PersonalPurchase purchase = db.getPersonalPurchase(puchaseId);
        if (purchase == null) return false;
        return !db.insertData("lineascompra(compraid, nombreproducto, cantidad) values('" + puchaseId + "', '" + name+ "', " 
        + quantity + ");").isEmpty();
    }
    
    public boolean deletePurchaseLine(String puchaseId, String lineId) {
        DBConnection db = DBConnection.Instance();
        PurchaseLine pl = db.getPurchaseLine(lineId, puchaseId);
        String sqlSentence = "where lineId = '"+ lineId + "';";
        return !db.deleteData("lineascompra", sqlSentence).isEmpty();
    }

    
    public boolean addMeetingPurchaseLine(String puchaseId, String name, Double quantity) {
        DBConnection db = DBConnection.Instance();
        MeetingPurchase purchase = db.getMeetingPurchase(puchaseId);
        if (purchase == null) return false;
        return !db.insertData("lineascompra(compraid, nombreproducto, cantidad) values('" + puchaseId + "', '" + name+ "', " 
        + quantity + ");").isEmpty();
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
