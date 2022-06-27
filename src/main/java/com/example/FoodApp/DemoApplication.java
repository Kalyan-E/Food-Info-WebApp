package com.example.FoodApp;

import com.example.FoodApp.Model.Blog;
import com.example.FoodApp.Model.Location;
import com.example.FoodApp.Repo.Repo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(Repo repository) {
		return args -> {
			Location location = new Location("80", "90");

			Blog model = new Blog("initial blog", "This is the first blog.", "South-Indian", location, " /", LocalDateTime.now(), LocalDateTime.now());
			repository.insert(model);
		};
	}
}