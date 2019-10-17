package com.ticketprovider.web;

import org.springframework.stereotype.Component;

import com.ticketprovider.data.TicketDao;
import com.ticketprovider.service.Ticket;

@Component
public class ToTicketViewTransformer {

	public TicketView transform(Ticket ticket) {
		return TicketView
				.builder()
				.ticketId(ticket.getTicketId())
				.movieId(ticket.getMovieId())
				.theaterId(ticket.getTheaterId())
				.numberOfTickets(ticket.getNumberOfTickets())
				.price(ticket.getPrice())
				.ticketConsumerType(ticket.getTicketConsumerType())
				.build();				
	}
	
	public Ticket transformToTicket(TicketView ticketView) {
		return Ticket
				.builder()
				.movieId(ticketView.getMovieId())
				.theaterId(ticketView.getTheaterId())
				.numberOfTickets(ticketView.getNumberOfTickets())
				.price(ticketView.getPrice())
				.ticketConsumerType(ticketView.getTicketConsumerType())
				.build();
	}
	
}
