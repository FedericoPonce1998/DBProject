/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.UUID;

/**
 *
 * @author federicoponcedeleon
 */
public class PersonalPurchase implements IPurchase {
    private final String purchaseId;
    private String description;
    private String userId;
    
    public PersonalPurchase(String purchaseId, String description, String userId) {
        this.purchaseId = purchaseId;
        this.description = description;
        this.userId = userId;
    }
    
    @Override
    public String getIdCompra() {
        return purchaseId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
