package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.CreatedCustomerResponseDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Services.CustomerService.CreateCustomerService;
import com.trevisan.AirSpace.Services.CustomerService.GetCustomersService;
import com.trevisan.AirSpace.Services.CustomerService.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final GetCustomersService getCustomersService;
    private final CreateCustomerService createCustomerService;
    private final UpdateCustomerService updateCustomerService;

    @Autowired
    public CustomerController(GetCustomersService getCustomersService, CreateCustomerService createCustomerService, UpdateCustomerService updateCustomerService) {
        this.getCustomersService = getCustomersService;
        this.createCustomerService = createCustomerService;
        this.updateCustomerService = updateCustomerService;
    }

    @PostMapping("register")
    public ResponseEntity<CreatedCustomerResponseDTO>registerNewCustomer(@RequestBody CreateCustomerRequestDTO requestDTO){
        return new ResponseEntity<>(createCustomerService.createUser(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("updateCustomer/{id}")
    public ResponseEntity<UpdatedCustomerResponseDTO>updateCustomer(@RequestBody UpdateCustomerRequestDTO requestDTO, @PathVariable Long id){
        return new ResponseEntity<>(updateCustomerService.customerUpdate(requestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>>getAllCustomers(){
        return new ResponseEntity<>(getCustomersService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Customer>getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(getCustomersService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Customer>getCustomerByName(@PathVariable String name){
        return new ResponseEntity<>(getCustomersService.getCustomerByName(name), HttpStatus.OK);
    }
}
