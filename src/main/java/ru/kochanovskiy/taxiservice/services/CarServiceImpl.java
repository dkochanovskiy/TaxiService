package ru.kochanovskiy.taxiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kochanovskiy.taxiservice.models.dao.CarDAOImpl;
import ru.kochanovskiy.taxiservice.models.pojo.Car;

import java.util.List;

@Component("CarServiceImpl")
public class CarServiceImpl implements ru.kochanovskiy.taxiservice.services.interfaces.CarService {
    private CarDAOImpl carDAOImpl;

    @Autowired
    @Qualifier("CarDAOImpl")
    public void setUserDAO(CarDAOImpl carDAOImpl) {
        this.carDAOImpl = carDAOImpl;
    }

    public List<Car> getAllCars(){
        return carDAOImpl.getAllCars();
    }
}
