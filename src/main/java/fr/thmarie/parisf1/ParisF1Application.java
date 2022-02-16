package fr.thmarie.parisf1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = ParisF1Application.class)
public class ParisF1Application {

	public static void main(String[] args) {
		SpringApplication.run(ParisF1Application.class, args);
	}

}
