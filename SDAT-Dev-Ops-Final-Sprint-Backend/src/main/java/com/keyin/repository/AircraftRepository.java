// Author: Brian Jackman
// Date: 2025/04/18
// Project: SDAT & Dev Ops Final Sprint



package com.keyin.repository;

import com.keyin.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    List<Aircraft> findByAirlineName(String airlineName);

   
    List<Aircraft> findByNumberOfPassengersGreaterThan(int capacity);


    @Query("SELECT a FROM Aircraft a WHERE a.type = :type")
    List<Aircraft> findAircraftsByType(String type);
}