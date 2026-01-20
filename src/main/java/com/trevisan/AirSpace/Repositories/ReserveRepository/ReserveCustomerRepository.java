package com.trevisan.AirSpace.Repositories.ReserveRepository;

import com.trevisan.AirSpace.Models.Reserves.Reserve;
import com.trevisan.AirSpace.Models.Reserves.ReserveCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReserveCustomerRepository extends JpaRepository<ReserveCustomer, Long> {

    @Query(value = "SELECT r.* FROM RESERVE as r RIGHT JOIN RESERVE_CUSTOMER as rc ON rc.reserva_id = r.reserve_id" +
            "LEFT JOIN CUSTOMER as c ON c.customer_id = :customerId", nativeQuery = true)
    List<Reserve> findAllReservesByUserId(Long customerId);
}
