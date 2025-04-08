package com.demo.service.securityService;
import com.demo.DTO.securityModel.User;
import com.demo.repository.securityRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private JWTService service;
    @Autowired
    AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
    public String verify(User user){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
        if (authentication.isAuthenticated()){
            return service.generateToken(user.getUsername());
        }
        else {
            return "Fail";
        }
    }
}
