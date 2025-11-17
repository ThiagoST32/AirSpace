package com.trevisan.AirSpace.Dtos.Travels;

import com.trevisan.AirSpace.Models.Enums.TravelStatus;

public record RegisterTravelRequestDTO(Long idAirPort, Long idFlight, TravelStatus travelStatus) {
}
