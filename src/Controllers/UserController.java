/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.UUID;
import projectbd.DBConnection;
import projectbd.Models.User;

/**
 *
 * @author Mayra
 */
public class UserController {
    //Agregar amigo
    //Eliminar amigo
    //agregar compra
    //agregar servicio
    //agregar reunion
    //eliminar, compra, servicio, reunion 
    //Agregar gasto 
    private static UserController instance;
    
    private UserController() {}
    
    public static UserController getInstanceUser() {
        if (instance == null) {     
            instance = new UserController();
        }
        return instance;
    }
    
    public long addFriend(String userId, String userIdAmigo){
        DBConnection db = DBConnection.Instance();
        User user = db.getUser(userId);
        User user2 = db.getUser(userIdAmigo);
        if (user != null && user2 != null) {
            return db.insertData("amigos(usuiduno, usuiddos) " 
                    + "VALUES(" + userId + "," + userIdAmigo + ";");
        }
        return -1;
    }
    
     public boolean deleteFriend(String userId, String userIdFriend) {
        DBConnection db = DBConnection.Instance();
        String sqlSentence = "where (usuiduno = '" + userId + "' and usuiddos =  '" + userIdFriend + ") or (usuiduno = '"+ userIdFriend + "' and usuiddos= '" + userId + "');";
        return db.deleteData("amigo", sqlSentence) != -1;
    }
    
    
}
