package com.keyin.controller;

import com.keyin.model.Flight;
import com.keyin.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/arriving/{airportId}")
    public List<Flight> getArrivingFlightsByAirportId(@PathVariable Long airportId) {
        return flightService.getArrivingFlightsByAirportId(airportId);
    }

    @GetMapping("/departing/{airportId}")
    public List<Flight> getDepartingFlightsByAirportId(@PathVariable Long airportId) {
        return flightService.getDepartingFlightsByAirportId(airportId);
    }

    @GetMapping("/filter/airline")
    public List<Flight> filterFlightsByAirline(@RequestParam String airlineName) {
        return flightService.filterFlightsByAirline(airlineName);
    }

    @GetMapping("/filter/gate")
    public List<Flight> filterFlightsByGate(@RequestParam String gate) {
        return flightService.filterFlightsByGate(gate);
    }
}