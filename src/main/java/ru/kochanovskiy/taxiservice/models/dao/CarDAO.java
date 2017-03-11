package ru.kochanovskiy.taxiservice.models.dao;

import org.apache.log4j.Logger;
import ru.kochanovskiy.taxiservice.models.connector.DataSource;
import ru.kochanovskiy.taxiservice.models.pojo.Car;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 21.02.17.
 */
public class CarDAO {

    public static final String INSERT_CAR_QUERY = "insert into Cars( brand, model, number, color) values ( ? ,?, ?, ?)";
    public static final String GET_CAR_BY_ID_QUERY = "select * from Cars where id = ?";
    public static final String GET_ALL_CAR_QUERY = "select * from Cars";
    public static final String UPDATE_CAR_BY_ID_QUERY = "update Cars set id = ?, brand = ?,model= ?,number = ?,color = ? where id = ?";
    public static final String REMOVE_CAR_BY_ID_QUERY = "delete from Cars where id = ?";

    Connection connection = null;


    /*
    *   Logger init
     */
    private static final Logger logger = Logger.getLogger(CarDAO.class);

    /*
    *   Insert Car
     */
    public static void insertCar( Car car) throws PropertyVetoException, SQLException, IOException {
        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(INSERT_CAR_QUERY)){
            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getNumber());
            ps.setString(4, car.getColor());
            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*
    *   Car show
     */
    public static void selectCar(int id) {
        try(PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(GET_CAR_BY_ID_QUERY);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String number = rs.getString("number");
                String color = rs.getString("color");
            }
        } catch (SQLException e) {
            logger.trace("Ошибка!");
        } catch (IOException e) {
            logger.trace("Ошибка!");
        } catch (PropertyVetoException e) {
            logger.trace("Ошибка!");
        }
    }

    /*
    *   Show all Cars
    */
    public static List<Car> getAllCars() {
        List<Car> carsList = new ArrayList<>();
        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(GET_ALL_CAR_QUERY);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Car car = new Car();
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setNumber(rs.getString("number"));
                car.setColor(rs.getString("color"));
                carsList.add(car);
            }
        } catch (SQLException e) {
            logger.trace("Невозможно выполнить SQL-запрос!");
        } catch (IOException e) {
            logger.trace("Ошибка!");
        } catch (PropertyVetoException e) {
            logger.trace("Ошибка!");
        }
        return carsList;
    }


    /*
    *   Car update
     */
    public static void updateCar(int id, String brand, String model, String number, String color){
        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(UPDATE_CAR_BY_ID_QUERY)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.trace("Невозможно выполнить SQL-запрос!");
        } catch (IOException e) {
            logger.trace("Ошибка!");
        } catch (PropertyVetoException e) {
            logger.trace("Ошибка!");
        }
    }

    /*
    *   Car remove
     */
    public static void deleteCar(String id){
        try (PreparedStatement ps = DataSource.getInstance().getConnection().prepareStatement(UPDATE_CAR_BY_ID_QUERY)) {
            ps.executeUpdate(REMOVE_CAR_BY_ID_QUERY);
        } catch (SQLException e) {
            logger.trace("Невозможно выполнить SQL-запрос!");
        } catch (IOException e) {
            logger.trace("Ошибка ввода-вывода!");
        } catch (PropertyVetoException e) {
            logger.trace("Ошибка!");
        }
    }
}