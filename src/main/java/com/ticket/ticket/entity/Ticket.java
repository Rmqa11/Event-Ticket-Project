package com.ticket.ticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private double price;
    private String type;

    @ManyToOne
    @JoinColumn(name = "registerUser_id")
    private RegisterUser registerUser;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;


}
