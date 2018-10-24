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
public class MeetingService implements IMeeting{
    
    private final String serviceId;
    private String name;
    private String company;
    private String description;
    private Double price;
    private String meetingId;
    
    public MeetingService() {
        this.serviceId = "";
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

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getMeetingId() {
        return this.meetingId;
    }
    
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

}
