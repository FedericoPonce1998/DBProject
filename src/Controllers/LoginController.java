/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.SQLException;
import projectbd.DBConnection;
import Models.User;

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
        if (!userName.isEmpty() && userName.length() < 40 && password.length() > 4 && password.length() < 20 
                && name.length() > 3 && dir.length() > 5 && mail.contains("@")) {
            UserController uc = UserController.getInstanceUser();
            uc.createUser(userName, password, name, dir, mail);
            MainController mc = MainController.instance();
            User currentUser = new User(userName, name, password, dir, mail);
            mc.setCurrentUser(currentUser);
            return currentUser;
        }
        return null;
    }
    
    public String forgottenContrasena(String userName) {
        DBConnection db = DBConnection.Instance();
        User user = db.getUser(userName);
        if (user == null) return "";
        return user.getPassword();
    }
    
    public boolean updatePassword(String userName, String mail, String newPassword) {
        DBConnection db= DBConnection.Instance();
        User user = db.getUser(userName);
        long result = -1;
        String data1 = "usuarios set usupass = " + newPassword + " where usuid = " + userName;
        if (user.getEmail().equals(mail)) {
            result = db.updateData(data1);
        }
        return result != -1;
    }
}

