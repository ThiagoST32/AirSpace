package com.trevisan.AirSpace.Dtos.Baggage.Requests;

import com.trevisan.AirSpace.Models.Enums.BaggageType;

import java.util.List;

public record BaggageUpdateRequestDTO(BaggageType baggageType, Float baggageHigh, Float baggageWidth, List<String> itens) {
}
