package com.ticketprovider.message;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = TicketMsg.class)
@Builder
@Getter
@AllArgsConstructor
public class TicketMsg {
	
	    private final Integer ticketId;	
	    private final Integer movieId;
	    private final Integer theaterId;	    
	    private final Integer numberOfTickets;    
	    private final Integer price;    
	    //private final String ticketConsumerType;
	 // needed for JSON deserialiser
	    @SuppressWarnings("unused")
		  private TicketMsg() { 
			  this(null, null,null,null,null); }
}
