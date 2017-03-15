package ru.kochanovskiy.taxiservice.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kochanovskiy.taxiservice.controllers.Servlets.LoginServlet;
import ru.kochanovskiy.taxiservice.services.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginLogoutController {

    private UserService userService;

    @Autowired
    public void setUserDAO(UserService userService) {
        this.userService = userService;
    }

    static private Logger logger = Logger.getLogger(LoginServlet.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String LoginGet() {
        logger.trace("Get");
        return "login";
        //req.getRequestDispatcher("/login.jsp").include(req, resp);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    protected String LoginPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try{
            if(password.equals(userService.getPass(login)) && userService.checkIsNotEmpty(login, password)){
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
                return "car";
                //req.getRequestDispatcher("/car.jsp").include(req, resp);
            } else{
                return "login";
                //req.getRequestDispatcher("/login.jsp").include(req, resp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected String logoutGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "logout";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    protected String logoutPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session =req.getSession();
        session.setAttribute("session", null);
        //resp.sendRedirect("login.jsp");
        return "login";

    }

}
