package ru.kochanovskiy.taxiservice.controllers.Servlets;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kochanovskiy.taxiservice.models.pojo.Car;
import ru.kochanovskiy.taxiservice.services.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
    private CarService carService;

    @Autowired
    public void setUserDAO(CarService carService) {
        this.carService = carService;
    }
    static private Logger logger = Logger.getLogger(CarServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            List<Car> carsList= carService.getAllCars();
            req.setAttribute("carsList", carsList);
            req.getRequestDispatcher("/car.jsp").forward(req, resp);
        }
        catch (ServletException e){
            logger.trace("Невозможно выполнить SQL-запрос!");
        }
        catch (IOException e){
            logger.trace("Ошибка ввода-вывода!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
