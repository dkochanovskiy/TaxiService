package ru.kochanovskiy.taxiservice.models.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class User implements Serializable {

    private String id;
    private String userName;
    private String login;
    private String password;

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String userName, String login, String password){
        this.userName = userName;
        this.login = login;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return userName;
    }

    @XmlElement
    public void setName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
}

