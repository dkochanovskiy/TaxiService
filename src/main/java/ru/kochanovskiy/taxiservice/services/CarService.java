package ru.kochanovskiy.taxiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kochanovskiy.taxiservice.models.dao.CarDAOImpl;
import ru.kochanovskiy.taxiservice.models.pojo.Car;

import java.util.List;

@Service
public class CarService {
    private CarDAOImpl carDAOImpl;

    @Autowired
    public void setUserDAO(CarDAOImpl carDAOImpl) {
        this.carDAOImpl = carDAOImpl;
    }


    public List<Car> getAllCars(){
        return carDAOImpl.getAllCars();
    }
}
