package ru.kochanovskiy.taxiservice.services;

import org.springframework.stereotype.Service;
import ru.kochanovskiy.taxiservice.models.dao.UserDAO;

/**
 * Created by sa on 08.03.17.
 */

@Service
public class UserService {
    public static boolean checkIsNotEmpty(String login, String password){
        return (UserDAO.checkIsNotEmpty(login, password));
    }

    public static String getPass(String login){
        return (UserDAO.getPass(login));
    }
}
