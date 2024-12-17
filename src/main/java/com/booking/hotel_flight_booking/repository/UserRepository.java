package com.booking.hotel_flight_booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.hotel_flight_booking.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}