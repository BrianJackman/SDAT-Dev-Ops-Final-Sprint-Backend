package com.keyin.service;

import com.keyin.model.Airport;
import com.keyin.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final AirportRepository airportRepository;

    public CityService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAirportsByCityId(Long cityId) {
        return airportRepository.findAirportsByCityId(cityId);
    }
}