package com.trevisan.AirSpace.Models.Customer;

import com.trevisan.AirSpace.Dtos.Customer.CreateCustomerRequestDTO;
import com.trevisan.AirSpace.Models.Enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "customerId")
public class Customer {
    private Long customerId;

    private String name;

    private String email;

    private String password;

    private String phone;

    private Date dateOfBirth;

    private UserType userType;

    public Customer (CreateCustomerRequestDTO newCustomer, UserType userType){
        this.name = newCustomer.name();
        this.email = newCustomer.email();
        this.password = newCustomer.password();
        this.phone = newCustomer.phone();
        this.dateOfBirth = newCustomer.dateOfBirth();
        this.userType = userType;
    }
}
