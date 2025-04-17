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

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping
    public Airport addAirport(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}