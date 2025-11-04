package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersService {

    private final CustomerRepository customerRepository;

    @Autowired
    public GetCustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer getCustomerByName(String name){
        return customerRepository.findCustomerByName(name);
    }
}
