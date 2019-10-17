 package com.bms.booking.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.booking.service.BookingService;





@RestController
public class BookingController {

	private final BookingService bookingService;
	private final ToBookingViewTransformer toBookingViewTransformer;
	
	@Autowired
	 public BookingController(BookingService bookingService,ToBookingViewTransformer toBookingViewTransformer)
	 {
		 this.bookingService=bookingService;
		 this.toBookingViewTransformer=toBookingViewTransformer;
	 }
	
	 @GetMapping(value = "/booking/{bookingId}")
	  public BookingView findBooking(@PathVariable Integer bookingId) {
		return toBookingViewTransformer.transform(bookingService.findBookingByid(bookingId));
	  }
	 
	 @PostMapping(value = "/booking")
	  public Integer bookTicket(@RequestBody BookingView bookingView) {
	    return  bookingService.bookTicket(toBookingViewTransformer.totransformBooking(bookingView));
	 }
	
}
