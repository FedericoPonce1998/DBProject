/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import windows.HomeInterface;
import windows.MenuInterface;
import windows.MessageContainer;


/**
 *
 * @author federicoponcedeleon
 */
public class MainController {
    private static MainController instance;
    private User currentUser;
    private final MessageContainer messageContainer;
    private final MenuInterface menu;
    private final HomeInterface home;
    
    private MainController() {
        this.messageContainer = new MessageContainer();
        messageContainer.setVisible(false);
        this.menu = new MenuInterface();
        this.menu.setVisible(false);
        this.home = new HomeInterface();
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
    
    public MenuInterface getMenu() {
        return this.menu;
    }
    
    public HomeInterface getHome() {
        return this.home;
    }
    
    public static String getHash(String text) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(text.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
          hashtext = "0"+hashtext;
        }
        return hashtext;
    }
}
