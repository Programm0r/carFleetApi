package mappers;

import dtos.CarDTO;
import models.Car;

public class ObjectMapper {
    public CarDTO mapToCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        if(car != null){
            carDTO.setId(carDTO.getId());
            carDTO.setName(carDTO.getName());
            carDTO.setColor(carDTO.getColor());
            carDTO.setPrice(carDTO.getPrice());
            carDTO.setModel(carDTO.getModel());
            carDTO.setYear(carDTO.getYear());
            carDTO.setDescription(carDTO.getDescription());
        }
        return carDTO;
    }
}
