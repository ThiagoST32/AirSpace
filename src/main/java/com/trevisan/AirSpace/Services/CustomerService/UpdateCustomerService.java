package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public UpdateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
}
