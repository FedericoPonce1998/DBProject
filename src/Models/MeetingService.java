/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author federicoponcedeleon
 */
public class MeetingService implements IService{
    
    private final String serviceId;
    private String name;
    private String company;
    private String description;
    private Double price;
    private String meetingId;
    
    public MeetingService(String serviceId, String name, String company, String description, Double price, String meeting) {
        this.serviceId = serviceId;
        this.company = company;
        this.description = description;
        this.price = price;
        this.meetingId = meeting;
        this.name = name;
    }

    @Override
    public String getServiceId() {
        return this.serviceId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCompany() {
        return this.company;
    }

    @Override
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
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
    public Date getDate() {
        return null;
    }
    
    public void setDate(Date date) {
        return;
    }

}
