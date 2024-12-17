package com.booking.hotel_flight_booking.service;


import com.booking.hotel_flight_booking.exception.ResourceNotFoundException;
import com.booking.hotel_flight_booking.model.Flight;
import com.booking.hotel_flight_booking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Add a new flight
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Get a flight by ID
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
    }

    // Update a flight
    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = getFlightById(id);

        flight.setAirline(flightDetails.getAirline());
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setPrice(flightDetails.getPrice());
        flight.setAvailableSeats(flightDetails.getAvailableSeats());

        return flightRepository.save(flight);
    }

    // Delete a flight
    public void deleteFlight(Long id) {
        Flight flight = getFlightById(id);
        flightRepository.delete(flight);
    }
}
