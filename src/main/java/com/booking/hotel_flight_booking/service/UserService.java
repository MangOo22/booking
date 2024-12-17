package com.booking.hotel_flight_booking.service;

import com.booking.hotel_flight_booking.exception.BadRequestException;
import com.booking.hotel_flight_booking.exception.ResourceNotFoundException;
import com.booking.hotel_flight_booking.model.User;
import com.booking.hotel_flight_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("User already existes");
        }
        //  Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User userDetails) {
        User  user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
}










