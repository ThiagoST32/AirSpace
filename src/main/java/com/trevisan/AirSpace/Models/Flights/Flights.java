package com.trevisan.AirSpace.Models.Flights;

import com.trevisan.AirSpace.Dtos.Flights.RequestRegisterFlightDTO;
import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;
import com.trevisan.AirSpace.Models.Seat.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "flightId")
@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private OffsetDateTime departureTime;

    private OffsetDateTime arrivalTime;

    private int flightNumber;

    private FlightClass flightsClass;

    private FlightStatus flightsStatus;

    private boolean flightsAvailable;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seat> seat = new ArrayList<>();

    @OneToOne(mappedBy = "flightsToGo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AirPort originAirPort;

    @OneToMany(mappedBy = "flightsToCome", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AirPort> destinationAirPort;

//    private Plane planeId;

    public Flights(RequestRegisterFlightDTO flightDTO){
        this.departureTime = flightDTO.departureTime();
        this.arrivalTime = flightDTO.arrivalTime();
        this.flightNumber = flightDTO.flightNumber();
        this.flightsClass = flightDTO.flightsClass();
        this.flightsStatus = flightDTO.flightStatus();
        this.flightsAvailable = flightDTO.flightAvailable();
    }

    public Flights(Long flightId, OffsetDateTime departureTime, OffsetDateTime arrivalTime, int flightNumber, FlightClass flightsClass, FlightStatus flightsStatus, boolean flightsAvailable) {
        this.flightId = flightId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
        this.flightsClass = flightsClass;
        this.flightsStatus = flightsStatus;
        this.flightsAvailable = flightsAvailable;
    }
}
