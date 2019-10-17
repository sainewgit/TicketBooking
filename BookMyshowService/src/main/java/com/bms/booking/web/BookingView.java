package com.bms.booking.web;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class BookingView {

	 private final Integer bookingId;
	   private final Integer movieId;	  
	    private final Integer theaterId;
	    private final Integer userId;	 
	    private final Integer paymentId;    
	    private final Integer bookedSeats;	    
	    private final Date booked_date;	    
	    private final Time movie_timing;
	    private final Integer amount;
	
	// needed for JSON deserialiser
   
    @SuppressWarnings("unused")
	  private BookingView() { 
		  this(null, null,null,null,null,null,null,null,null); }
}
