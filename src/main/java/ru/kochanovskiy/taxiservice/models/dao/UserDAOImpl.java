package ru.kochanovskiy.taxiservice.models.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.kochanovskiy.taxiservice.models.connector.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {

    Connection connection = null;

    /*
    *   Logger init
     */
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    /*
    *   Check for occupancy
     */
    public boolean checkIsNotEmpty(String login, String password){
        boolean boo;
        if(!(login.equals("")) && (!(password.equals("")))) {
            boo = true;
        } else boo = false;
        return boo;
    }

    /*
    *   Obtaining password by login
     */
    public String getPass(String login){
        String password = "";
        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement("select password from Users where login = '" + login +"'");
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                password = rs.getString("password");
            }
        }
        catch (SQLException e) {
            logger.trace("SQLException!");
        } catch (IOException e) {
            logger.trace("Ошибка!");
        } catch (PropertyVetoException e) {
            logger.trace("PropertyVetoException!");
        }
        return password;
    }

    /*
    *   Getting role by id
     */
    public String getRole(String login){
        String role = "";

        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement("select role from Users where login = '" + login +"'");
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException e) {
            logger.trace("SQLException!");
        } catch (IOException e) {
            logger.trace("IOException!");
        } catch (PropertyVetoException e) {
            logger.trace("PropertyVetoException!");
        }
        return role;
    }
}
