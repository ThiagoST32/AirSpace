package com.trevisan.AirSpace.Dtos.Seat;

import com.trevisan.AirSpace.Models.Enums.SeatType;

import java.math.BigDecimal;

public record SeatResponseDTO(Long id, String seatNumber, SeatType seatType, boolean seatAvailable, BigDecimal seatValue) {
}
