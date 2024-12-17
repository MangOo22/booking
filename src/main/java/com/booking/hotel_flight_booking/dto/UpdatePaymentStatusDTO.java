package com.booking.hotel_flight_booking.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdatePaymentStatusDTO {

    @NotBlank(message = "Payment status is required")
    @Pattern(regexp = "PAID|PENDING", message = "Payment status must be either PAID or PENDING")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
