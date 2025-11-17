package com.trevisan.AirSpace.Models.Baggage;

import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageRequestDTO;
import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baggageId;

    private Float weight;

    private BaggageType baggageType;

    private BaggageStatus baggageStatus;

    @CreationTimestamp
    private Timestamp timestampBaggage;

    public Baggage (BaggageRequestDTO requestDTO){
        this.weight = requestDTO.weight();
        this.baggageType = requestDTO.baggageType();
        this.baggageStatus = requestDTO.baggageStatus();
    }
}
