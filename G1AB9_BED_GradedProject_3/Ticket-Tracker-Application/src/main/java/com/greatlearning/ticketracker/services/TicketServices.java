package com.greatlearning.ticketracker.services;

import java.util.List;

import com.greatlearning.ticketracker.model.Ticket;

public interface TicketServices {
	
	public List<Ticket> getAllTicket();
	public void addOrUpadateTicket(Ticket ticket);
	public void deleteTicket(int id);
	public Ticket getTicketById(int id);
	public List<Ticket> searchTicket(String s);
	public String getTodaysDate();

}
