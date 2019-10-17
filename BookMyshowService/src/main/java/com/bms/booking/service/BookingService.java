package com.bms.booking.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.booking.data.BookingDao;
import com.bms.booking.data.BookingRepository;
import com.bms.booking.msg.BookingMsgService;
import com.bms.payment.PaymentService;
import com.bms.theater.service.TheaterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class BookingService {

	private final BookingRepository bookingRepository;
	private final ToBookingTransformer toBookingTransformer;
	private final TheaterService theaterService;
	private final PaymentService paymentService;
	private final BookingMsgService bookingMsgService;
	@Autowired
	 public BookingService(BookingRepository bookingRepository,ToBookingTransformer toBookingTransformer,TheaterService theaterService,PaymentService paymentService,BookingMsgService bookingMsgService)
	 {
		 this.bookingRepository=bookingRepository;
		 this.toBookingTransformer=toBookingTransformer;
		 this.theaterService=theaterService;
		 this.paymentService=paymentService;
		 this.bookingMsgService=bookingMsgService;
	 }
	
	 public Booking findBookingByid(Integer bookingId)
	 {
		 Optional<BookingDao> bookingDao = bookingRepository.findById(bookingId);
		 log.info("Retrieving all  Tickets"+bookingDao.get().getBookingId());
		 return toBookingTransformer.transform(bookingDao.get());
	 }

	public Integer bookTicket(Booking bookingDeatils) {
		
		  //theaterService.lockTicket(movieid,theateid,seats)  Call Theater Service and lock the seats 
		 // theaterService.locakSeats(bookingDeatils.getTheaterId(),bookingDeatils.getMovieId(),bookingDeatils.getBookedSeats());
	  	  int paymentid=PaymentService.payment(bookingDeatils.getAmount()); //Return PaymentId
	  	  BookingDao bookingDao=toBookingTransformer.transform(bookingDeatils,paymentid);	  	  
	  	  BookingDao savedBooking = bookingRepository.save(bookingDao);
		  log.info("bookingid"+savedBooking.getBookingId());
		  //Triger the Notfication Event 
		  bookingMsgService.sendNotifcations(savedBooking);
		 return savedBooking.getBookingId();
	}
	
}
