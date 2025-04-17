package com.keyin.controller;

import com.keyin.dto.AircraftDTO;
import com.keyin.model.Aircraft;
import com.keyin.service.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {
    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<AircraftDTO> getAllAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public AircraftDTO getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping
    public Aircraft addAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.addAircraft(aircraft);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(id, aircraft);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }
}