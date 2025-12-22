package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.Requests.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.Responses.CustomerListResponseDTO;
import com.trevisan.AirSpace.Dtos.Customer.Responses.CustomerSummaryDTO;
import com.trevisan.AirSpace.Dtos.Customer.Requests.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Enums.UserType;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import com.trevisan.AirSpace.Utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final UserType userType = UserType.CUSTOMER;
    private final CustomerUtils customerUtils;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerValidator customerValidator, CustomerUtils customerUtils) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
        this.customerUtils = customerUtils;
    }

    public CustomerSummaryDTO createUser(CreateCustomerRequestDTO customer){

        customerValidator.validationCustomerCreation(customer);

        Customer newCustomer = new Customer(customer, userType);
        var newCustomerPersisted = this.customerRepository.save(newCustomer);

        return new CustomerSummaryDTO(
                newCustomerPersisted.getCustomerId(),
                newCustomerPersisted.getName(),
                newCustomerPersisted.getEmail(),
                newCustomerPersisted.getPhone(),
                newCustomerPersisted.getDateOfBirth()
        );
    }

    public CustomerSummaryDTO customerUpdate(UpdateCustomerRequestDTO customerRequestDTO, Long id){

        if (this.customerRepository.findById(id).isEmpty()){
            throw new NullPointerException();
        }



        Customer updateCustomer = this.customerRepository.findById(id).orElseThrow();

        updateCustomer.setName(customerRequestDTO.name());
        updateCustomer.setPhone(customerRequestDTO.phone());
        updateCustomer.setEmail(customerRequestDTO.email());

        //Todas as outras etapas de verificação Email, Phone, etc...

        var updatedCustomer = this.customerRepository.save(updateCustomer);

        return new CustomerSummaryDTO(
                updatedCustomer.getCustomerId(),
                updatedCustomer.getName(),
                updateCustomer.getEmail(),
                updateCustomer.getPhone(),
                updateCustomer.getDateOfBirth()
        );
    }

    public List<CustomerListResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerUtils::mapToCustomerListResponseDTO)
                .toList();
    }

    public CustomerSummaryDTO getCustomerById(Long id){
        Customer customerFoundById = customerRepository.findById(id).orElseThrow();
        return new CustomerSummaryDTO(
                customerFoundById.getCustomerId(),
                customerFoundById.getName(),
                customerFoundById.getEmail(),
                customerFoundById.getPhone(),
                customerFoundById.getDateOfBirth()
        );
    }

    public CustomerSummaryDTO getCustomerByName(String name){
        Customer customerFoundByName = customerRepository.findCustomerByName(name).orElseThrow();
        return new CustomerSummaryDTO(
                customerFoundByName.getCustomerId(),
                customerFoundByName.getName(),
                customerFoundByName.getEmail(),
                customerFoundByName.getPhone(),
                customerFoundByName.getDateOfBirth()
        );
    }


}
