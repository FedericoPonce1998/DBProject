/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.LayoutQueue;
import windows.MessageContainer;


/**
 *
 * @author federicoponcedeleon
 */
public class MainController {
    private static MainController instance;
    private User currentUser;
    private final MessageContainer messageContainer;
    
    private MainController() {
        this.messageContainer = new MessageContainer();
        messageContainer.setVisible(false);
    }
    
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

    public void showMessage(String message) {
        this.messageContainer.setMessage(message);
        this.messageContainer.setVisible(true);
    }
    
    public void hideMessage() {
        this.messageContainer.setMessage("");
        this.messageContainer.setVisible(false);
    }
}
