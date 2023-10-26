package com.ticket.ticket.service.Implemntation;

import com.ticket.ticket.entity.Ticket;
import com.ticket.ticket.repository.TicketRepository;
import com.ticket.ticket.service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }
    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    @Override
    public String deleteTicket(int ticketId) {
        if (ticketRepository.existsById(ticketId)) {
            ticketRepository.deleteById(ticketId);
            return "Ticket deleted Successfully";
        } else {
            return "Ticket not found";
        }
    }

    }


