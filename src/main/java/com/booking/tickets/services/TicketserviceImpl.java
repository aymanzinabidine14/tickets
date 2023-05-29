package com.booking.tickets.services;

import com.booking.tickets.models.Ticket;
import com.booking.tickets.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketserviceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;
    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getAlltickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Page<Ticket> getAllticketsByPage(int page, int size) {
          return ticketRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);

    }

    @Override
    public void deleteAlltickets() {
        ticketRepository.deleteAll();

    }

}
