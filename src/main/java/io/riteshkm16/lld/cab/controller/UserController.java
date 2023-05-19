package io.riteshkm16.lld.cab.controller;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.model.dto.Location;
import io.riteshkm16.lld.cab.service.UserService;

import java.util.List;

public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //1.Register
    public User registerUser(User user){
        return userService.registerUser(user);
    }

}
