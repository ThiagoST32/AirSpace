package com.trevisan.AirSpace.Repositories.BaggageRepository;

import com.trevisan.AirSpace.Models.Baggage.Baggage;
import com.trevisan.AirSpace.Models.Baggage.CustomerBaggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerBaggageRepository extends JpaRepository<CustomerBaggage, Long> {

    @Query(value = "SELECT b.* FROM BAGGAGE AS b RIGHT JOIN CUSTOMER_BAGGAGE AS cb ON b.baggage_id = cb.baggage_id " +
            "LEFT JOIN CUSTOMER as c ON c.customer_id = :customerId", nativeQuery = true)
    List<Baggage> findAllBaggageByCustomerId(Long customerId);


    @Query(value = "SELECT CASE WHEN (c.customer_id = :customerId) THEN 1 ELSE 0 END AS RESULTADO FROM CUSTOMER as c" +
            "INNER JOIN CUSTOMER_BAGGAGE AS CB ON cb.customer_id = c.customer_id", nativeQuery = true)
    Boolean findUserBaggageRequested(Long customerId);
}
