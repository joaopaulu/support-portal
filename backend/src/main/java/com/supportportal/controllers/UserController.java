package com.supportportal.controllers;

import com.supportportal.exception.domain.ExceptionHandling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController extends ExceptionHandling {

    @GetMapping
    public String showUser(){
        return "application Works";
    }
}
