package com.trevisan.AirSpace.Repositories.PaymentRepository;

import com.trevisan.AirSpace.Models.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentService extends JpaRepository<Payment, Long> {
}
