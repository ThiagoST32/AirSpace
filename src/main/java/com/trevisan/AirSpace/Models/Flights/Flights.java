package com.trevisan.AirSpace.Models.Flights;

import com.trevisan.AirSpace.Dtos.Flights.RequestRegisterFlightDTO;
import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;
import com.trevisan.AirSpace.Models.Seat.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seats;

//    private AirPort originAirPort;

//    private AirPort destinationAirPort;

//    private Plane planeId;

    public Flights(RequestRegisterFlightDTO flightDTO, Seat seat){
        this.departureTime = flightDTO.departureTime();
        this.arrivalTime = flightDTO.arrivalTime();
        this.flightNumber = flightDTO.flightNumber();
        this.flightsClass = flightDTO.flightsClass();
        this.flightsStatus = flightDTO.flightStatus();
        this.flightsAvailable = flightDTO.flightAvailable();
        this.seats = seat;
    }
    public Flights(RequestRegisterFlightDTO flightDTO){
        this.departureTime = flightDTO.departureTime();
        this.arrivalTime = flightDTO.arrivalTime();
        this.flightNumber = flightDTO.flightNumber();
        this.flightsClass = flightDTO.flightsClass();
        this.flightsStatus = flightDTO.flightStatus();
        this.flightsAvailable = flightDTO.flightAvailable();
    }

}
