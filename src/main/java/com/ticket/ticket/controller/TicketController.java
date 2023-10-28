package com.ticket.ticket.controller;

import com.ticket.ticket.entity.Ticket;
import com.ticket.ticket.repository.TicketRepository;
import com.ticket.ticket.service.Implemntation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketServiceImpl ticketServiceImpl;

    // Handle HTTP GET requests to retrieve a list of all tickets
    @GetMapping("/ticket")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Handle HTTP POST requests to create a new ticket
    @PostMapping("/create/ticket")
    public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) {
    try {
        ticketServiceImpl.createTicket(ticket);
        String message = "Ticket Added Successfully";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    } catch (Exception e) {
        String errorMessage = "Ticket Not Added successfully" + e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
   }

    // Handle HTTP DELETE requests to delete a ticket by its ID
    @DeleteMapping("/ticket/delete/{ticketId}")
    public String deleteTicket(@PathVariable int ticketId) {
        try {
            ticketRepository.deleteById(ticketId);
            return "Ticket deleted successfully";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found with ID: " + ticketId);
        }
    }


}
