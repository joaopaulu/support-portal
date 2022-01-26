package com.supportportal.controllers;

import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.ExceptionHandling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/", "/user"})
public class UserController extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() throws EmailExistException {
        //return "application Works";
        throw new EmailExistException("This email address is already taken");
    }
}
