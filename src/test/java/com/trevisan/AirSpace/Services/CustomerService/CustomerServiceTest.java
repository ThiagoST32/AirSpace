package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.Requests.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Enums.UserType;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.util.Assert;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

//    @Test
//    void itShouldReturnCreatedUser() throws Exception {
//        CreateCustomerRequestDTO requestDTO = new CreateCustomerRequestDTO(
//                "thiago",
//                "thiago@gmail.com",
//                "123",
//                "111111111",
//                Date.from(Instant.now()));
//        Customer expectedCustomer = new Customer(requestDTO, UserType.CUSTOMER);
//
//        when(this.customerRepository.save(any(Customer.class))).thenReturn(expectedCustomer);
//
//        assertEquals(UserType.CUSTOMER, expectedCustomer.getUserType());
//
//        Customer result = new Customer(customerService.createUser(requestDTO));
//
//        assertNotNull(result);
//        assertEquals("thiago", result.getName());
//        Assert.isInstanceOf(Customer.class, result);
//
//        verify(customerRepository).save(ArgumentMatchers.argThat(customer ->
//            customer.getName().equals("thiago")
//        ));
//    }

//    @Test
//    void itShouldReturnInvalidEmail(){
//        CreateCustomerRequestDTO requestDTO = new CreateCustomerRequestDTO(
//                "thiago",
//                "thiagogmail.com",
//                "123",
//                "111111111",
//                Date.from(Instant.now()));
//        Customer expectedCustomer = new Customer(requestDTO, UserType.CUSTOMER);
//
//        assertEquals(UserType.CUSTOMER, expectedCustomer.getUserType());
//
//        when(this.customerRepository.save(any(Customer.class))).thenReturn(expectedCustomer);
//
//        Customer result = new Customer(customerService.createUser(requestDTO));
//
//        assertFalse(customerService.checkIfEmailIsValid(result.getEmail()));
//    }

    /*
    mockMvc.perform(post("/createUser")
                .content(mapper.writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(requestDTO.name()));
     */
}