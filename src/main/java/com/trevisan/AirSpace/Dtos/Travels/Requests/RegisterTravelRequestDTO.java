package com.trevisan.AirSpace.Dtos.Travels.Requests;

import com.trevisan.AirSpace.Models.Enums.TravelStatus;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterTravelRequestDTO(
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "AirPort id cannot be 0 or less than 0!")
        Long idAirPort,
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Flight id cannot be 0 or less than 0!")
        Long idFlight,
        @NotNull
        @NotBlank
        @NotEmpty(message = "Travel status cannot be empty!")
        TravelStatus travelStatus) {
}
