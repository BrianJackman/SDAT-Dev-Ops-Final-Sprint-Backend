package com.keyin.SDAT_Dev_Ops_Final_Sprint_Backend;

import com.keyin.model.City;
import com.keyin.model.Flight;
import com.keyin.repository.CityRepository;
import com.keyin.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SdatDevOpsFinalSprintBackendApplicationTests {

    @Mock
    private CityRepository cityRepository;

    @Mock
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // -------------------- CityRepository Tests --------------------

    @Test
    void testFindAllCities() {
        // Arrange
        when(cityRepository.findAll()).thenReturn(Arrays.asList(new City(), new City()));

        // Act
        List<City> cities = cityRepository.findAll();

        // Assert
        assertEquals(2, cities.size());
        verify(cityRepository, times(1)).findAll();
    }

    @Test
    void testFindCityById() {
        // Arrange
        City city = new City();
        city.setId(1L);
        when(cityRepository.findById(1L)).thenReturn(Optional.of(city));

        // Act
        Optional<City> result = cityRepository.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(cityRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveCity() {
        // Arrange
        City city = new City();
        city.setName("Test City");
        when(cityRepository.save(city)).thenReturn(city);

        // Act
        City savedCity = cityRepository.save(city);

        // Assert
        assertNotNull(savedCity);
        assertEquals("Test City", savedCity.getName());
        verify(cityRepository, times(1)).save(city);
    }

    // -------------------- FlightRepository Tests --------------------

    @Test
    void testFindAllFlights() {
        // Arrange
        when(flightRepository.findAll()).thenReturn(Arrays.asList(new Flight(), new Flight()));

        // Act
        List<Flight> flights = flightRepository.findAll();

        // Assert
        assertEquals(2, flights.size());
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void testFindFlightById() {
        // Arrange
        Flight flight = new Flight();
        flight.setId(1L);
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));

        // Act
        Optional<Flight> result = flightRepository.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(flightRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveFlight() {
        // Arrange
        Flight flight = new Flight();
        flight.setFlightNumber("Test Flight");
        when(flightRepository.save(flight)).thenReturn(flight);

        // Act
        Flight savedFlight = flightRepository.save(flight);

        // Assert
        assertNotNull(savedFlight);
        assertEquals("Test Flight", savedFlight.getFlightNumber());
        verify(flightRepository, times(1)).save(flight);
    }
}