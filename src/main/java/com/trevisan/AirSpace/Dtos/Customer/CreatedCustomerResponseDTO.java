package com.trevisan.AirSpace.Dtos.Customer;

import java.time.LocalDate;

public record CreatedCustomerResponseDTO(
        String name,
        String email,
        String phone,
        LocalDate dateOfBirth) {
}
