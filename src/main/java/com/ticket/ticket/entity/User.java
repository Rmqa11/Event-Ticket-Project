package com.ticket.ticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    // This class represents a User entity, which is a base class for various user types.

    @Id
    private int userId;
    private String username;
    private String password;
    private String role;


}
