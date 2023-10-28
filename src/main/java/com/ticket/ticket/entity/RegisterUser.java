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
    // This class represents a specific type of user, a "RegisterUser," which extends the User class.

    private String email;

    public RegisterUser(int userId, String username, String password, String email) {
        super(userId, username, password, "RegisterUser");
        this.email = email; // Set the email property for the RegisterUser.
    }
}
