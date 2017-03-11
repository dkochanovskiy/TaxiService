package ru.kochanovskiy.taxiservice.controllers;

import org.apache.log4j.Logger;
import ru.kochanovskiy.taxiservice.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    static private Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try{
            if(UserService.checkIsNotEmpty(login, password)){
                if(password.equals(UserService.getPass(login))){

                }
            } else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                PrintWriter out= resp.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(req, resp);
            }
        }
        catch (Exception e){
            logger.trace("Error");
        }

    }
}