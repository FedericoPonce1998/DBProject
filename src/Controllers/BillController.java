/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.UUID;
import projectbd.DBConnection;
import projectbd.Models.Bill;
import projectbd.Models.User;

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
    
    public long createBill(String name, Double price, String deadline, String purchaseId, String serviceId, String usuId, String usuReferenceId, boolean isInput, boolean isPaid) {
        DBConnection db = DBConnection.Instance();
        //firts I have to check if the meeting exists
        
        User user = db.getUser(usuId);
        if (user != null) {
            String newId = UUID.randomUUID().toString();
            String data = "Gasto(gastoid, motivo, montofinal, estapago, esingreso, fecha, compraid, servicioidvicio, "
                            + "usuid, usuidReferencia) VALUES (" + newId + ", " + name + ", " + price + ", " + isPaid + ", " + isInput + ", " + 
                            deadline + ", " + purchaseId + ", " + serviceId + ", " + usuId;
            if (!usuReferenceId.isEmpty()) {
                User usuref = db.getUser(usuReferenceId);
                
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
}
