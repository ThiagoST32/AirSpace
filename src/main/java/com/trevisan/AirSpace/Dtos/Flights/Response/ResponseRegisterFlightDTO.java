package com.trevisan.AirSpace.Dtos.Flights;

import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;

import java.time.OffsetDateTime;

public record ResponseRegisterFlightDTO(Long id,
                                        OffsetDateTime departureTime,
                                        OffsetDateTime arrivalTime,
                                        int flightNumber,
                                        FlightClass flightsClass,
                                        FlightStatus flightStatus,
                                        boolean flightAvailable) {
}
