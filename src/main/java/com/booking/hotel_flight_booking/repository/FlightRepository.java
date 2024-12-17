package com.booking.hotel_flight_booking.repository;

import com.booking.hotel_flight_booking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}