package com.ticketprovider.message;

import org.springframework.stereotype.Service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BookMyShowSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${bookmyshow.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${bookmyshow.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(TicketMsg ticketMsg) {
		amqpTemplate.convertAndSend(exchange, routingkey, ticketMsg);
		log.info("Send msg = " + ticketMsg);
	    
	}
}
