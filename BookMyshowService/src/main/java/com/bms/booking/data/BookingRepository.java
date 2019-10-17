package com.bms.booking.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookingRepository extends JpaRepository<BookingDao, Integer>{

}
