package com.trevisan.AirSpace.Dtos.Travels;

import com.trevisan.AirSpace.Models.Enums.TravelStatus;

public record ResponseGetAllTravels(Long id, com.trevisan.AirSpace.Dtos.AirPort.ResponseAirPortDTO airPort, com.trevisan.AirSpace.Dtos.Flights.ResponseFlightDTO flights, TravelStatus travelStatus) {
}
