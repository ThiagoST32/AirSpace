package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Models.Customer.Customer;
import com.trevisan.AirSpace.Models.Enums.UserType;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

class CreateCustomerServiceTest {

    @MockitoBean
    private CustomerRepository customerRepository;

    @Autowired
    private Mock mock;

    @Autowired
    private MockMvc mockMvc;

    private CreateCustomerService createCustomerService;

    @Test
    void createUser() {
        CreateCustomerRequestDTO requestDTO = new CreateCustomerRequestDTO(
                "thiago",
                "thiago@gmail.com",
                "123",
                "111111111",
                Date.from(Instant.now()));
        Customer newCustomer = new Customer(requestDTO, UserType.CUSTOMER);

        when(this.createCustomerService.createUser(any(CreateCustomerRequestDTO.class))).thenReturn(newCustomer);

        //mockMvc.perform(post("/createUser");
        //Assert.isInstanceOf(Customer.class, newCustomerPersisted);
    }
}