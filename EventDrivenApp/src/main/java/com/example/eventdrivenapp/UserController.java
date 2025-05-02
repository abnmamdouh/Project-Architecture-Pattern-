package com.example.eventdrivenapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        System.out.println("Registering user: " + userDto.getUsername());

        // Publish event
        UserRegisteredEvent event = new UserRegisteredEvent(this, userDto.getUsername(), userDto.getEmail());
        eventPublisher.publishEvent(event);

        return ResponseEntity.ok("User " + userDto.getUsername() + " registered successfully!");
    }
}
