// Author: Brian Jackman
// Date: 2025/04/18
// Project: SDAT & Dev Ops Final Sprint


package com.keyin.service;

import com.keyin.dto.AircraftDTO;
import com.keyin.model.Aircraft;
import com.keyin.repository.AircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftService {
    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<AircraftDTO> getAllAircrafts() {
        return aircraftRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public AircraftDTO getAircraftById(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));
        return convertToDTO(aircraft);
    }


    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }


    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Aircraft existingAircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));
        existingAircraft.setType(aircraft.getType());
        existingAircraft.setAirlineName(aircraft.getAirlineName());
        existingAircraft.setNumberOfPassengers(aircraft.getNumberOfPassengers());
        return aircraftRepository.save(existingAircraft);
    }


    public void deleteAircraft(Long id) {
        if (!aircraftRepository.existsById(id)) {
            throw new RuntimeException("Aircraft not found");
        }
        aircraftRepository.deleteById(id);
    }


    private AircraftDTO convertToDTO(Aircraft aircraft) {
        AircraftDTO aircraftDTO = new AircraftDTO();
        aircraftDTO.setId(aircraft.getId());
        aircraftDTO.setType(aircraft.getType());
        aircraftDTO.setAirlineName(aircraft.getAirlineName());
        aircraftDTO.setNumberOfPassengers(aircraft.getNumberOfPassengers());
        return aircraftDTO;
    }


    public Aircraft convertToEntity(AircraftDTO aircraftDTO) {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(aircraftDTO.getId());
        aircraft.setType(aircraftDTO.getType());
        aircraft.setAirlineName(aircraftDTO.getAirlineName());
        aircraft.setNumberOfPassengers(aircraftDTO.getNumberOfPassengers());
        return aircraft;
    }
}