/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicoponcedeleon
 */
public class Bill {
    private final String billId;
    private String name;
    private Double price;
    private Date deadline;
    private String purchaseId;
    private String serviceId;
    private String usuId;
    private String usuReferenceId;
    private boolean isPaid;
    private boolean isInput;
    
         

    public Bill(String billId, String name, Double price, String deadline, String purchaseId, String serviceId, String usuId, String usuReferenceId, boolean isInput, boolean isPaid) {
        this.billId = billId;
        this.name = name;
        this.price = price;
        try {
            this.deadline = parseToDate(deadline);
        } catch (ParseException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.purchaseId = purchaseId;
        this.serviceId = serviceId;
        this.usuId = usuId;
        this.usuReferenceId = usuReferenceId;
        this.isInput = isInput;
        this.isPaid = isPaid;
    }
    
    private Date parseToDate(String toParse) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(toParse);
    }
    
    public String getBillId() {
        return billId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuReferenceId() {
        return usuReferenceId;
    }

    public void setUsuReferenceId(String usuReferenceId) {
        this.usuReferenceId = usuReferenceId;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean isIsInput() {
        return isInput;
    }

    public void setIsInput(boolean isInput) {
        this.isInput = isInput;
    }
    
    
}
