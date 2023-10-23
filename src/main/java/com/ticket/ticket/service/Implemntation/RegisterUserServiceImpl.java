package com.ticket.ticket.service.Implemntation;

import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.entity.User;
import com.ticket.ticket.repository.RegisterUserRepository;
import com.ticket.ticket.service.interfaces.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
    @Autowired
    private RegisterUserRepository registerUserRepository;
    @Override
    public RegisterUser createUser(RegisterUser registerUser) {
        return registerUserRepository.save(registerUser);
    }

    @Override
    public RegisterUser getUserById(int userId) {
        RegisterUser registerUser = registerUserRepository.findByUserId(userId);
        if (registerUser == null) {
            throw new RuntimeException("User not found");
        }
        return registerUser;
    }
}
