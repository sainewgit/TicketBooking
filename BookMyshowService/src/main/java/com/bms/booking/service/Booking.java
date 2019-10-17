package com.bms.booking.service;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;


@Builder
@Getter
@AllArgsConstructor
@Setter
public class Booking {
	
	  private final Integer bookingId;
	    private final Integer movieId;	  
	    private final Integer theaterId;
	    private final Integer userId;	 
	    private final Integer paymentId;    
	    private final Integer bookedSeats;	    
	    private final Date booked_date;	    
	    private final Time movie_timing;
	    private final Integer amount;
}
