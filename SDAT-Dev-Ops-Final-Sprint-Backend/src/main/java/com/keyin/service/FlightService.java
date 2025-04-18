// Author: Brian Jackman
// Date: 2025/04/18
// Project: SDAT & Dev Ops Final Sprint


package com.keyin.service;

import com.keyin.dto.FlightDTO;
import com.keyin.model.Flight;
import com.keyin.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        return convertToDTO(flight);
    }

    public Flight addFlight(Flight flight) {
        validateFlightTimes(flight);
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setDepartureTime(flight.getDepartureTime());
        existingFlight.setArrivalTime(flight.getArrivalTime());
        existingFlight.setGate(flight.getGate());
        validateFlightTimes(existingFlight);
        return flightRepository.save(existingFlight);
    }

    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new RuntimeException("Flight not found");
        }
        flightRepository.deleteById(id);
    }

    private void validateFlightTimes(Flight flight) {
        if (flight.getDepartureTime().isAfter(flight.getArrivalTime())) {
            throw new RuntimeException("Departure time must be before arrival time");
        }
    }

    private FlightDTO convertToDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flight.getId());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setDepartureTime(flight.getDepartureTime().format(FORMATTER));
        flightDTO.setArrivalTime(flight.getArrivalTime().format(FORMATTER));
        flightDTO.setGate(flight.getGate());
        return flightDTO;
    }

  
    public Flight convertToEntity(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setId(flightDTO.getId());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setDepartureTime(LocalDateTime.parse(flightDTO.getDepartureTime(), FORMATTER));
        flight.setArrivalTime(LocalDateTime.parse(flightDTO.getArrivalTime(), FORMATTER));
        flight.setGate(flightDTO.getGate());
        return flight;
    }
}