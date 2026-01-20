package com.trevisan.AirSpace.Repositories.CustomerRepository;

import com.trevisan.AirSpace.Models.Customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByName(String name);

    Optional<Customer> findCustomerByEmail(String email);

    Boolean existsCustomerByEmail(String email);

    Boolean existsCustomerByPhone(String phone);
}
