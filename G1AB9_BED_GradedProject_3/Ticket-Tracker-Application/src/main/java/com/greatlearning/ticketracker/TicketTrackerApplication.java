package com.greatlearning.ticketracker;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.ticketracker.model.Ticket;
import com.greatlearning.ticketracker.services.TicketServicesImpl;

import lombok.extern.java.Log;

@SpringBootApplication
public class TicketTrackerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
	}
	
	@Autowired
	TicketServicesImpl ticketServicesImpl;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.print("Starting...");

		
	}

}
