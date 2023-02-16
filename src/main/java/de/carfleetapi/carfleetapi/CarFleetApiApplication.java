package de.carfleetapi.carfleetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CarFleetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarFleetApiApplication.class, args);
	}

}
