package services;

import models.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    Car getCarByName(String name);
    List<Car> getAllCars();
    Car getCarById(String id);
    void updateCar(String id, Car car);
    void deleteCarById(String id);
}
