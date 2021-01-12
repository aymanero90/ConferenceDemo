package com.example.ConferenceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {  // extending this class enables Spring to provide for containerizing

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(
   	@RequestParam(value = "Name", defaultValue = "Ayman")
      String name) {
		return String.format("Hello %s!", name);
	}
}
