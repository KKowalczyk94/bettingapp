package com.example.demo.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(tags = "Home Controller", description = "Home controller operations")
public class HomeController {

    @GetMapping
    @ApiOperation(value = "Get Home", notes = "Returns a welcome message")
    public String home() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/hello")
    @ApiOperation(value = "Say Hello", notes = "Returns a hello message")
    public String hello() {
        return "Hello, World!";
    }
}
