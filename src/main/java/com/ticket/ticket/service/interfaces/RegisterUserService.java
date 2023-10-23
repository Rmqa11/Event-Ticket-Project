package com.ticket.ticket.service.interfaces;

import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.entity.User;

public interface RegisterUserService {
    User createUser(RegisterUser registerUser);
    RegisterUser getUserById(int uerId);

}
