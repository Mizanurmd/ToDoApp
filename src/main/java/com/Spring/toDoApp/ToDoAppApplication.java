package com.Spring.toDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Spring.toDoApp.models.EmailSender;
import com.Spring.toDoApp.models.Vuser;



@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

	@Autowired
	private EmailSender emailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
		
		System.out.println("To-Do-App Project is running here ====================");
	}

	@Override
	public void run(String... args) throws Exception {
		Vuser us = new Vuser();
		us.setFromAddress("sizansarder11@gmail.com");
		us.setToAddress("mizanur021991@gmail.com");
		us.setSubject("Task");
		us.setMessage("How are your?");
		us.setUserName("Sizan");
		emailSender.sendEmailUsingVelocityTemplate(us);
				 
	}

}
