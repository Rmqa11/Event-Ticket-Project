package com.ticket.ticket.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Admin extends User {
    // This class represents an Admin entity which extends the User class.

    // Constructor for creating an Admin with user properties
    public Admin(int userId, String username, String password , String role) {
        super(userId, username, password,"Admin");
    }


}
