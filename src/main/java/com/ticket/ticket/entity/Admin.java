package com.ticket.ticket.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Admin extends User {
    public Admin(int userId, String username, String password , String role) {
        super(userId, username, password,"Admin");
    }


}
