package com.ticketprovider.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TicketView {

    private final Integer ticketId;	
    private final Integer movieId;
    private final Integer theaterId;	    
    private final Integer numberOfTickets;    
    private final Integer price;    
    private final String ticketConsumerType;
    
    // needed for JSON deserialiser
    @SuppressWarnings("unused")
	  private TicketView() { 
		  this(null, null,null,null,null,null); }
}
