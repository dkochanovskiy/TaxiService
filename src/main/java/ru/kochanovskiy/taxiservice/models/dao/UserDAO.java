package ru.kochanovskiy.taxiservice.models.dao;

public interface UserDAO {
    boolean checkIsNotEmpty(String login, String password);
    String getPass(String login);
    String getRole(String login);
}
