package com.trevisan.AirSpace.Models.Customers;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "customerId")
    private Customer customer;
    private LocalDateTime expiryDate;

    public PasswordResetToken(Customer customer){
        this.customer = customer;
        this.token = UUID.randomUUID().toString();
        this.expiryDate = LocalDateTime.now().plusMinutes(5);
    }

    public PasswordResetToken(){}

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expiryDate);
    }
}
