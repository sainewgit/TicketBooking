package com.bms.ticket.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.ticket.data.TicketDao;
import com.bms.ticket.data.TicketRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class TicketServiceMsg {

	@Autowired
	TicketRepository ticketRepository;
	
	
	public void saveTicketMsg(TicketDao ticketDao)
	{
		ticketRepository.save(ticketDao);
	}
}
