package com.ticketprovider;

import static com.ticketprovider.util.TicketProviderUtil.newRandomTicketDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketprovider.data.TicketDao;
import com.ticketprovider.data.TicketRepository;
import com.ticketprovider.web.TicketView;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


import java.util.Arrays;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;

//This is end to end Test  Controller ==>Service==>Repositry and Run SpringBoot application 

public class TicketProviderSingleServiceApplicationTests extends AbstractSingleServiceTest {

	@Autowired
	private  TicketRepository ticketRepository;
	
	 @Test
	 public void listTickets_success() {
		 
		//given
	  
	   int exceptedTicketDaoCount = (int) (ticketRepository.count()+1);
		TicketDao ticketDao=newRandomTicketDao();
		ticketRepository.save(ticketDao);
		
		TicketView exceptTicketView=TicketView
		.builder()
		.movieId(ticketDao.getMovieId())
		.theaterId(ticketDao.getTheaterId())
		.price(ticketDao.getPrice())
		.numberOfTickets(ticketDao.getNumberOfTickets())
		.ticketConsumerType(ticketDao.getTicketConsumerType())
		.build();
		
		 //when
        Response response = given().get("/tickets");
		TicketView[] ticketViews=response.getBody().as(TicketView[].class);
		
		//then		
		assertThat(response.statusCode(), is(200));
		assertThat(ticketViews.length, is(exceptedTicketDaoCount));
		ticketRepository.delete(ticketDao);
			
	    } 

}
