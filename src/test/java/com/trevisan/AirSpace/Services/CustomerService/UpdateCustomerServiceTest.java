package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.Requests.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.Responses.CustomerSummaryDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Enums.UserType;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private UpdateCustomerService updateCustomerService;

    @InjectMocks
    private CustomerService customerService;

//    @Test
//    void itShouldUpdatedCustomer() {
//        Long customerId = 1L;
//        Customer requestCreateDTO = new Customer(
//                1L,
//                "thiago",
//                "thiago@gmail.com",
//                "123",
//                "111111111",
//                Date.from(Instant.now()),
//                UserType.CUSTOMER);
//
//        assertNotNull(requestCreateDTO);
//
//        UpdateCustomerRequestDTO requestUpdateDTO = new UpdateCustomerRequestDTO(
//                1L,
//                ,
//                ,
//                "thiago.trevisan@gmail.com",
//                "22222222"
//
//        );
//
//        Optional<Customer> expectedSomeoneCustomer = this.customerRepository.findById(customerId);
//
//        assertNotNull(expectedSomeoneCustomer);
//
//        CustomerSummaryDTO responseDTO = this.updateCustomerService(requestUpdateDTO);
//        Customer resultUpdated = new Customer(responseDTO);
//
//        assertEquals("thiago02", resultUpdated.getName());
//        assertEquals("thiago.trevisan@gmail.com", resultUpdated.getEmail());
//        assertEquals("22222222", resultUpdated.getPhone());
//    }
}