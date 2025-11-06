package com.trevisan.AirSpace.Dtos.Seat;

import com.trevisan.AirSpace.Models.Enums.SeatType;

import java.math.BigDecimal;

public record SeatRegisterRequestDTO(String seatNumber, SeatType seatType, boolean seatAvailable, BigDecimal seatValue) {
}
