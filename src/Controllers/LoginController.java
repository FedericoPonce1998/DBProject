/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    
    public User registerUser(String userName, String password, String name, String dir, String mail) {
        DBConnection db = DBConnection.Instance();
        if (!userName.isEmpty() && userName.length() < 40 && password.length() > 4 && password.length() < 20 
                && name.length() > 3 && dir.length() > 5 && mail.contains("@")) {
            db.insertData("Usuarios(usuid, usunom, usudir, usumail, usupass) VALUES (" + userName + ", " +
                    name  + ", "+ dir + ", " + mail + ")");
            MainController mc = MainController.instance();
            User currentUser = new User(userName, name, password, dir, mail);
            mc.setCurrentUser(currentUser);
            return currentUser;
        }
        return null;
    }
}
