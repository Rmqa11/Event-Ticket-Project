package com.ticket.ticket.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser extends User {
    private String email;

    public RegisterUser(int userId, String username, String password, String email) {
        super(userId, username, password, "RegisterUser");
        this.email = email;
    }
}
