/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

import java.util.UUID;

/**
 *
 * @author federicoponcedeleon
 */
public class PersonalPurchase implements IPurchase {
    private final UUID purchaseId;
    private String description;
    private String userId;
    
    public PersonalPurchase() {
        this.purchaseId = UUID.randomUUID();
    }
    
    @Override
    public UUID getIdCompra() {
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