/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Friends;
import Models.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectbd.DBConnection;

/**
 *
 * @author Mayra
 */
public class UserController {
    
    private static UserController instance;
    
    private UserController() {}
    
    public static UserController getInstanceUser() {
        if (instance == null) {     
            instance = new UserController();
        }
        return instance;
    }
    
    public String addFriend(String userId, String userIdFriend){
        DBConnection db = DBConnection.Instance();
        User user = db.getUser(userId);
        User user2 = db.getUser(userIdFriend);
        if (user != null && user2 != null) {
            if (userId.compareTo(userIdFriend) > 0){
                return db.insertData("amigos(usuiduno, usuiddos) " 
                        + "VALUES('" + userIdFriend + "', '" + userId + "');");
            }
            else {
                return db.insertData("amigos(usuiduno, usuiddos) " 
                        + "VALUES('" + userId + "', '" + userIdFriend + "');");
            }
        }
        return "";
    }
    
     public boolean deleteFriend(String userId, String userIdFriend) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence;
        if (userId.compareTo(userIdFriend) > 0) {
            sqlSentence = "where (usuiduno = '" + userIdFriend + "' and usuiddos =  '" + userId + "');";
        }
        else{ 
            sqlSentence = "where (usuiduno = '" + userId + "' and usuiddos =  '" + userIdFriend + "');";
        }
        return db.deleteData("amigo", sqlSentence) != "";
    }
     
     public boolean createUser(String userName, String password, String name, String dir, String mail) {
         DBConnection db = DBConnection.Instance();
         return db.insertData("Usuarios(usuid, usunom, usudir, usumail, usupass) VALUES('" + userName + "', '" +
                    name  + "', '"+ dir + "', '" + mail + "', '" + password + "')") != "";
     }
     
     public ArrayList<Friends> getFriends(String userId){
         DBConnection db = DBConnection.Instance();
        try {
            return db.getFriends(userId);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
     
    public User getUser(String userName) {
         DBConnection db = DBConnection.Instance();
         return db.getUser(userName);
     }
}
