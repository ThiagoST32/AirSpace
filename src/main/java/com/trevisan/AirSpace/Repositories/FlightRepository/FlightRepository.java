package com.trevisan.AirSpace.Repositories.FlightRepository;

import com.trevisan.AirSpace.Models.Flights.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flights, Long> {
    List<Flights> findByFlightsAvailableTrue();
}
