package ru.kochanovskiy.taxiservice.services.interfaces;

public interface UserService {

    public boolean checkIsNotEmpty(String login, String password);

    public String getPass(String login);

}
