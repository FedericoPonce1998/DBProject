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
    private final UUID idGasto;
    private String name;
    private Double price;
    private Date deadline;
    private UUID purchaseId;
    private UUID serviceId;
    private String usuId;
    private String usuReferenceId;
    
    public Bill () {
        this.idGasto = UUID.randomUUID();
    }

    public UUID getIdGasto() {
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

    public UUID getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(UUID purchaseId) {
        this.purchaseId = purchaseId;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
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
