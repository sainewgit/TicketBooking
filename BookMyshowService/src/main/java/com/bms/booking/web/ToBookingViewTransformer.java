package com.bms.booking.web;


import org.springframework.stereotype.Component;

import com.bms.booking.service.Booking;

@Component
public class ToBookingViewTransformer {

	public BookingView transform(Booking booking) {
		return BookingView
				.builder()
				.bookingId(booking.getBookingId())
				.movieId(booking.getMovieId())
				.theaterId(booking.getTheaterId())
				.userId(booking.getUserId())
				.paymentId(booking.getPaymentId())
				 .bookedSeats(booking.getBookedSeats())
				 .booked_date(booking.getBooked_date())
				 .movie_timing(booking.getMovie_timing())
				 .amount(booking.getAmount())
				 .build();
	}
	
	
	public Booking totransformBooking(BookingView bookingView) {
		return Booking
				.builder()
				.movieId(bookingView.getMovieId())
				.theaterId(bookingView.getTheaterId())
				.userId(bookingView.getUserId())
				 .bookedSeats(bookingView.getBookedSeats())
				 .amount(bookingView.getAmount())
				 .build();
	}
	
}
