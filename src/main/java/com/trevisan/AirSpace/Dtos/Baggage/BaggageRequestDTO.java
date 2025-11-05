package com.trevisan.AirSpace.Dtos.Baggage;

import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;

public record BaggageRequestDTO(Float weight, BaggageType baggageType, BaggageStatus baggageStatus) {
}
