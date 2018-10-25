/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd.Models;

/**
 *
 * @author federicoponcedeleon
 */
public class User {
    private final String userName;
    private String name;
    private String email;
    private String password;
    private String address;
    
    public User (String usuName, String usuNom, String usuPass, String usuAdd, String usuMail) {
        this.userName = usuName;
        this.name = usuNom;
        this.email = usuMail;
        this.password = usuPass;
        this.address = usuAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
}
