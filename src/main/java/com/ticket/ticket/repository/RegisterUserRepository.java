package com.ticket.ticket.repository;

import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Integer> {
    RegisterUser findByUserId(int userId);
}
