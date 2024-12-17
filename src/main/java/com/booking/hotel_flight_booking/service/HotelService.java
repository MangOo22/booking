package com.booking.hotel_flight_booking.service;

import com.booking.hotel_flight_booking.exception.BadRequestException;
import com.booking.hotel_flight_booking.exception.ResourceNotFoundException;
import com.booking.hotel_flight_booking.model.Hotel;
import com.booking.hotel_flight_booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
    }

    public Hotel updateHotel(Long id, Hotel hotelDetails) {
        Hotel hotel = getHotelById(id);
        hotel.setName(hotelDetails.getName());
        hotel.setAddress(hotelDetails.getAddress());
        hotel.setTotalRooms(hotelDetails.getTotalRooms());
        hotel.setRating(hotelDetails.getRating());
        hotel.setPricePerNight(hotelDetails.getPricePerNight());

        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        Hotel hotel = getHotelById(id);
        hotelRepository.delete(hotel);
    }
}