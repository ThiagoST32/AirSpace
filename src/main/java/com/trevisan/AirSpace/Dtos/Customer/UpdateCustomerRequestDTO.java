package com.trevisan.AirSpace.Dtos.Customer;

public record UpdateCustomerRequestDTO(Long customerId, String name, String email, String phone) {
}
