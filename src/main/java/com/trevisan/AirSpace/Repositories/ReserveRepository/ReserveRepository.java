package com.trevisan.AirSpace.Repositories.ReserveRepository;

import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Reserves.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    Optional<List<Reserve>> findByCustomer_CustomerId(Long id);
}
