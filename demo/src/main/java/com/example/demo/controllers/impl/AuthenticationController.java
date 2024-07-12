package com.example.demo.controllers.impl;

import com.example.demo.controllers.api.AuthenticationControllerApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class AuthenticationController implements AuthenticationControllerApi {

    @GetMapping("/user")
    public String getUser(){
    return "User info";}
}



