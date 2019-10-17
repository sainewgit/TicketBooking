package com.ticketprovider.web;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.ticketprovider.service.Ticket;
import com.ticketprovider.service.TicketService;
import static com.ticketprovider.util.TicketProviderUtil.newRandomTickets;
import static com.ticketprovider.util.TicketProviderUtil.newRandomTicketViews;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TicketControllerTest {

	@Mock
	private TicketService mockedTicketService;
	
	@Mock
	private ToTicketViewTransformer mockedToTicketViewTransformer;
	
	@After
    public void afterTest() {
        reset(mockedTicketService);
        reset(mockedToTicketViewTransformer);
    }
	
	@Test
    public void findAllTickets_success() {
	
		//given
		TicketController ticketController=new TicketController(mockedTicketService, mockedToTicketViewTransformer);
		
		Ticket ticket1=newRandomTickets();
		Ticket ticket2=newRandomTickets();
		List<Ticket> expectedTickets = Arrays.asList(ticket1, ticket2);
		
		TicketView expectedTicketView1=newRandomTicketViews();
		TicketView expectedTicketView2=newRandomTicketViews();
		
		List<TicketView> expectedTicketvViews = Arrays.asList(expectedTicketView1, expectedTicketView2);
		
		given(mockedTicketService.findAllTickets()).willReturn(expectedTickets);
		
		 given(mockedToTicketViewTransformer.transform(ticket1)).willReturn(expectedTicketView1);
	     given(mockedToTicketViewTransformer.transform(ticket2)).willReturn(expectedTicketView2);
	     
	   //when
	        List<TicketView> allTicktes = ticketController.findAllTickets();
	   
	     //then
	        assertThat(allTicktes, sameBeanAs((expectedTicketvViews)));
	}

	
	
}
