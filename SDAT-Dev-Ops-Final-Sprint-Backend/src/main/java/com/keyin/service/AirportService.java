package com.keyin.service;

import com.keyin.dto.AirportDTO;
import com.keyin.model.Airport;
import com.keyin.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportDTO> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
        return convertToDTO(airport);
    }

    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
        existingAirport.setName(airport.getName());
        existingAirport.setCode(airport.getCode());
        return airportRepository.save(existingAirport);
    }

    public void deleteAirport(Long id) {
        if (!airportRepository.existsById(id)) {
            throw new RuntimeException("Airport not found");
        }
        airportRepository.deleteById(id);
    }

    private AirportDTO convertToDTO(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setId(airport.getId());
        airportDTO.setName(airport.getName());
        airportDTO.setCode(airport.getCode());
        return airportDTO;
    }
}