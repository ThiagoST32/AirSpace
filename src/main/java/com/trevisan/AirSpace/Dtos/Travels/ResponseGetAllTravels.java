package com.trevisan.AirSpace.Dtos.Travels;

import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Enums.TravelStatus;
import com.trevisan.AirSpace.Models.Flights.Flights;

public record ResponseGetAllTravels(Long id, AirPort airPort, Flights flights, TravelStatus travelStatus) {
}
