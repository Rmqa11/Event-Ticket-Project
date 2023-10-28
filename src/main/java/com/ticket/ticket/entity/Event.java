package com.ticket.ticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    // This class represents an Event entity, typically used to model events in an application.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;
    private String title;
    private Date date;
    private String location;
    private String description;

    @Enumerated(EnumType.STRING)
    private EventType eventType; // Type of the event


    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin; // Represents the admin associated with the event

}
