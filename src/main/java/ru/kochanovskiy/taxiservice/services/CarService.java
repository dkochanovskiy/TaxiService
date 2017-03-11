package ru.kochanovskiy.taxiservice.services;

import ru.kochanovskiy.taxiservice.models.dao.CarDAO;
import ru.kochanovskiy.taxiservice.models.pojo.Car;

import java.util.List;

/**
 * Created by sa on 26.02.17.
 */
public class CarService {
    public static List<Car> getAllCars(){
        return CarDAO.getAllCars();
    }
}
