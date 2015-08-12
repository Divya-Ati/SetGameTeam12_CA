package com.Team12.rest;


import com.Team12.Business.UserGameBean;
import com.Team12.Model.UserGame;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Path("/gamelist")
public class UserGameResource {
    @EJB private UserGameBean userGameBean;
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        List<UserGame> result = userGameBean.findAll();
        System.out.println(result);
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (UserGame c: result)
            builder.add(c.toJson());
        
        return (Response.ok(builder.build()).build());       
        
    }
    
    
    
    @Path("{gameID}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(@PathParam("gameID")Integer gameID) 
    { 
        UserGame usergame = userGameBean.find(gameID);
        System.out.println(">>>> usergame from find = " + usergame);
        if (null == usergame)
            return (Response.status(Response.Status.NOT_FOUND).build());
        return (Response.ok(usergame.toJson()).build());
    }     
    
}

