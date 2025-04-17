package com.keyin.service;

import com.keyin.model.Flight;
import com.keyin.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getArrivingFlightsByAirportId(Long airportId) {
        return flightRepository.findArrivingFlightsByAirportId(airportId);
    }

    public List<Flight> getDepartingFlightsByAirportId(Long airportId) {
        return flightRepository.findDepartingFlightsByAirportId(airportId);
    }

    public List<Flight> filterFlightsByAirline(String airlineName) {
        return flightRepository.findFlightsByAirline(airlineName);
    }

    public List<Flight> filterFlightsByGate(String gate) {
        return flightRepository.findFlightsByGate(gate);
    }
}