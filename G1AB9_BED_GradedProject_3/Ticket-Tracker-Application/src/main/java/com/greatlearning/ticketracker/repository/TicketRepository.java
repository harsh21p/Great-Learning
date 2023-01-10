package com.greatlearning.ticketracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.ticketracker.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
