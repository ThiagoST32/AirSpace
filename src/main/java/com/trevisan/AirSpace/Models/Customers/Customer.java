package com.trevisan.AirSpace.Models.Customers;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.CreatedCustomerResponseDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdateCustomerRequestDTO;
import com.trevisan.AirSpace.Dtos.Customer.UpdatedCustomerResponseDTO;
import com.trevisan.AirSpace.Models.Enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "customerId")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String email;

    private String password;

    private String phone;

    private LocalDate dateOfBirth;

    private UserType userType;

    public Customer (CreateCustomerRequestDTO newCustomer, UserType userType){
        this.name = newCustomer.name();
        this.email = newCustomer.email();
        this.password = newCustomer.password();
        this.phone = newCustomer.phone();
        this.dateOfBirth = LocalDate.parse(newCustomer.dateOfBirth());
        this.userType = userType;
    }

    public Customer (CreatedCustomerResponseDTO newCustomer){
        this.name = newCustomer.name();
        this.email = newCustomer.email();
        this.phone = newCustomer.phone();
        this.dateOfBirth = newCustomer.dateOfBirth();
    }

    public Customer (UpdateCustomerRequestDTO updateCustomer){
        this.customerId = updateCustomer.customerId();
        this.name = updateCustomer.name();
        this.email = updateCustomer.email();
        this.phone = updateCustomer.phone();
    }

    public Customer (UpdatedCustomerResponseDTO updatedCustomer){
        this.name = updatedCustomer.name();
        this.email = updatedCustomer.email();
        this.phone = updatedCustomer.phone();
    }
}
