package ru.kochanovskiy.taxiservice.controllers;

import org.apache.log4j.Logger;
import ru.kochanovskiy.taxiservice.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    static private Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try{
            if(password.equals(UserService.getPass(login)) && UserService.checkIsNotEmpty(login, password)){
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
                req.getRequestDispatcher("/car.jsp").include(req, resp);
            } else{
                req.getRequestDispatcher("/login.jsp").include(req, resp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}