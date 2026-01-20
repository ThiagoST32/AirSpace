package com.trevisan.AirSpace.Dtos.Baggage.Response;

import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record BaggageResponseDTO(Float weight, BaggageType baggageType, BaggageStatus baggageStatus, UUID baggageCode, Float baggageHigh, Float baggageWidth, LocalDate localDate, LocalTime localTime, List<String> itens, int totalItens) {
}
