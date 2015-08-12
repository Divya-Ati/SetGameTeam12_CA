/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.Business;

import com.Team12.Model.User;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserBean {
    @PersistenceContext(name = "JQueryMobileTestingPU") 
    private EntityManager em;
    
    public User login (String username, String password) 
    {
        
        String query = "SELECT user FROM User user where user.username=:username and user.userpassword=:password";
        Query q = em.createQuery(query);
         
            q.setParameter("username", username);
            q.setParameter("password", password);
            List<User> userList=q.getResultList();
            return (User)userList.get(0); 
     
    }
    
    public void registerUser(String usr, String pwd,String email) {
       User u = new User();
       u.setUsername(usr);
       u.setEmail(email);
       u.setUserpassword(pwd);
        System.out.println(""+u.toString());
       em.persist(u);     
    }
}
    

