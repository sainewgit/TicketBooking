package com.ticketprovider.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ticketprovider.data.TicketDao;

@Component
public class ToTicketTransformer {

	public Ticket transform(TicketDao ticketDao) {
		return Ticket
				.builder()
				.ticketId(ticketDao.getTicketId())
				.movieId(ticketDao.getMovieId())
				.theaterId(ticketDao.getTheaterId())
				.numberOfTickets(ticketDao.getNumberOfTickets())
				.price(ticketDao.getPrice())
				.ticketConsumerType(ticketDao.getTicketConsumerType())
				.build();				
	}
	
	public TicketDao transformToTicketDao(Ticket ticket) {
		return TicketDao
				.builder()
				.movieId(ticket.getMovieId())
				.theaterId(ticket.getTheaterId())
				.numberOfTickets(ticket.getNumberOfTickets())
				.price(ticket.getPrice())
				.ticketConsumerType(ticket.getTicketConsumerType())
				.build();				
	}
}
