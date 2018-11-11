/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author federicoponcedeleon
 */
public class Meeting {
    private final String meetingId;
    private Timestamp date;
    private String place,
            description;
    private String usuOrgId;
    private String purchaseId;
    private String serviceId;
    private String[] usuInvitedId;
    private boolean invitedDontPay;
    
    public Meeting(String meetingId, String place, Timestamp date, String description, boolean invitedDontPay, String organizer) {
        this.meetingId = meetingId;
        this. place = place;
        this.invitedDontPay = invitedDontPay;
        this.date = date;
        this.description = description;
        this.usuOrgId = organizer;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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
    
    public String getUsuOrgId() {
        return this.usuOrgId;
    }

    public String[] getUsuInvitedId() {
        return usuInvitedId;
    }

    public void setUsuInvitedId(String[] usuInvitedId) {
        this.usuInvitedId = usuInvitedId;
    }
    
    public boolean invitedDontPay() {
        return invitedDontPay;
    }

    public void setInvitedDontPay(boolean invitedDontPay) {
        this.invitedDontPay = invitedDontPay;
    }
    
    
}
