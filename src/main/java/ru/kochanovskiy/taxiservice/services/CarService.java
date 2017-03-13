package ru.kochanovskiy.taxiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kochanovskiy.taxiservice.models.dao.CarDAO;
import ru.kochanovskiy.taxiservice.models.pojo.Car;

import java.util.List;

/**
 * Created by sa on 26.02.17.
 */

@Service
public class CarService {
    public static List<Car> getAllCars(){
        return CarDAO.getAllCars();
    }
}
