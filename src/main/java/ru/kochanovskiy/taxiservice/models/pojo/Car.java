package ru.kochanovskiy.taxiservice.models.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Car implements Serializable {
    private String brand;
    private String model;
    private String number;
    private String color;

    public Car(){}

    public Car(String brand, String model, String number, String color){
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    @XmlElement
    public String setBrand(String brand) {
        this.brand = brand;
        return brand;
    }

    public String getModel() {
        return model;
    }

    @XmlElement
    public String setModel(String model) {
        this.model = model;
        return model;
    }

    public String getNumber() {
        return number;
    }

    @XmlElement
    public String setNumber(String number) {
        this.number = number;
        return number;
    }

    public String getColor() {
        return color;
    }

    @XmlElement
    public String setColor(String color) {
        this.color = color;
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
