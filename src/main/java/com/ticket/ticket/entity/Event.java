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
    @Id
    private int eventId;
    private String title;
    private Date date;
    private String location;
    private String description;

    @Enumerated(EnumType.STRING)
    private EventType eventType;


}
