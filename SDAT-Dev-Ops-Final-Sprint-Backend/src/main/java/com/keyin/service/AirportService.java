package com.keyin.service;

import com.keyin.model.Airport;
import com.keyin.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    // Get all airports in a specific city
    public List<Airport> getAirportsByCityId(Long cityId) {
        return airportRepository.findAirportsByCityId(cityId);
    }

    // Get all airports used by passengers (custom logic can be added later)
    public List<Airport> getAirportsUsedByPassengers() {
        // Placeholder for future implementation
        return airportRepository.findAll();
    }
}