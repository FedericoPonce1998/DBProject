/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author federicoponcedeleon
 */
public class Bill {
    private final String idGasto;
    private String name;
    private Double price;
    private Date deadline;
    private String purchaseId;
    private String serviceId;
    private String usuId;
    private String usuReferenceId;
    
    public Bill () {
        this.idGasto = "";
    }

    public String getIdGasto() {
        return idGasto;
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
    
    
}
