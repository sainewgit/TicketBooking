package com.ticketprovider.message;

import org.springframework.stereotype.Component;

import com.ticketprovider.data.TicketDao;


@Component
public class ToTicketMsgTransformer {

	public TicketMsg transform(TicketDao ticketDao) {
		return TicketMsg
				.builder()
				.ticketId(ticketDao.getTicketId())
				.movieId(ticketDao.getMovieId())
				.theaterId(ticketDao.getTheaterId())
				.numberOfTickets(ticketDao.getNumberOfTickets())
				.price(ticketDao.getPrice())
				//.ticketConsumerType(ticketDao.getTicketConsumerType())
				.build();				
	}
}
