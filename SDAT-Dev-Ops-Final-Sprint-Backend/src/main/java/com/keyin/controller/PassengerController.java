package com.keyin.controller;

import com.keyin.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    // Get all aircraft a passenger has traveled on
    @GetMapping("/{passengerId}/aircraft")
    public List<String> getAircraftByPassengerId(@PathVariable Long passengerId) {
        return passengerService.getAircraftByPassengerId(passengerId);
    }
}