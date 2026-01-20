package com.trevisan.AirSpace.Dtos.Customer.Responses;

import com.trevisan.AirSpace.Models.Baggage.Baggage;

import java.time.LocalDate;
import java.util.List;

public record CustomerSummaryBaggageDTO(Long customerId,
                                        String name,
                                        String email,
                                        String phone,
                                        LocalDate dateOfBirth,
                                        List<Baggage> baggage) {
}
