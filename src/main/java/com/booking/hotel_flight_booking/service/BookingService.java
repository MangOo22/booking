package com.booking.hotel_flight_booking.service;


import com.booking.hotel_flight_booking.exception.BadRequestException;
import com.booking.hotel_flight_booking.exception.ResourceNotFoundException;
import com.booking.hotel_flight_booking.model.Booking;
import com.booking.hotel_flight_booking.model.Flight;
import com.booking.hotel_flight_booking.model.Hotel;
import com.booking.hotel_flight_booking.repository.BookingRepository;
import com.booking.hotel_flight_booking.repository.FlightRepository;
import com.booking.hotel_flight_booking.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private FlightRepository flightRepository;

    // Create a booking
    public Booking createBooking(Long hotelId, Long flightId, String userName) {
        Booking booking = new Booking();
        booking.setUserName(userName);
        booking.setBookingDate(LocalDateTime.now());

        double totalPrice = 0;

        // If hotelId is provided
        if (hotelId != null) {
            Hotel hotel = hotelRepository.findById(hotelId)
                    .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + hotelId));
            booking.setHotel(hotel);
            totalPrice += hotel.getPricePerNight();
        }

        // If flightId is provided
        if (flightId != null) {
            Flight flight = flightRepository.findById(flightId)
                    .orElseThrow(() -> new ResourceNotFoundException("Flight not found with ID: " + flightId));
            booking.setFlight(flight);
            totalPrice += flight.getPrice();
        }

        booking.setTotalPrice(totalPrice);
        booking.setPaymentStatus("PENDING");

        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Update payment status
    public Booking updatePaymentStatus(Long bookingId, String status) {
        if (!"PAID".equalsIgnoreCase(status) && !"PENDING".equalsIgnoreCase(status)) {
            throw new BadRequestException("Invalid payment status: " + status);
        }

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

        booking.setPaymentStatus(status);
        return bookingRepository.save(booking);
    }
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));
    }
    // Cancel a booking
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        bookingRepository.delete(booking);
    }
}
