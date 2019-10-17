package com.bms.booking.msg;

import org.springframework.stereotype.Service;

import com.bms.booking.data.BookingDao;

@Service
public class BookingMsgService {

	
	public void  sendNotifcations(BookingDao savedBooking)
	{
		//finduser(savedBooking.getUserId());//Get user mobile number and email 
		//Sendto smsquee(mobile,bookingid);
		//Sendto emailquee(@email,bookingid)
	}
}
