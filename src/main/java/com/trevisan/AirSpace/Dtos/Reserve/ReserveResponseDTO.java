package com.trevisan.AirSpace.Dtos.Reserve;

import com.trevisan.AirSpace.Dtos.Customer.CustomerGetResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record ReserveResponseDTO(BigDecimal totalValue, LocalDate localDate, LocalTime localDateTime, UUID reserveCode, CustomerGetResponseDTO customer) {
}
