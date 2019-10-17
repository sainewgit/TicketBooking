package com.ticketprovider.service;

import static org.mockito.Mockito.reset;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


import static org.mockito.BDDMockito.given;

import com.ticketprovider.data.TicketDao;
import com.ticketprovider.data.TicketRepository;
import com.ticketprovider.web.TicketController;
import com.ticketprovider.web.TicketView;

import static java.util.Collections.emptyList;
import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static com.ticketprovider.util.TicketProviderUtil.newRandomTickets;
import static com.ticketprovider.util.TicketProviderUtil.newRandomTicketDao;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {
	
	@Mock
	private  TicketRepository mockTicketRepository;
	
	@Mock
	private  ToTicketTransformer mockToTicketTransformer;
	
	@InjectMocks
	private  TicketService ticketService;
	
	
	@After
    public void afterTest() {
        reset(mockTicketRepository);
        reset(mockToTicketTransformer);
    }
	
	
	@Test
    public void findAllTickets_returnsEmptyListWhenThereAreNoTickets() {
	
		//given
		given(mockTicketRepository.findAll()).willReturn(emptyList());
		
		// when
        List<Ticket> allTickets = ticketService.findAllTickets();        
        
        // then
        assertThat(allTickets, sameBeanAs(emptyList()));
        
	}
	
	@Test
    public void findAllTickets_success() {
		
		//given
		TicketDao ticketDao1=newRandomTicketDao();
		TicketDao ticketDao2=newRandomTicketDao();
		List<TicketDao> expectedTicketDaos = Arrays.asList(ticketDao1, ticketDao2);
		
		Ticket expectedTicket1=newRandomTickets();
		Ticket expectedTicket2=newRandomTickets();
		List<Ticket> expectedTickets = Arrays.asList(expectedTicket1, expectedTicket2);
		
		given(mockTicketRepository.findAll()).willReturn(expectedTicketDaos);
		
		 given(mockToTicketTransformer.transform(ticketDao1)).willReturn(expectedTicket1);
	     given(mockToTicketTransformer.transform(ticketDao2)).willReturn(expectedTicket2);
	     
	   //when
	        List<Ticket> allTicktes = ticketService.findAllTickets();
	   
	     //then
	        assertThat(allTicktes, sameBeanAs((expectedTickets)));
	}
}
