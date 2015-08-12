package com.Team12.Controller;


import com.Team12.Model.Card;
import com.Team12.Model.CardOnTable;
import com.Team12.Model.Game;
import com.Team12.Model.SetEngine;
import com.Team12.Service.GameService;
import com.Team12.web.ParticipantList;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.media.sse.OutboundEvent;



@Path("/cardsOnTable")
@Stateless
public class TableServlet extends HttpServlet {

    @Inject
    GameService gameService;
 @Inject private ParticipantList participantList;
    @GET
    @Produces("application/json")
    @Path("/getTableCards")
    public JsonObject showTableCards(@Context UriInfo info) {
        
        CardOnTable cardOnTable = null;
        String id = info.getQueryParameters().getFirst("id");
        if (id != null) {
            Game game = (gameService.getGame(id));
            cardOnTable = game.getCardOnTable();
            cardOnTable.showOnTable(false);
        } else {
            cardOnTable = new CardOnTable();
            cardOnTable.showOnTable(true);
        }
        //cardOnDeck.getCards();
        JsonObjectBuilder results = Json.createObjectBuilder();
        JsonArrayBuilder cards = Json.createArrayBuilder();
        if (id != null) {
            Game game = (gameService.getGame(id));
            cardOnTable = game.getCardOnTable();
            cardOnTable.showOnTable(false);
        }
        for (Card card : cardOnTable.tableCard) {
            cards.add(card.toJson());
        }
        results.add("cards", cards.build());
        return results.build();
    }

    @GET
    @Produces("application/json")
    @Path("/checkTableCards")
    public JsonObject checkTableCards(@Context UriInfo info) {
        CardOnTable cardOnTable = null;
        String gameId = info.getQueryParameters().getFirst("id");
        int cardId1 = Integer.parseInt(info.getQueryParameters().getFirst("card1").toString());
        int cardId2 = Integer.parseInt(info.getQueryParameters().getFirst("card2").toString());
        int cardId3 = Integer.parseInt(info.getQueryParameters().getFirst("card3").toString());
        System.out.println(" this is card 1 , 2 & 3 : "+cardId1+cardId2+cardId3);
        
        
        /// application scope retival
        
        
        
        
         JsonObject json = Json.createObjectBuilder()
//                .add("name", name)
                .add("image1", cardId1)
                .add("image2", cardId2)
                .add("image3", cardId3)
                .build();
//        System.out.println(name + ">>> " + image1);
        OutboundEvent data1= new OutboundEvent.Builder()
                .data(JsonObject.class, json)
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build();
        participantList.send(data1);
        
        JsonObjectBuilder results = Json.createObjectBuilder();
        JsonArrayBuilder cards = Json.createArrayBuilder();
        JsonArrayBuilder setCards = Json.createArrayBuilder();

        boolean valid = false;
        boolean success = true;
        // Call Service to check logic
        String id = info.getQueryParameters().getFirst("id");
        if (id != null) {
            Game game = (gameService.getGame(id));
            cardOnTable = game.getCardOnTable();
            Card card1 = cardOnTable.getCardOnTable(cardId1);
            Card card2 = cardOnTable.getCardOnTable(cardId2);
            Card card3 = cardOnTable.getCardOnTable(cardId3);
            if (card1 != null && card2 != null & card3 != null) {
                SetEngine setEngine = new SetEngine();
                valid = setEngine.isSet(card1, card2, card3);
//                valid=true;
                if (valid == true) {
                    //Remove the 3 cards and Replace the 3 cards at the same place
                    cardOnTable.setNewCardOnTable(card1);
                    cardOnTable.setNewCardOnTable(card2);
                    cardOnTable.setNewCardOnTable(card3);

                    for (Card card : cardOnTable.setGameCard) {
                        if (card != null) {
                            setCards.add(card.toJson());

                        } else {
                            success = false;
                        }
                    }
                }else{
                    for (Card card : cardOnTable.setGameCard) {
                        if (card != null) {
                            setCards.add(card.toJson());

                        } else {
                            success = false;
                        }
                    }
                }
            }
        }

        for (Card card : cardOnTable.tableCard) {
            cards.add(card.toJson());
        }
        results.add("setCards", setCards.build());
        results.add("status", Boolean.toString(valid));
        results.add("won", Boolean.toString(success));
        results.add("cards", cards.build());
        return results.build();
    }

}
