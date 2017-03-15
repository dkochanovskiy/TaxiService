package ru.kochanovskiy.taxiservice.models.dao;

import ru.kochanovskiy.taxiservice.models.pojo.Car;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CarDAO {

    public void insertCar( Car car) throws PropertyVetoException, SQLException, IOException;

    /*
    *   Car show
     */
    public void selectCar(int id);

    /*
    *   Show all Cars
    */
    public List<Car> getAllCars();

    /*
    *   Car update
     */
    public void updateCar(int id, String brand, String model, String number, String color);

    /*
    *   Car remove
     */
    public void deleteCar(String id);
}
