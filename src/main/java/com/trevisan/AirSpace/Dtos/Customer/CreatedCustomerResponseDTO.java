package com.trevisan.AirSpace.Dtos.Customer;

import java.util.Date;

public record CreatedCustomerResponseDTO(
        String name,
        String email,
        String phone,
        Date dateOfBirth) {
}
