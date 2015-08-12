/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.web;

import java.io.IOException;
import java.math.BigDecimal;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.OutboundEvent;


@WebServlet("/newMessage")
public class NewMessageServlet extends HttpServlet {
     @Inject private ParticipantList participantList;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
         String name = req.getParameter("name");
     
        String image1 = req.getParameter("image1");
        String image2 = req.getParameter("image2");
        String image3 = req.getParameter("image3");

        JsonObject json = Json.createObjectBuilder()
                //.add("name", name)
                .add("image1", image1)
                .add("image2", image2)
                .add("image3", image3)
                .build();
        System.out.println(name + ">>> " + image1);
        OutboundEvent data1 = new OutboundEvent.Builder()
                .data(JsonObject.class, json)
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build();

        participantList.send(data1);    
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}