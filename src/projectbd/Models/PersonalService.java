/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicoponcedeleon
 */
public class PersonalService implements IMeeting {
    
    private final String serviceId;
    private String name;
    private String company;
    private String description;
    private Date date;
    private String userId;
    
    public PersonalService(String serviceId, String name, String company, String description, String date, String userId) {
        this.serviceId = serviceId;
        this.name = name;
        this.company = company;
        this.description = description;
        try {
            this.date = parseToDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(PersonalService.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.userId = userId;
        
    }

    private Date parseToDate(String toParse) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(toParse);
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

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   
    
    public String getUserId() {
        return this.userId;
    }
    
    public void serUserId(String userId) {
        this.userId = userId;
    }
}
