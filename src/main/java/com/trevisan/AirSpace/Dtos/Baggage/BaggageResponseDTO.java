package com.trevisan.AirSpace.Dtos.Baggage;

import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record BaggageResponseDTO(Float weight, BaggageType baggageType, BaggageStatus baggageStatus, LocalDate localDate, LocalTime localTime) {
}
