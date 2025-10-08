package com.trevisan.AirSpace.Models.Baggage;

import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;

public class Baggage {
    private Long baggageId;

    private Float weight;

    private BaggageType baggageType;

    private BaggageStatus baggageStatus;

    private Reserve reserveId;
}
