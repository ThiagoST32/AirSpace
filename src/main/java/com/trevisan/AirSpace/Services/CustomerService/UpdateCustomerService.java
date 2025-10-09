package com.trevisan.AirSpace.Services.CustomerService;

import com.trevisan.AirSpace.Dtos.Customer.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Customer.Customer;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public UpdatedCustomerResponseDTO customerUpdate(UpdateCustomerRequestDTO customerRequestDTO){

        //Criar uma classe responsável / método para verificação de valores vindos do request
        if (customerRequestDTO.customerId() == null || customerRequestDTO.customerId() == 0){
            throw new IllegalArgumentException();
        }

//        if (this.customerRepository.findById(customerRequestDTO.customerId()).isEmpty()){
//            throw new NullPointerException();
//        }

        Customer updateCustomer = this.customerRepository.findById(customerRequestDTO.customerId()).get();

        //Todas as outras etapas de verificação Email, Phone, etc...

        var updatedCustomer = this.customerRepository.saveAndFlush(updateCustomer);

        return new UpdatedCustomerResponseDTO(
                updatedCustomer.getName(),
                updateCustomer.getEmail(),
                updateCustomer.getPhone()
        );
    }
}
