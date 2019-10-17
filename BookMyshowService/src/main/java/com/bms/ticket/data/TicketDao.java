package com.bms.ticket.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "ticket")
@Builder
@Getter
@AllArgsConstructor
public class TicketDao {

	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private final Integer id;
	    
	    
	    @Column(name = "TicketId")
	    private final Integer ticketId;
	    
	    @Column(name = "MovieId")
	    private final Integer movieId;

	    @Column(name = "TheaterId")
	    private final Integer theaterId;
	    
	    @Column(name = "NumberOfTickets")
	    private final Integer numberOfTickets;
	    
	    @Column(name = "Price")
	    private final Integer price;
	    
	    // needed for JPA
		  @SuppressWarnings("unused")
		  private TicketDao() { 
			  this(null, null,null,null,null,null); 
			  }  
}    