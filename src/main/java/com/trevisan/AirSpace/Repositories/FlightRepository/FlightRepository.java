package com.trevisan.AirSpace.Repositories.FlightRepository;

import com.trevisan.AirSpace.Models.Flights.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Long> {
}
