/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federicoponcedeleon
 */
public class PersonalService implements IService {
    
    private final String serviceId;
    private String name;
    private String company;
    private String description;
    private Timestamp date;
    private String userId;
    
    public PersonalService(String serviceId, String name, String company, String description, Timestamp date, String userId) {
        this.serviceId = serviceId;
        this.name = name;
        this.company = company;
        this.description = description;
        this.date = date;
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

    @Override
    public Timestamp getDate() {
        return this.date;
    }

    @Override
    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    @Override
    public String getReferenceId() {
        return this.userId;
    }
    
    @Override
    public void setReferenceId(String userId) {
        this.userId = userId;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public void setPrice(Double price) {
        return;
    }
    
    @Override
    public boolean isPersonalService() {
        return true;
    }

}
