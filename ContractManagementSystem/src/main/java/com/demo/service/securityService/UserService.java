package com.demo.service.securityService;

import com.demo.DTO.securityModel.User;
import com.demo.repository.securityRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private JWTService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("CONTRACTOR"); // default role
        }
        return repo.save(user);
    }

    public String verify(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            User dbUser = repo.findByUsername(user.getUsername());
            return jwtService.generateToken(dbUser);
        } else {
            return "Fail";
        }
    }
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // New method to update role
    public User updateUserRole(int id, String role) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(role.toUpperCase());
        return repo.save(user);
    }
}
