package com.ticket.ticket.service.interfaces;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTicket();

    Ticket createTicket(Ticket ticket);

    String deleteTicket(int ticketId);
}
