
package com.Team12.Model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id @Column (name="userName") private String username;
    private int userid;
    private String email;
    private String userpassword;

    public User() {
    }

    
    public User(String username) {
        this.username = username;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

   
    public JsonObject toJson(){
        return (Json.createObjectBuilder()               
                .add("userName", username )
                .build());
    }
    


   

    

   
    
}
