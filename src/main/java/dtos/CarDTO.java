package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private String id;
    private String name;
    private String model;
    private String color;
    private String year;
    private String price;
    private String description;

    public CarDTO() {}

    public CarDTO(String id, String name, String model, String color, String year, String price, String description) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.description = description;
    }
}
