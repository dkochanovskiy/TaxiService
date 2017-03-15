package ru.kochanovskiy.taxiservice.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kochanovskiy.taxiservice.controllers.Servlets.CarServlet;
import ru.kochanovskiy.taxiservice.models.pojo.Car;
import ru.kochanovskiy.taxiservice.services.CarService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public void setUserDAO(CarService carService) {
        this.carService = carService;
    }

    static private Logger logger = Logger.getLogger(CarServlet.class);

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    protected String carGet(HttpServletRequest req, HttpServletResponse resp){
        List<Car> carsList= carService.getAllCars();
        req.setAttribute("carsList", carsList);
        //req.getRequestDispatcher("/car.jsp").forward(req, resp);
        return  "car";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    protected String carPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return  "car";
    }

}
