/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.Business;


import com.Team12.Model.UserGame;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class UserGameBean {
    @PersistenceContext private EntityManager em;
    
    
     public List<UserGame> findAll() {
        TypedQuery<UserGame> query = em.createQuery(
                "select C from UserGame C", UserGame.class);
        return (query.getResultList());
    }
    
    
    public UserGame find(Integer gameID) 
    {
        TypedQuery<UserGame> query=em.createQuery
        ("select C from UserGame where C.gameID=:gameId", UserGame.class);
        query.setParameter("gameID", gameID);
        List<UserGame> result = query.getResultList();
        return ((result.size() > 0)? result.get(0): null);
    }
        }


