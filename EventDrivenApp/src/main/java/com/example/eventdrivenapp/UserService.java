package com.example.eventdrivenapp;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void registerUser(UserDto user) {
        System.out.println("Registering user: " + user.getUsername());
        System.out.println("Sending welcome email to: " + user.getUsername());
    }
}
