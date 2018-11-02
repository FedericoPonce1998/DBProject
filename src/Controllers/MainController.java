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
import windows.MainContainer;
import windows.MessageContainer;


/**
 *
 * @author federicoponcedeleon
 */
public class MainController {
    private static MainController instance;
    private User currentUser;
    private final MessageContainer messageContainer;
    private final MainContainer mainContainer;
    
    private MainController() {
        this.messageContainer = new MessageContainer();
        messageContainer.setVisible(false);
        this.mainContainer = new MainContainer();
        mainContainer.setVisible(false);
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
    
    public void showContent(ArrayList<JFrame> list) {
        int height = 0;
        JPanel panel = this.mainContainer.getPanel();
        for (JFrame frame : list) {
            Dimension dimension = frame.getSize();
            height += dimension.getHeight() + 4;
            frame.setLocation(600, height + 100);
            frame.setVisible(true);
            panel.add(frame);
        }
        
        mainContainer.setVisible(true);
        panel.setSize(360, height);
    }
    
    public void showContent(JFrame frame) {
        frame.setVisible(true);
        JPanel panel = this.mainContainer.getPanel();
        panel.setVisible(false);
        mainContainer.setVisible(true);
    }
}
