/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
        return instance;
    }
    
}
