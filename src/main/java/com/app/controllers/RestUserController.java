package com.app.controllers;


import com.app.model.User;
import com.app.services.UserService;
import com.app.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//API End-point'i propisivaem tut, oni budut otlichatsja anatacijami


@RestController
public class RestUserController {

    @Autowired
    UserService userService;

    @Autowired
    private CurrentUser currentUser;


    @CrossOrigin
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin
    @GetMapping("/getEmail") //pod getName lezhit Email
    public String getEmail(){
        return currentUser.getName();
    }

}
