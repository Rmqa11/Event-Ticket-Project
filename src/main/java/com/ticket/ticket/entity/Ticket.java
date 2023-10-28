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
    // This class represents a Ticket entity, typically used to model tickets for events.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private double price;
    private String type;

    @ManyToOne
    @JoinColumn(name = "registerUser_id")
    private RegisterUser registerUser; // Represents the user who owns or has purchased the ticket.

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event; // Represents the event for which the ticket is issued.


}
