package com.Spring.toDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
		
		System.out.println("To-Do-App Project is running here ====================");
	}

}
