package services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CarRepository;
import models.Car;
import services.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public Car getCarByName(String name) {
        return carRepository.getCarByName(name);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public Car getCarById(String id) {
        return carRepository.getCarById(id);
    }

    @Override
    public void updateCar(String id, Car car) {
        carRepository.updateCar(id, car);
    }

    @Override
    public void deleteCarById(String id) {
        carRepository.deleteCarById(id);
    }
}
