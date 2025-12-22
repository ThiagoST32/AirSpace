package com.trevisan.AirSpace.Repositories.CustomerRepository;

import com.trevisan.AirSpace.Models.Customers.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);
}
