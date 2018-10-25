/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

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
    private Date date;
    private String place,
            description;
    private String usuOrgId;
    private String[] usuInvitedId;
    public Meeting(String meetingId, String place, String date, String description, String organizer) {
        this.meetingId = meetingId;
        this. place = place;
        try {
            this.date = this.parseToDate(date);
        }
        catch (Exception e) {
            
        }
        this.description = description;
        this.usuOrgId = organizer;
    }

    private Date parseToDate(String toParse) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(toParse);
    }
    public String getMeetingId() {
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
    
    public String getUsuOrgId() {
        return this.usuOrgId;
    }
    
}
