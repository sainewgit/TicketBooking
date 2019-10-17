package com.ticketprovider.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Entity
@Table(name = "ticket")
@Builder
@Getter
@AllArgsConstructor
public class TicketDao {

	    @Id
	    @Column(name = "TicketId")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private final Integer ticketId;
	    
	    @Column(name = "MovieId")
	    private final Integer movieId;

	    @Column(name = "TheaterId")
	    private final Integer theaterId;
	    
	    @Column(name = "NumberOfTickets")
	    private final Integer numberOfTickets;
	    
	    @Column(name = "Price")
	    private final Integer price;
	    
	    @Column(name = "TicketConsumerType")
	    private final String ticketConsumerType;

	    
	  // needed for JPA
	  @SuppressWarnings("unused")
	  private TicketDao() { 
		  this(null, null,null,null,null,null); }
		
}
