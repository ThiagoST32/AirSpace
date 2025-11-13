package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.CreatedCustomerResponseDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Services.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("register")
    public ResponseEntity<CreatedCustomerResponseDTO>registerNewCustomer(@RequestBody CreateCustomerRequestDTO requestDTO){
        return new ResponseEntity<>(customerService.createUser(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("updateCustomer/{id}")
    public ResponseEntity<UpdatedCustomerResponseDTO>updateCustomer(@RequestBody UpdateCustomerRequestDTO requestDTO, @PathVariable Long id){
        return new ResponseEntity<>(customerService.customerUpdate(requestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>>getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Customer>getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Customer>getCustomerByName(@PathVariable String name){
        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }
}
