/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

import java.util.UUID;

/**
 *
 * @author federicoponcedeleon
 */
public interface IPurchase {
    
    public UUID getIdCompra();

    public String getDescription();

    public void setDescription(String description);
}
