package com.trevisan.AirSpace.Dtos.Flights;

import com.trevisan.AirSpace.Dtos.Seat.SeatResponseFlightDTO;
import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;

import java.time.OffsetDateTime;
import java.util.List;

public record ResponseFlightsWithSeatsByIdDTO(Long id,
                                              OffsetDateTime departureTime,
                                              OffsetDateTime arrivalTime,
                                              int flightNumber,
                                              FlightClass flightsClass,
                                              FlightStatus flightStatus,
                                              boolean flightAvailable,
                                              List<SeatResponseFlightDTO> seat) {
}
