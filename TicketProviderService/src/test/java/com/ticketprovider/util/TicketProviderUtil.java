package com.ticketprovider.util;

import java.nio.charset.Charset;
import java.util.Random;

import com.ticketprovider.data.TicketDao;
import com.ticketprovider.service.Ticket;
import com.ticketprovider.web.TicketView;

public class TicketProviderUtil {

	
	public static Ticket newRandomTickets() {
		return Ticket
				.builder()
				.movieId(randomIntger())
				.theaterId(randomIntger())
				.price(randomIntger())
				.numberOfTickets(randomIntger())
				.ticketConsumerType(randomString())
				.build();
	}
	public static TicketDao newRandomTicketDao() {
		return TicketDao
				.builder()
				.movieId(randomIntger())
				.theaterId(randomIntger())
				.price(randomIntger())
				.numberOfTickets(randomIntger())
				.ticketConsumerType(randomString())
				.build();
	}
	
	public static TicketView newRandomTicketViews() {
		return TicketView
				.builder()
				.movieId(randomIntger())
				.theaterId(randomIntger())
				.price(randomIntger())
				.numberOfTickets(randomIntger())
				.ticketConsumerType(randomString())
				.build();
	}
	
	
	
	
	
	 private static String randomString() {
		 byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));
		return generatedString;
	}

	public static Integer randomIntger()
	 {
	    Random rand = new Random(); 
		return rand.nextInt(1000);
	 }

	
	
	
}
