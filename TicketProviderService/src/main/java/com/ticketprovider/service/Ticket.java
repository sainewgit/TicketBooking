package com.ticketprovider.service;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Ticket {

	    private final Integer ticketId;	
	    private final Integer movieId;
	    private final Integer theaterId;	    
	    private final Integer numberOfTickets;    
	    private final Integer price;    
	    private final String ticketConsumerType;
	    
}
