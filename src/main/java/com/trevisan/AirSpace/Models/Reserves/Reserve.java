package com.trevisan.AirSpace.Models.Reserves;

import com.trevisan.AirSpace.Dtos.Reserve.Request.ReserveRequestDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Enums.ReserveStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "reserveId")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveId;

    private ReserveStatus reserveStatus;

    private BigDecimal totalValue;

    private LocalDate reserveDate;

    private LocalTime localTime;

    private UUID reserveCode;

//    private Seat seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    private Flights flight;

    public Reserve(ReserveRequestDTO requestDTO, LocalDate localDate, LocalTime localTime, UUID reserveCode, Customer customer){
        this.totalValue = requestDTO.totalValue();
        this.reserveDate = localDate;
        this.localTime = localTime;
        this.reserveCode = reserveCode;
        this.customer = customer;
    }
}
