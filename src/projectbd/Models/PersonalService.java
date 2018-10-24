/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

import java.util.Date;

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
    
    public PersonalService() {
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
