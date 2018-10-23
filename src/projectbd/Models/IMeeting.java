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
public interface IMeeting {
    
    public UUID getServiceId();
    
    public String getName();

    public void setName(String name);

    public String getCompany();
    public void setCompany(String company);

    public String getDescription();

    public void setDescription(String description);
    public Date getDate();

    public void setDate(Date date);

    public Double getPrice();
    public void setPrice(Double price);
    
}
