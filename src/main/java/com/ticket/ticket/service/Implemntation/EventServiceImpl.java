package com.ticket.ticket.service.Implemntation;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.Event;
import com.ticket.ticket.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class EventServiceImpl {
    @Autowired
    private EventRepository eventRepository;

    public String updateEvent(@PathVariable("eventId") int eventId, @RequestBody Event updatedEvent) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setEventType(updatedEvent.getEventType());
            event.setLocation(updatedEvent.getLocation());
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            eventRepository.save(event);
            return "Event Details Updated";
        } else {
            return "Event with ID " + eventId + " not found";
        }
    }




}
