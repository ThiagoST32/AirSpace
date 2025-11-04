package com.trevisan.AirSpace.Repositories.CustomerRepository;

import com.trevisan.AirSpace.Models.Customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByName(String name);
}
