package com.trevisan.AirSpace.Models.Reserves;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idReserveCustomer")
public class ReserveCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReserveCustomer;

    private Long customerId;

    private Long reserveId;

    public ReserveCustomer(Long customerIdReceived, Long reserveIdReceived){
        customerId = customerIdReceived;
        reserveId = reserveIdReceived;
    }
}
