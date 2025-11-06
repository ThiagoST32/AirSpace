package com.trevisan.AirSpace.Repositories.FlightRepository;

import com.trevisan.AirSpace.Models.Seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Seat, Long> {
}
