package repositories;

import models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {
    void addCar(Car car);
    List<Car> getAllCars();
    Car getCarByName(String name);
    Car getCarById(String id);
    void updateCar(String id, Car car);
    void deleteCarById(String id);
}
