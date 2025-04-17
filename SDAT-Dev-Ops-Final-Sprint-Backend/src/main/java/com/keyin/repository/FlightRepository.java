package com.keyin.repository;

import com.keyin.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f WHERE f.destinationAirport.id = :airportId")
    List<Flight> findArrivingFlightsByAirportId(@Param("airportId") Long airportId);

    @Query("SELECT f FROM Flight f WHERE f.originAirport.id = :airportId")
    List<Flight> findDepartingFlightsByAirportId(@Param("airportId") Long airportId);

    @Query("SELECT f FROM Flight f WHERE f.aircraft.airlineName = :airlineName")
    List<Flight> findFlightsByAirline(@Param("airlineName") String airlineName);
    @Query("SELECT f FROM Flight f WHERE f.gate = :gate")
    List<Flight> findFlightsByGate(@Param("gate") String gate);
}