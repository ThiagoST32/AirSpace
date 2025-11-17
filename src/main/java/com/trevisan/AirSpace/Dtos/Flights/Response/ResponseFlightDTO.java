package com.trevisan.AirSpace.Dtos.Flights;

import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;

import java.time.OffsetDateTime;

public record ResponseFlightDTO(OffsetDateTime departureTime,
                                OffsetDateTime arrivalTime,
                                int flightNumber,
                                FlightClass flightsClass,
                                FlightStatus flightStatus,
                                boolean flightAvailable) {
}
