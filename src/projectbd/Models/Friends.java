/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

/**
 *
 * @author Enzo
 */
public class Friends {
    private String userId1,
           userId2;
    
    public Friends(String usuId, String usuId2) {
        this.userId1 = usuId;
        this.userId2 = usuId2;
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId(String userId) {
        this.userId1 = userId;
    }

    public String getUserId2() {
        return userId2;
    }

    public void setUserId2(String userId) {
        this.userId2 = userId;
    }
}
