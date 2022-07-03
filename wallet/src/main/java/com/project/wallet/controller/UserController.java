package com.project.wallet.controller;

import com.project.wallet.domain.User;
import com.project.wallet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUserList(){
        return userService.findUsers();
    }

    @PostMapping
    public Long createUser(@RequestBody User user) {
        return userService.join(user);
    }
}
