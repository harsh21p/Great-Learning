package com.greatlearning.ticketracker.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.ticketracker.model.Ticket;
import com.greatlearning.ticketracker.repository.TicketRepository;

@Service
public class TicketServicesImpl implements TicketServices{

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public void addOrUpadateTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(int id) {
		ticketRepository.delete(getTicketById(id));	
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepository.findById(id).get();
	}
	
	public List<Ticket> searchTicket(String s) {
		Ticket ticket = new Ticket();
		ticket.setTitle(s);
		ticket.setDescription(s);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.startsWith())
				.withMatcher("description", ExampleMatcher.GenericPropertyMatchers.startsWith())
				.withIgnorePaths("id","content","date");
		
		Example<Ticket> example = Example.of(ticket,exampleMatcher);
		return ticketRepository.findAll(example);
	}
	
	public String getTodaysDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");  
		LocalDateTime now = LocalDateTime.now();  
	  
		return dtf.format(now);
	}
	
}
