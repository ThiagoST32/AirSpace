package com.trevisan.AirSpace.Dtos.Customer;

import java.time.LocalDate;

public record CreateCustomerRequestDTO(
        String name,
        String email,
        String password,
        String phone,
        String dateOfBirth) {
}
