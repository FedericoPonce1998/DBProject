/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;


/**
 *
 * @author federicoponcedeleon
 */
public interface IMeeting {
    
    public String getServiceId();
    
    public String getName();

    public void setName(String name);

    public String getCompany();
    public void setCompany(String company);

    public String getDescription();

    public void setDescription(String description);
    
    
}
