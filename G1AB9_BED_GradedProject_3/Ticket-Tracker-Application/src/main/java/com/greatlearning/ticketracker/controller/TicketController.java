package com.greatlearning.ticketracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticketracker.model.Ticket;
import com.greatlearning.ticketracker.services.TicketServices;

@Controller
public class TicketController {

	@Autowired
	TicketServices service;
	
	@GetMapping("/tickets")
	public String getAllTickets(Model model) {
		List<Ticket> tickets = service.getAllTicket();
		model.addAttribute("tickets",tickets);
		return "ticket";
	}
	
	@PostMapping("/tickets")
	public String addTicket(@ModelAttribute(name = "ticket") Ticket ticket) {
		ticket.setDate(service.getTodaysDate());	
		service.addOrUpadateTicket(ticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/new")
	public String addNewTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}
	

	@GetMapping("/tickets/delete/{id}")
	public String deleteTicketById(@PathVariable("id") Integer id) {
		service.deleteTicket(id);
		return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/edit/{id}")
	public String editTicket(Model model,@PathVariable("id") Integer id) {
		Ticket ticket = service.getTicketById(id);
		model.addAttribute("ticket",ticket);
		return "edit_ticket";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute(name = "ticket") Ticket ticket,@PathVariable("id") Integer id) {
		Ticket newTicket = service.getTicketById(id);
		if(ticket.getId() == newTicket.getId()) {
			newTicket.setTitle(ticket.getTitle());
			newTicket.setDescription(ticket.getDescription());
			newTicket.setContent(ticket.getContent());
			newTicket.setDate(ticket.getDate());
		}
		service.addOrUpadateTicket(newTicket);
		return "redirect:/tickets";
	}
	

	@GetMapping("/tickets/view/{id}")
	public String getView(Model model,@PathVariable("id") Integer id) {
		Ticket ticket = service.getTicketById(id);
		model.addAttribute("ticket",ticket);
		return "view_ticket";
	}
	
	@RequestMapping(value="/tickets/search", method=RequestMethod.POST)
	public String getSearchResults(Model model,@RequestParam("search_text") String search) {
		List<Ticket> ticket = service.searchTicket(search);
		model.addAttribute("value", search);
		model.addAttribute("tickets",ticket);
		return "ticket";
	}
	
}
