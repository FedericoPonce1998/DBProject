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
public interface IPurchase {
    
    public String getIdCompra();
    
    public String getDescription();
    
    public void setDescription(String description);
    
    public String getReferenceId();
    
    public void setReferenceId(String meetingId);
    
    public Double getAmount();
    
    public void setAmount(Double amount);
   
    public boolean isPersonalPurchase();
}
