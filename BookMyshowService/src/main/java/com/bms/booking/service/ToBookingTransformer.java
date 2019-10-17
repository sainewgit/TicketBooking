package com.bms.booking.service;

import org.springframework.stereotype.Component;

import com.bms.booking.data.BookingDao;



@Component
public class ToBookingTransformer {

	public Booking transform(BookingDao bookingDao) {
		return Booking
				.builder()
				.bookingId(bookingDao.getBookingId())
				.movieId(bookingDao.getMovieId())
				.theaterId(bookingDao.getTheaterId())
				.userId(bookingDao.getUserId())
				.paymentId(bookingDao.getPaymentId())
				 .bookedSeats(bookingDao.getBookedSeats())
				 .booked_date(bookingDao.getBooked_date())
				 .movie_timing(bookingDao.getMovie_timing())
				 .amount(bookingDao.getAmount())
				 .build();
	}

	public BookingDao transform(Booking booking, int paymentid) {
		return BookingDao
				.builder()
				.movieId(booking.getMovieId())
				.theaterId(booking.getTheaterId())
				.userId(booking.getUserId())
				 .paymentId(paymentid)
				 .bookedSeats(booking.getBookedSeats())
		         .amount(booking.getAmount())
				 .build();
	}
	
}
