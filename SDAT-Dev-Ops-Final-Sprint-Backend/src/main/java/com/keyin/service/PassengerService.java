package com.keyin.service;

import com.keyin.dto.PassengerDTO;
import com.keyin.model.Passenger;
import com.keyin.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<PassengerDTO> getAllPassengers() {
        return passengerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PassengerDTO getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        return convertToDTO(passenger);
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger existingPassenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        existingPassenger.setFirstName(passenger.getFirstName());
        existingPassenger.setLastName(passenger.getLastName());
        existingPassenger.setPhoneNumber(passenger.getPhoneNumber());
        return passengerRepository.save(existingPassenger);
    }

    public void deletePassenger(Long id) {
        if (!passengerRepository.existsById(id)) {
            throw new RuntimeException("Passenger not found");
        }
        passengerRepository.deleteById(id);
    }

    private PassengerDTO convertToDTO(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(passenger.getId());
        passengerDTO.setFirstName(passenger.getFirstName());
        passengerDTO.setLastName(passenger.getLastName());
        passengerDTO.setPhoneNumber(passenger.getPhoneNumber());
        return passengerDTO;
    }
}