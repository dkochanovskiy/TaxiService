package ru.kochanovskiy.taxiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kochanovskiy.taxiservice.models.dao.UserDAO;

/**
 * Created by sa on 08.03.17.
 */

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean checkIsNotEmpty(String login, String password){
        return (userDAO.checkIsNotEmpty(login, password));
    }

    public String getPass(String login){
        return (userDAO.getPass(login));
    }
}
