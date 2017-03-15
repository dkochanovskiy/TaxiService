package ru.kochanovskiy.taxiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kochanovskiy.taxiservice.models.dao.UserDAOImpl;

@Service
public class UserService {
    private UserDAOImpl userDAOImpl;

    @Autowired
    public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    public boolean checkIsNotEmpty(String login, String password){
        return (userDAOImpl.checkIsNotEmpty(login, password));
    }

    public String getPass(String login){
        return (userDAOImpl.getPass(login));
    }
}
