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
    
    private final UUID serviceId;
    private String name;
    private String company;
    private String description;
    private Date date;
    private Double price;
    private UUID meetingId;
    
    public MeetingService() {
        this.serviceId = UUID.randomUUID();
    }

    @Override
    public UUID getServiceId() {
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
    public Date getDate() {
        return this.date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public UUID getMeetingId() {
        return this.meetingId;
    }
    
    public void setMeetingId(UUID meetingId) {
        this.meetingId = meetingId;
    }
}
