package com.keyin.controller;

import com.keyin.model.Airport;
import com.keyin.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{cityId}/airports")
    public List<Airport> getAirportsByCityId(@PathVariable Long cityId) {
        return cityService.getAirportsByCityId(cityId);
    }
}