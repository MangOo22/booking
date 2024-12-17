package com.booking.hotel_flight_booking.repository;

import com.booking.hotel_flight_booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
