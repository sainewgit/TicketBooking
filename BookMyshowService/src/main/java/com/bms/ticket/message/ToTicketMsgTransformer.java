package com.bms.ticket.message;

import org.springframework.stereotype.Component;

import com.bms.ticket.data.TicketDao;

@Component
public class ToTicketMsgTransformer {

	public TicketDao transfrom(TicketMsg ticketMsg)
	{
		return TicketDao.builder()				       
				         .ticketId(ticketMsg.getTicketId())
				         .movieId(ticketMsg.getMovieId())
				         .theaterId(ticketMsg.getTheaterId())
				         .numberOfTickets(ticketMsg.getNumberOfTickets())
				         .price(ticketMsg.getPrice())
				         .build();
	}
	
}
