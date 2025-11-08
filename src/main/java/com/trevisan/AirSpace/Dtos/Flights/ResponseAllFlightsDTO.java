package com.trevisan.AirSpace.Dtos.Flights;

import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;
import com.trevisan.AirSpace.Models.Seat.Seat;

import java.time.OffsetDateTime;

public record ResponseAllFlightsDTO(
                        Long id,
                        OffsetDateTime departureTime,
                        OffsetDateTime arrivalTime,
                        int flightNumber,
                        FlightClass flightsClass,
                        FlightStatus flightStatus,
                        boolean flightAvailable,
                        Seat seat
) {}
