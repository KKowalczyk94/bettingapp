package com.example.demo.controllers.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "Home Controller", description = "Home controller operations")
public class HomeController {

    @GetMapping
    @Operation(summary = "Get Home", description = "Returns a welcome message")
    public String home() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/hello")
    @Operation(summary = "Say Hello", description = "Returns a hello message")
    public String hello() {
        return "Hello, World!";
    }
}
