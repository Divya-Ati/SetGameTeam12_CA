
package com.Team12.Controller;


import com.Team12.Business.UserBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class registerServlet  extends HttpServlet {
        @EJB private UserBean userBean;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            String uname = req.getParameter("uname");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            System.out.println(""+uname+password+email);
            userBean.registerUser(uname, password, email);
            resp.setContentType("text/html");
           resp.sendRedirect("/test/setgameLogin.html");
        }

  
}
