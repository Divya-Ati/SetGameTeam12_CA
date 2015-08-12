package com.Team12.Model;

import com.Team12.Service.GameService;
import com.Team12.Service.GameServiceImpl;
import java.util.Calendar;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Game {
    @PersistenceContext private static EntityManager em;
    private String id;
    private String createdDate;
    private User creator;
    private CardOnTable cardOnTable;

    public CardOnTable getCardOnTable() {
        return cardOnTable;
    }

    public Game() {
    }
    

    public void setCardOnTable(CardOnTable cardOnTable) {
        this.cardOnTable = cardOnTable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    public Game(User creator) {
        
        id="1234";
        cardOnTable = new CardOnTable();
        createdDate = Calendar.getInstance().getTime().toString();
        this.creator = creator;
           
        }
    public JsonObject toJson() {
        GameService si = new GameServiceImpl();
        JsonObjectBuilder gameData = Json.createObjectBuilder();
        gameData.add("id", id);
        gameData.add("creator", creator.getUsername());
        gameData.add("date", createdDate);
      //  si.createallGame( id,createdDate);
        return gameData.build();
    }

    @Override
    public String toString() {
       return "Game{" + "cardOnTable=" + cardOnTable + ", id=" + id + ", createdDate=" + createdDate + ", creator=" + creator + '}';
    }

}
