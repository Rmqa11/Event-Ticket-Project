package com.ticket.ticket.controller;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.Event;
import com.ticket.ticket.repository.EventRepository;
import com.ticket.ticket.service.Implemntation.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventServiceImpl;
    @Autowired
    private EventRepository eventRepository;

    // Handle HTTP GET requests to retrieve a list of all events
    @GetMapping("/allEvents")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Handle HTTP PUT requests to update an event by ID
    @PutMapping("/event/{eventId}")
    public String updateEvent(@PathVariable int eventId, @RequestBody Event updatedEvent) {
      return eventServiceImpl.updateEvent(eventId,updatedEvent);

    }


}
