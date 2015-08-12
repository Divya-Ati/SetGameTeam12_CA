/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NewIdServlet")
public class NewIdCreationServlet  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desription= req.getParameter("uname");
        String createdDate = Calendar.getInstance().getTime().toString();
        String IDKey=desription+createdDate;
        PrintWriter pw=resp.getWriter();
        pw.println("====================");
        pw.println(IDKey);
       resp.setContentType("text/html");  
       PrintWriter out = resp.getWriter();  
       out.println("<html-code>");
                
    }
    

    public NewIdCreationServlet() {
    }
    
    
    
}
