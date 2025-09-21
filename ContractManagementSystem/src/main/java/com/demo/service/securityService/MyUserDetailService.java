
package com.demo.service.securityService;

import com.demo.DTO.securityModel.User;
import com.demo.DTO.securityModel.UserPrincipal;
import com.demo.repository.securityRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=repo.findByUsername(username);
        if (user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException(("User Not Found"));
        }
        return new UserPrincipal(user);
    }
}
