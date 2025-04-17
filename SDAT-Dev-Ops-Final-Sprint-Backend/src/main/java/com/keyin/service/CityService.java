package com.keyin.service;

import com.keyin.model.City;
import com.keyin.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        city.setId(id); // Ensure the ID is set for updating
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}