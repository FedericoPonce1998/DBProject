/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author federicoponcedeleon
 */
public class MeetingPurchase implements IPurchase{
    private final String purchaseId;
    private String description;
    private String meetingId;
    private Double amount;
    
    public MeetingPurchase(String purchaseId, String meetingId, String description, Double amount) {
        this.purchaseId = purchaseId;
        this.meetingId = meetingId;
        this.description = description;
        this.amount = amount;
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
    
    @Override
    public String getReferenceId() {
        return this.meetingId;
    }
    
    @Override
    public void setReferenceId(String meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    @Override
    public boolean isPersonalPurchase() {
        return false;
    }
    
}
