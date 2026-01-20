package com.trevisan.AirSpace.Dtos.Customer.Responses;

import java.time.LocalDate;

public record CustomerSummaryDTO(
        Long customerId,
        String name,
        String email,
        String phone,
        LocalDate dateOfBirth) {
}
