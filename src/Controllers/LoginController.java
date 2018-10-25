/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import projectbd.DBConnection;
import projectbd.Models.User;

/**
 *
 * @author federicoponcedeleon
 */
public class LoginController {
    
    private static LoginController instance;
    
    private LoginController() {}
    
    public static LoginController instance() {
        if (instance == null) {     
            instance = new LoginController();
        }
        return instance;
    }
    
    public User logInUser(String usuid, String password) throws SQLException {
        
        DBConnection db = DBConnection.Instance();
        User currentLoggedinUser = db.getUser(usuid);
        if (currentLoggedinUser.getUserName().equals(usuid) && currentLoggedinUser.getPassword().equals(password)) {
            MainController mc = MainController.instance();
            mc.setCurrentUser(currentLoggedinUser);
            return currentLoggedinUser;
        }
        return null;
    }
    
    public void logOutUser() {
        MainController mc = MainController.instance();
        mc.setCurrentUser(null);
    }
    
    
    
    
}
