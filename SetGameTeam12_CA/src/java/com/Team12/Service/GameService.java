/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.Service;

import com.Team12.Model.Game;
import com.Team12.Model.User;

public interface GameService {

    public Game createGame(User user);
    
    //public Game createallGame(String id,String createdDate);
    
 
    
    
    public Game getGame(String id);
}
