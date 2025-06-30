package com.example.spring.demo.service;
import org.springframework.stereotype.Service;

@Service("outlookService")
public class OutlookService implements EmailService{
    @Override
    public void sendEmail(String message) {
        System.out.println("Outlook: " + message);
    }
}
