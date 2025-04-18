// Author: Brian Jackman
// Date: 2025/04/18
// Project: SDAT & Dev Ops Final Sprint


package com.keyin.service;

import com.keyin.dto.CityDTO;
import com.keyin.dto.AirportDTO;
import com.keyin.model.City;
import com.keyin.model.Airport;
import com.keyin.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> getAllCities() {
        return cityRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CityDTO getCityById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        return convertToDTO(city);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City existingCity = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        existingCity.setName(city.getName());
        existingCity.setState(city.getState());
        existingCity.setPopulation(city.getPopulation());
        return cityRepository.save(existingCity);
    }

    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new RuntimeException("City not found");
        }
        cityRepository.deleteById(id);
    }

    private CityDTO convertToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setState(city.getState());
        cityDTO.setPopulation(city.getPopulation());
        cityDTO.setAirports(city.getAirports().stream()
                .map(this::convertToAirportDTO)
                .collect(Collectors.toList()));
        return cityDTO;
    }

    private AirportDTO convertToAirportDTO(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setId(airport.getId());
        airportDTO.setName(airport.getName());
        airportDTO.setCode(airport.getCode());
        return airportDTO;
    }
}