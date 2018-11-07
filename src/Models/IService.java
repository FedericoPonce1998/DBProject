/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author federicoponcedeleon
 */
public interface IService {
    public String getServiceId();
    
    public String getName();
    
    public void setName(String name);
    
    public String getCompany();
    
    public void setCompany(String company);
    
    public String getDescription();
    
    public void setDescription(String description);
    
    public Double getPrice();
    
    public void setPrice(Double price);
    
    public String getReferenceId();
    
    public void setReferenceId(String meetingId);
    
    public Date getDate();
    
    public void setDate(Date date);
}
