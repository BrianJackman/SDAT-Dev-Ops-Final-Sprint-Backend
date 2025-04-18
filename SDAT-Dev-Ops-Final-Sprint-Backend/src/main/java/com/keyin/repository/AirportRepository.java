// Author: Brian Jackman
// Date: 2025/04/18
// Project: SDAT & Dev Ops Final Sprint


package com.keyin.repository;

import com.keyin.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("SELECT a FROM Airport a WHERE a.city.id = :cityId")
    List<Airport> findAirportsByCityId(@Param("cityId") Long cityId);
}