package com.keyin.controller;

import com.keyin.model.Airport;
import com.keyin.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/city/{cityId}")
    public List<Airport> getAirportsByCityId(@PathVariable Long cityId) {
        return airportService.getAirportsByCityId(cityId);
    }
}