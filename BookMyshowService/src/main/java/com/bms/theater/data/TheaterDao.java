package com.bms.theater.data;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "theater")
@Builder
@Getter
@AllArgsConstructor
@Setter
public class TheaterDao {

	@Id
    @Column(name = "tid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer tid;
    
    @Column(name = "MovieId")
    private final Integer movieId;

    @Column(name = "TheaterId")
    private final Integer theaterId;
	
    @Column(name = "adressid")
    private final Integer adressid;
    
    @Column(name = "theaterName")
    private final String theaterName;
    
    @Column(name = "screen")
    private final Integer screen;
    
    @Column(name = "seats")
    private final Integer seats;
    
    
 // needed for JPA
	  @SuppressWarnings("unused")
	  private TheaterDao() { 
		  this(null, null,null,null,null,null,null); }
}
