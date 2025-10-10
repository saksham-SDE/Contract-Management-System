package com.demo.controller.securityController;
import com.demo.DTO.securityModel.User;
import com.demo.service.securityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
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

    // Get all users (ADMIN only)
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Update role (ADMIN only)
    @PutMapping("/role/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUserRole(@PathVariable int id, @RequestParam String role) {
        return userService.updateUserRole(id, role);
    }
}
