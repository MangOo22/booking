package com.booking.hotel_flight_booking.dto;


import jakarta.validation.constraints.NotBlank;


public class BookingRequestDTO {

    @NotBlank(message = "User name is required")
    private String userName;

    private Long hotelId;

    private Long flightId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
