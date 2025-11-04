package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.CreatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Enums.UserType;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {
    private final CustomerRepository customerRepository;
    private final UserType userType = UserType.CUSTOMER;

    @Autowired
    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CreatedCustomerResponseDTO createUser(CreateCustomerRequestDTO customer){
        //Adicionar validações posteriormente
        Customer newCustomer = new Customer(customer, userType);
        var newCustomerPersisted = this.customerRepository.save(newCustomer);

        return new CreatedCustomerResponseDTO(
                newCustomerPersisted.getName(),
                newCustomerPersisted.getEmail(),
                newCustomerPersisted.getPhone(),
                newCustomerPersisted.getDateOfBirth()
        );
    }

    protected boolean checkIfEmailIsValid(String email){ return email.contains("@"); }

    private boolean checkIfPhoneIsValid(){ return false; }

    private boolean checkIfPasswordIsValid() { return false; }

    private boolean checkIfDateOfBirthIsValid() { return false; }

    private boolean checkIfEmailAlreadyExists(){ return false; }

    private boolean checkIfPhoneAlreadyExists(){ return false; }

    private boolean checkIfEmailIsEmpty(){ return false; }

    private boolean checkIfPhoneIsEmpty() { return false; }

    private boolean checkIfPasswordIsEmpty() { return  false; }

    private boolean checkIfDateOfBirthIsEmpty() { return false; }
}
