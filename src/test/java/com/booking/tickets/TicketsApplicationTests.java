

package com.booking.tickets;

import com.booking.tickets.models.Ticket;
import com.booking.tickets.repositories.TicketRepository;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketsApplicationTests {
	@Autowired
	TicketRepository ticketRepository;

	TicketsApplicationTests() {
	}



	@Test
	public void Testupdateticket() {
		Ticket ticket = (Ticket)this.ticketRepository.findById(3L).get();
		ticket.setPrixTicket(50.0);
		this.ticketRepository.save(ticket);
	}

	@Test
	public void TestfindByid() {
		Ticket ticket = (Ticket)this.ticketRepository.findById(1L).get();
		System.out.println(ticket);
	}

	@Test
	public void TestfindAll() {
		List<Ticket> tickets = this.ticketRepository.findAll();
		PrintStream var10001 = System.out;
		Objects.requireNonNull(var10001);
		tickets.forEach(var10001::println);
	}

	@Test
	public void TestdeleteByid() {
		this.ticketRepository.deleteById(1L);
	}

	@Test
	public void TestdeleteAllticket() {
		this.ticketRepository.deleteAll();
	}
}
