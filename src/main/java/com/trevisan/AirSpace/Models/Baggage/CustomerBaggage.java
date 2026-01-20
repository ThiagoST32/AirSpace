package com.trevisan.AirSpace.Models.Baggage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idCustomerBaggage")
public class CustomerBaggage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomerBaggage;

    private Long customerId;

    private Long baggageId;

    public CustomerBaggage(Long customerIdReceived, Long baggageIdReceived){
        customerId = customerIdReceived;
        baggageId = baggageIdReceived;
    }
}
