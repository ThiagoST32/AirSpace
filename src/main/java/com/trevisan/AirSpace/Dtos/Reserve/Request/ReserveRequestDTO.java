package com.trevisan.AirSpace.Dtos.Reserve.Request;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ReserveRequestDTO(
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Total value cannot be 0 or less than 0!")
        BigDecimal totalValue,
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Customer id cannot be 0 or less than 0!")
        Long customerId) {
}
