package com.trevisan.AirSpace.Utils;

import com.trevisan.AirSpace.Dtos.Customer.Responses.CustomerListResponseDTO;
import com.trevisan.AirSpace.Dtos.Customer.Responses.CustomerSummaryDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtils {


    public CustomerListResponseDTO mapToCustomerListResponseDTO(Customer customer){
        return new CustomerListResponseDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getDateOfBirth()
        );
    }

    public CustomerSummaryDTO mapToCustomerSummaryRespondeDTO(Customer customer){
        return new CustomerSummaryDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getDateOfBirth()
        );
    }
}
