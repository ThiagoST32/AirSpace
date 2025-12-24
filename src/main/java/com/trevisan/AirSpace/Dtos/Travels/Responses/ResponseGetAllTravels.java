package com.trevisan.AirSpace.Dtos.Travels.Responses;

import com.trevisan.AirSpace.Dtos.AirPort.Response.ResponseAirPortDTO;
import com.trevisan.AirSpace.Models.Enums.TravelStatus;

public record ResponseGetAllTravels(Long id, ResponseAirPortDTO airPort, com.trevisan.AirSpace.Dtos.Flights.ResponseFlightDTO flights, TravelStatus travelStatus) {
}
