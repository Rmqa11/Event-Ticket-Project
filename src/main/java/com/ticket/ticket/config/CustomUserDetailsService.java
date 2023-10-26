package com.ticket.ticket.config;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.repository.AdminRepository;
import com.ticket.ticket.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return new CustomUserDetails(admin);
        }

        RegisterUser registerUser = registerUserRepository.findByUsername(username);
        if (registerUser != null) {
            return new CustomUserDetails(registerUser);
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
