package com.trevisan.AirSpace.Dtos.Customer.Requests;

public record CreateCustomerRequestDTO(
        String name,
        String email,
        String password,
        String phone,
        String dateOfBirth) {
}
