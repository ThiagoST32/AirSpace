package com.trevisan.AirSpace.Dtos.Customer;

import java.util.Date;

public record CreateCustomerRequestDTO(
        String name,
        String email,
        String password,
        String phone,
        Date dateOfBirth) {
}
