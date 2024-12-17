package com.booking.hotel_flight_booking.controller;

import com.booking.hotel_flight_booking.dto.BookingRequestDTO;
import com.booking.hotel_flight_booking.dto.UpdatePaymentStatusDTO;
import com.booking.hotel_flight_booking.model.Booking;
import com.booking.hotel_flight_booking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@Validated
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequest) {
        Booking booking = bookingService.createBooking(
                bookingRequest.getHotelId(),
                bookingRequest.getFlightId(),
                bookingRequest.getUserName()
        );
        return ResponseEntity.ok(booking);
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    // Update payment status
    @PutMapping("/{id}/payment-status")
    public ResponseEntity<Booking> updatePaymentStatus(
            @PathVariable Long bookingId,
            @Valid @RequestBody UpdatePaymentStatusDTO paymentStatusDTO) {
        Booking updatedBooking = bookingService.updatePaymentStatus(bookingId, paymentStatusDTO.getStatus());
        return ResponseEntity.ok(updatedBooking);
    }

    // Cancel a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking canceled successfully");
    }
}
