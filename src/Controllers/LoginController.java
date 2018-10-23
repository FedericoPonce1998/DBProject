/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    
    public static LoginController getInstanceLogin() {
        if (instance == null) {     
            instance = new LoginController();
        }
        return instance;
    }
    
    public User logInUser(String usuid, String password) throws SQLException {
        DBConnection db = DBConnection.Instance();
        ResultSet rs = db.getUserTable(usuid);
        Object userRow = rs.getArray(1).getArray();
        
        User currentLoginUser = null;
        if ( == usuid && usersTable.getArray(4) == password) {
            currentLoginUser = usersTable;
        }
        return currentLoginUser;
    }
    
}
