package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.CreatedCustomerResponseDTO;
import com.trevisan.AirSpace.Services.CustomerService.CreateCustomerService;
import com.trevisan.AirSpace.Services.CustomerService.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CreateCustomerService createCustomerService;
    private final UpdateCustomerService updateCustomerService;

    @Autowired
    public CustomerController(CreateCustomerService createCustomerService, UpdateCustomerService updateCustomerService) {
        this.createCustomerService = createCustomerService;
        this.updateCustomerService = updateCustomerService;
    }

    @PostMapping("register")
    public ResponseEntity<CreatedCustomerResponseDTO>registerNewCustomer(@RequestBody CreateCustomerRequestDTO requestDTO){
        return new ResponseEntity<>(createCustomerService.createUser(requestDTO), HttpStatus.CREATED);
    }
}
