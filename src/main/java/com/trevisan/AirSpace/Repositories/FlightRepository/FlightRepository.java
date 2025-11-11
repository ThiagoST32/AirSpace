package com.trevisan.AirSpace.Repositories.FlightRepository;

import com.trevisan.AirSpace.Models.Flights.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flights, Long> {

    @Query(value = "SELECT DISTINCT f.* FROM Flights f LEFT JOIN Seat as s ON f.flight_id = s.flight_id FETCH f.seats", nativeQuery = true)
    List<Flights> findAllFlightsWithSeats();

    @Query(value = "SELECT DISTINCT f.* FROM Flights f LEFT JOIN Seat as s ON f.flight_id = s.flight_id WHERE s.seat_available = true", nativeQuery = true)
    List<Flights> findAllFlightsWithAvailableSeats();

    @Query(value = "SELECT f FROM Flights f LEFT JOIN f.seats WHERE f.flights_id = :flightId", nativeQuery = true)
    Optional<Flights> findFlightWithSeatsById(Long flightId);

    List<Flights> findByFlightsAvailableTrue();
}
