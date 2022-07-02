package com.project.wallet.controller;

import com.project.wallet.domain.User;
import com.project.wallet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/users")
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
