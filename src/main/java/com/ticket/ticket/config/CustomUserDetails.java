package com.ticket.ticket.config;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {
    public CustomUserDetails(Admin admin) {
        super(admin);
    }

    public CustomUserDetails(RegisterUser registerUser) {
        super(registerUser);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(getRole()));
        return authorities;
    }
}
