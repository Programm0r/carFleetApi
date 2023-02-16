package controllers;

import dtos.CarDTO;
import models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CarService;
import utils.ObjectMapperUtils;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarRestController {
    @Autowired
    private CarService carService;
    @PostMapping("/addCar")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        carService.addCar(ObjectMapperUtils.mapToCar(carDTO,car));
        return new ResponseEntity<>("Car added successfully!", HttpStatus.OK);
    }

    @GetMapping("/getCars")
    public List<Car> getAllCars() {
         return carService.getAllCars();
    }

    @GetMapping("/getCar/{id}")
    public Car getCar(@PathVariable String id) {
         return carService.getCarById(id);
    }

    @GetMapping("/getCar/{name}")
    public Car getCarByName(@PathVariable String name) {
        return carService.getCarByName(name);
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<?> updateCar(@RequestBody CarDTO carDTO, @PathVariable String id) {
        Car car = new Car();
        carService.updateCar(id, ObjectMapperUtils.mapToCar(carDTO,car));
        return new ResponseEntity<>("Car updated successfully!", HttpStatus.OK);
     }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable String id) {
        carService.deleteCarById(id);
        return new ResponseEntity<>("Car deleted successfully!", HttpStatus.OK);
    }
}
