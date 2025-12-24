package com.trevisan.AirSpace.Dtos.Flights.Request;

import com.trevisan.AirSpace.Models.Enums.FlightClass;
import com.trevisan.AirSpace.Models.Enums.FlightStatus;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record RequestRegisterFlightDTO(
        @NotNull
        @NotBlank
        OffsetDateTime departureTime,

        @NotNull
        @NotBlank
        OffsetDateTime arrivalTime,

        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Flight number cannot be 0 or less than 0!")
        int flightNumber,

        @NotNull
        @NotBlank
        @NotEmpty(message = "Flight class cannot be empty!")
        FlightClass flightsClass,

        @NotNull
        @NotBlank
        @NotEmpty(message = "Flight status cannot be empty!")
        FlightStatus flightStatus,

        @NotNull
        @NotBlank
        boolean flightAvailable) {
    }
