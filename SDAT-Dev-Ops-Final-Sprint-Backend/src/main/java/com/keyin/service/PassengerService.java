package com.keyin.service;

import com.keyin.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<String> getAircraftByPassengerId(Long passengerId) {
        return passengerRepository.findAircraftByPassengerId(passengerId);
    }
}