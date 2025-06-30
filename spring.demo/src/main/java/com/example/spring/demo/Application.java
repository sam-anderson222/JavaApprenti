package com.example.spring.demo;

import com.example.spring.demo.service.NotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final NotificationService notificationService;

	public Application(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) {
		notificationService.send("Hello from the annotation project.");
	}

}
