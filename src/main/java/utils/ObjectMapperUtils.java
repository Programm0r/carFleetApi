package utils;

import dtos.CarDTO;
import models.Car;

public class ObjectMapperUtils {
    public static Car mapToCar(CarDTO carDTO, Car car) {
        car.setId(carDTO.getId());
        car.setName(carDTO.getName());
        car.setModel(carDTO.getModel());
        car.setColor(carDTO.getColor());
        car.setPrice(carDTO.getPrice());
        car.setYear(carDTO.getYear());
        car.setDescription(carDTO.getDescription());
        return car;
    }
}
