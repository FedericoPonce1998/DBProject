/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.SQLException;
import projectbd.DBConnection;
import Models.Friends;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayra
 */
public class FriendController {
    private static FriendController instance;
    
    private FriendController() {}
    
    public static FriendController getInstanceFriend() {
        if (instance == null) {     
            instance = new FriendController();
        }
        return instance;
    }
    
    
    public ArrayList<Friends> getFriends(String userId){
         DBConnection db = DBConnection.Instance();
        try {
            return db.getFriends(userId);
        } catch (SQLException ex) {
            Logger.getLogger(FriendController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
}
