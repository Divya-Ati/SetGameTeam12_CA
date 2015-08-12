/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.Service;

import com.Team12.Model.Game;
import com.Team12.Model.User;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@javax.enterprise.context.ApplicationScoped
public class GameServiceImpl implements GameService {
    @PersistenceContext private EntityManager em;
    private final HashMap<String, Game> games = new HashMap<>();
    @Override
    public Game createGame(User user) {
        Game game = new Game(user);
        games.put(game.getId(), game);
        return game;
    }
//    public Game createallGame(String id,String createdDate)
//    {
//            Game game = new Game();
//            game.setId(id);
//            game.setCreatedDate(createdDate);
//            em.persist(game);
//            return game;
//    }
    
    
    
    
    @Override
    public Game getGame(String id) {
        return games.get(id);
    }
    
}
