/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bill;
import java.util.UUID;
import projectbd.DBConnection;
import Models.User;
import java.util.ArrayList;
import windows.HomeInterface;

/**
 *
 * @author federicoponcedeleon
 */
public class BillController {
    private static BillController instance;
    
    private BillController() {}
    
    public static BillController instance() {
        if (instance == null) {     
            instance = new BillController();
        }
        return instance;
    }
    
    /**
     * Inserts a bill into data base
     * @param name
     * @param price
     * @param deadline
     * @param purchaseId
     * @param serviceId
     * @param usuId
     * @param referenceId
     * @param isInput
     * @param isPaid
     * @return 
     */
    public long createBill(String name, Double price, String deadline, String purchaseId, String serviceId, String usuId, String referenceId, boolean isInput, boolean isPaid) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the meeting exists
        
        User user = db.getUser(usuId);
        if (user != null) {
            String newId = UUID.randomUUID().toString();
            String data = "Gasto(gastoid, motivo, montofinal, estapago, esingreso, fecha, compraid, servicioidvicio, "
                            + "usuid, usuidReferencia) VALUES (" + newId + ", " + name + ", " + price + ", " + isPaid + ", " + isInput + ", " + 
                            deadline + ", " + purchaseId + ", " + serviceId + ", " + usuId;
            if (!referenceId.isEmpty()) {
                User usuref = db.getUser(referenceId);
                
                if (usuref != null) {
                    //crear con usuref
                    return db.insertData(data + ", " + usuref + ");");
                }
                else {
                    return -1;
                }
            }
            else {
                //crear usu sin usuref
                return db.insertData(data + ");");
            }
        }
        return -1;
    }
    
    public Bill getBill(String billId) {
        DBConnection db = DBConnection.Instance();
        return db.getBill(billId);
    }
    
    public boolean payOrganizer(String billId){
        DBConnection db = DBConnection.Instance();
        Bill bill = db.getBill(billId);
        if (bill != null){
            String billRefId = bill.getBillReferenceId();
            String data1 = "gasto set estapago = true where gastoId = " + billId;
            String data2 = "gasto set estapago = true where gastoId = " + billRefId;
            db.updateData(data1);
            db.updateData(data2);
            return true;
        }
        return false;
    }
    
    /**
     * 0 = todos
     * 1 = a pagar no pago
     * 2 = a pagar pago
     * 3 = ingreso no pago
     * 4 = ingreso pago
     * @param usuid
     * @param opcion
     * @return 
     */
    public ArrayList<Bill> getUsersBills(String usuid, int opcion){
        DBConnection db = DBConnection.Instance();
        return db.getUsersBills(usuid, opcion);
    }
    
    public ArrayList<Bill> getByExpDate(String usuid){
        DBConnection db = DBConnection.Instance();
        return db.getByExpDate(usuid);
    }
}
