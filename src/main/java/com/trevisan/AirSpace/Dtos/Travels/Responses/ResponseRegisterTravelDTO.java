package com.trevisan.AirSpace.Dtos.Travels.Responses;

import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Enums.TravelStatus;
import com.trevisan.AirSpace.Models.Flights.Flights;

public record ResponseRegisterTravelDTO(TravelStatus travelStatus, AirPort airPortTravel, Flights flightsTravel) {
}
