package com.trevisan.AirSpace.Dtos.Reserve;

import java.math.BigDecimal;

public record ReserveRequestDTO(BigDecimal totalValue, Long customerId) {
}
