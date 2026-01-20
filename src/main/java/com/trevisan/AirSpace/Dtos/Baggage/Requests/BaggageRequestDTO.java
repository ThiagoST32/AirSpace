package com.trevisan.AirSpace.Dtos.Baggage.Requests;

import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;

import java.util.List;

public record BaggageRequestDTO(Float weight, BaggageType baggageType, BaggageStatus baggageStatus, Float baggageHigh, Float baggageWidth, List<String> itens) {
}
