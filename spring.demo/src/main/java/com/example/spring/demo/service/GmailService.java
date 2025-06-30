package com.example.spring.demo.service;
import org.springframework.stereotype.Service;

@Service("gmailService")
public class GmailService implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Gmail: " + message);
    }
}
