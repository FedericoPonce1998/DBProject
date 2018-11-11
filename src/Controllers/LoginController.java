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
        /*DBConnection db = DBConnection.Instance();
        User currentLoggedinUser = db.getUser(usuid);
        if (currentLoggedinUser.getUserName().equals(usuid) && currentLoggedinUser.getPassword().equals(password)) {
            MainController mc = MainController.instance();
            mc.setCurrentUser(currentLoggedinUser);
            return currentLoggedinUser;
        }
        return null;*/
        return new User(usuid, "fede", password, "sabat pebet", "fm@gmail");
    }
    
    public void logOutUser() {
        MainController mc = MainController.instance();
        mc.setCurrentUser(null);
    }
    
    public User registerUser(String userName, String password, String name, String dir, String mail) {
        UserController uc = UserController.getInstanceUser();
        uc.createUser(userName, password, name, dir, mail);
        MainController mc = MainController.instance();
        User currentUser = new User(userName, name, password, dir, mail);
        mc.setCurrentUser(currentUser);
        return currentUser;
    }
    
    public String forgottenPassword(String userName, String mail) {
        DBConnection db = DBConnection.Instance();
        User user = db.getUser(userName);
        if (user == null) return "";
        if (!user.getEmail().equals(mail)) return "";
        return user.getPassword();
    }
    
    public boolean updatePassword(String userName, String oldPassword, String newPassword) {
        DBConnection db= DBConnection.Instance();
        User user = db.getUser(userName);
        String result = "";
        String data1 = "usuarios set usupass = " + newPassword + " where usuid = " + userName;
        if (user.getPassword().equals(oldPassword)) {
            result = db.updateData(data1);
        }
        return result != "";
    }
}

