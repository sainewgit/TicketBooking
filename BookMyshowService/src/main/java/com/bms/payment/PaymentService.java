package com.bms.payment;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	
	
	public static int payment(Integer amount) {
		 Random rand = new Random(); 
		return rand.nextInt(1000);

		
	}

	
	
}
