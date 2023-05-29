package com.booking.tickets.services;

import com.booking.tickets.models.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    Ticket saveTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    Ticket getTicket(Long id);

    List<Ticket> getAlltickets();

    Page<Ticket> getAllticketsByPage(int page, int size);

    void deleteTicketById(Long id);

    void deleteAlltickets();


}
