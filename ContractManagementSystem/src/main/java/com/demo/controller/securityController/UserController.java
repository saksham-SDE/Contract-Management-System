package com.demo.controller.securityController;

import com.demo.DTO.securityModel.User;
import com.demo.service.securityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){

        return userService.verify(user);
    }
}