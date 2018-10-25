/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import projectbd.Models.User;

/**
 *
 * @author federicoponcedeleon
 */
public class MainController {
    private static MainController instance;
    private User currentUser;
    
    private MainController() {}
    
    public static MainController instance() {
        if (instance == null) {     
            instance = new MainController();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
