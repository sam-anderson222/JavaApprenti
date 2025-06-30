package com.example.spring.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailService emailService;

    @Autowired
    public NotificationService(@Qualifier("outlookService") EmailService emailService) {
        this.emailService = emailService;
    }

    public void send(String message) {
        System.out.println("Notification Service: " + message);
        emailService.sendEmail(message);
    }
}
