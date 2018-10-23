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
public class Meeting {
    private final UUID meetingId;
    private Date date;
    private String place,
            description;
    private String usuOrgId;
    private String[] usuInvitedId;
    
    public Meeting() {
        this.meetingId = UUID.randomUUID();
    }

    public UUID getMeetingId() {
        return meetingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
