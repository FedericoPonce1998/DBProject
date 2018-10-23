/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import projectbd.DBConnection;
import projectbd.Models.User;

/**
 *
 * @author federicoponcedeleon
 */
public class LoginController {
    
    private static LoginController instance;
    
    private LoginController() {}
    
    public static LoginController getInstanceLogin() {
        if (instance == null) {     
            instance = new LoginController();
        }
        return Instance;
    }
    
    public User logInUser(String usuid, String password) {
        DBConnection db = DBConnection.Instance();
        db.getUserTable(usuid);
        if ()
        return null;
    }
    
            
}
