package com.keyin.repository;

import com.keyin.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    // Find all aircrafts by airline name
    List<Aircraft> findByAirlineName(String airlineName);

    // Find all aircrafts with a passenger capacity greater than a given number
    List<Aircraft> findByNumberOfPassengersGreaterThan(int capacity);

    // Custom query to find aircrafts by type
    @Query("SELECT a FROM Aircraft a WHERE a.type = :type")
    List<Aircraft> findAircraftsByType(String type);
}