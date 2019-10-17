package com.bms.booking.data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Builder
@Getter
@AllArgsConstructor
@Setter
public class BookingDao {

	@Id
    @Column(name = "bookingId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer bookingId;
    
    @Column(name = "MovieId")
    private final Integer movieId;

    @Column(name = "TheaterId")
    private final Integer theaterId;
    
    @Column(name = "userId")
    private final Integer userId;
    
    @Column(name = "PaymentId")
    private final Integer paymentId;
    
    @Column(name = "bookedSeats")
    private final Integer bookedSeats;
    
    @CreatedDate
    @Column(name = "booked_date")
    private final Date booked_date;
    
    @CreationTimestamp
    @Column(name = "movie_timing")
    private final Time movie_timing;
    
    @Column(name = "amount")
    private final Integer amount;
    
 // needed for JPA
 	  @SuppressWarnings("unused")
 	  private BookingDao() { 
 		  this(null, null,null,null,null,null,null,null,null); }
    
    
}
