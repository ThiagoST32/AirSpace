package com.trevisan.AirSpace.Dtos.Seat.Request;

import com.trevisan.AirSpace.Models.Enums.SeatType;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SeatRegisterRequestDTO(
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Seat number cannot be 0 or less than 0!")
        String seatNumber,
        @NotNull
        @NotBlank
        @NotEmpty(message = "Seat type cannot be empty!")
        SeatType seatType,
        @NotNull
        @NotBlank
        boolean seatAvailable,
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Seat value cannot be 0 or less than 0!")
        BigDecimal seatValue,
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Flight id cannot be 0 or less than 0!")
        Long flightId) {
}
