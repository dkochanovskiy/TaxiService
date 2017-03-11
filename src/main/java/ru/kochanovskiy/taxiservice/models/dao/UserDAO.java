package ru.kochanovskiy.taxiservice.models.dao;

import org.apache.log4j.Logger;
import ru.kochanovskiy.taxiservice.models.connector.DataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sa on 08.03.17.
 */
public class UserDAO {

    Connection connection = null;

//    public static final String GET_ROLE_BY_ID = "";

    /*
    *   Logger init
     */
    private static final Logger logger = Logger.getLogger(UserDAO.class);

    /*
    *   Check for occupancy
     */
    public static boolean checkIsNotEmpty(String login, String password){
        boolean boo;
        if(!(login.equals("")) && (!(password.equals("")))) {
            boo = true;
        } else boo = false;
        return boo;
    }

    /*
    *   Obtaining password by login
     */
    public static String getPass(String login){
        String password = "";
        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement("select password from Users where login = '" + login +"'");
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                password = rs.getString("password");
            }
        }
        catch (SQLException e) {
            logger.trace("Ошибка!");
        } catch (IOException e) {
            logger.trace("Ошибка!");
        } catch (PropertyVetoException e) {
            logger.trace("Ошибка!");
        }
        return password;
    }

    /*
    *   Getting role by id
     */
    public static String getRole(String login){
        String role = "";

        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement("select role from Users where login = '" + login +"'");
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                role = rs.getString("role");
            }
        }
        catch (SQLException e) {
            logger.trace("Ошибка!");
        } catch (IOException e) {
            logger.trace("Ошибка!");
        } catch (PropertyVetoException e) {
            logger.trace("Ошибка!");
        }
        return role;
    }
}
