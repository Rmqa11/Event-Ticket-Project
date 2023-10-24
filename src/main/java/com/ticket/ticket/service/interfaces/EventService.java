package com.ticket.ticket.service.interfaces;

import com.ticket.ticket.entity.Event;
import org.springframework.web.bind.annotation.RequestBody;

public interface EventService {
    String updateEvent(int eventId, Event updatedEvent );
}
