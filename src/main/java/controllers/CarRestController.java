package controllers;

import dtos.CarDTO;
import mappers.ObjectMapper;
import models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CarService;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/car")
public class CarRestController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = POST, value = "/addCar", produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> addCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        carService.addCar(ObjectMapperUtils.mapToCar(carDTO,car));
        return new ResponseEntity<>("Car added successfully!", HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/getCars", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        ObjectMapper mapper = new ObjectMapper();

        List<Car> cars = carService.getAllCars();

        List <CarDTO> response = new ArrayList<>();
        for(Car car : cars){
            response.add(mapper.mapToCarDTO(car));
        }

        for(int i = 0; i < response.size(); i++){
            if(isResponseNotEmpty(response.get(i))){
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = GET, value = "/getCars/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> getCar(@PathVariable String id) {
        ObjectMapper mapper = new ObjectMapper();
        Car car = carService.getCarById(id);

        CarDTO response = mapper.mapToCarDTO(car);
        if(isResponseNotEmpty(response)){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return new ResponseEntity<>("Bad Request: No car found by that id or an error occurred. Please try another carId.",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = GET, value = "/getCars/{name}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> getCarByName(@PathVariable String name) {

        ObjectMapper mapper = new ObjectMapper();
        Car car = carService.getCarByName(name);

        CarDTO response = mapper.mapToCarDTO(car);
        if(isResponseNotEmpty(response)){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return new ResponseEntity<>("Bad Request: No car found by that name or an error occurred. Please try another car model name.",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = PUT, value = "/updateCar/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> updateCar(@RequestBody CarDTO carDTO, @PathVariable String id) {
        Car car = new Car();
        carService.updateCar(id, ObjectMapperUtils.mapToCar(carDTO,car));
        return new ResponseEntity<>("Car updated successfully!", HttpStatus.OK);
     }

    @RequestMapping(method = DELETE, value = "/deleteCar/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        carService.deleteCarById(id);
        return new ResponseEntity<>("Car deleted successfully!", HttpStatus.OK);
    }

    private boolean isResponseNotEmpty(CarDTO response) {
        return
                response.getId() != null &&
                        response.getName() != null &&
                        response.getColor() != null &&
                        response.getPrice() != null &&
                        response.getModel() != null &&
                response.getYear() != null &&
                response.getDescription() != null;
    }
}
