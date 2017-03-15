package ru.kochanovskiy.taxiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kochanovskiy.taxiservice.models.dao.UserDAOImpl;

@Component("UserServiceImpl")
public class UserServiceImpl implements ru.kochanovskiy.taxiservice.services.interfaces.UserService {

    private UserDAOImpl userDAOImpl;

    @Autowired
    @Qualifier("UserDAOImpl")
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
