package models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "students")
public class Car {
    @Id
    private String id;
    private String name;
    private String model;
    private String color;
    private String year;
    private String price;
    private String description;

    public Car() {}
    public Car(String id, String name, String model, String color, String year, String price, String description) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.description = description;
    }
}
