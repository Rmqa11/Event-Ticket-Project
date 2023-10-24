package com.ticket.ticket.service.interfaces;

import com.ticket.ticket.entity.Event;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    String updateEvent(int eventId, Event updatedEvent );
    List<Event> searchByEventType(String eventType);

}
