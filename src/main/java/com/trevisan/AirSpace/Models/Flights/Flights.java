package com.trevisan.AirSpace.Models.Flights;

import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;
import com.trevisan.AirSpace.Models.Plane.Plane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "flightId")
public class Flights {
    private Long flightId;

    private OffsetDateTime departureTime;

    private OffsetDateTime arrivalTime;

    private int flightNumber;

    private FlightClass flightsClass;

    private FlightStatus flightsStatus;

    private AirPort originAirPort;

    private AirPort destinationAirPort;

    private Plane planeId;
}
