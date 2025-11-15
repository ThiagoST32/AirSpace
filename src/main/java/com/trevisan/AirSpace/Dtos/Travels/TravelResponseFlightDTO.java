package com.trevisan.AirSpace.Dtos.Travels;

import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Enums.TravelStatus;

public record TravelResponseFlightDTO(Long idTravel, AirPort airPort, TravelStatus travelStatus) {
}
