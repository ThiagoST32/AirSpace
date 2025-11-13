package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.CreatedCustomerResponseDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Enums.UserType;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserType userType = UserType.CUSTOMER;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
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

    public UpdatedCustomerResponseDTO customerUpdate(UpdateCustomerRequestDTO customerRequestDTO, Long id){

        if (this.customerRepository.findById(id).isEmpty()){
            throw new NullPointerException();
        }

        Customer updateCustomer = this.customerRepository.findById(id).orElseThrow();

        updateCustomer.setName(customerRequestDTO.name());
        updateCustomer.setPhone(customerRequestDTO.phone());
        updateCustomer.setEmail(customerRequestDTO.email());

        //Todas as outras etapas de verificação Email, Phone, etc...

        var updatedCustomer = this.customerRepository.save(updateCustomer);

        return new UpdatedCustomerResponseDTO(
                updatedCustomer.getName(),
                updateCustomer.getEmail(),
                updateCustomer.getPhone()
        );
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer getCustomerByName(String name){
        return customerRepository.findCustomerByName(name).orElseThrow();
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
