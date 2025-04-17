package com.keyin.repository;

import com.keyin.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    @Query("SELECT DISTINCT a.type FROM Aircraft a JOIN a.passengers p WHERE p.id = :passengerId")
    List<String> findAircraftByPassengerId(@Param("passengerId") Long passengerId);
}