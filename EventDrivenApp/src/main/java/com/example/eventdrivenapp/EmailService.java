package com.example.eventdrivenapp;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        System.out.println("📧 Sending welcome email to: " + event.getEmail());
    }
}
