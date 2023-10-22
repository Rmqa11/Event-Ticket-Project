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
    private int ticketId;
    private String name;
    private double price;
    private String type;


    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;


}
