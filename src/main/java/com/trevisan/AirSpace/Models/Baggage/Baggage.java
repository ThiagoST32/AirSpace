package com.trevisan.AirSpace.Models.Baggage;

import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageUpdateRequestDTO;
import com.trevisan.AirSpace.Models.Enums.BaggageStatus;
import com.trevisan.AirSpace.Models.Enums.BaggageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "baggageId")
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baggageId;

    private Float weight;

    private BaggageType baggageType;

    private BaggageStatus baggageStatus;

    private UUID baggageCode;

    private Float baggageHigh;

    private Float baggageWidth;

    //Futuramente trocar para uma entidade de itens
    private List<String> itens = new ArrayList<>();

    private int totalItens;
    
    @CreationTimestamp
    private Timestamp timestampBaggage;

    public Baggage (BaggageRequestDTO requestDTO){
        this.weight = requestDTO.weight();
        this.baggageType = requestDTO.baggageType();
        this.baggageStatus = requestDTO.baggageStatus();
        this.baggageHigh = requestDTO.baggageHigh();
        this.baggageWidth = requestDTO.baggageWidth();
        baggageCode = baggageCodeGenerator();
    }

    public Baggage (BaggageUpdateRequestDTO requestDTO){
        this.baggageType = requestDTO.baggageType();
        this.baggageHigh = requestDTO.baggageHigh();
        this.baggageWidth = requestDTO.baggageWidth();
    }

    private UUID baggageCodeGenerator(){
        return UUID.randomUUID();
    }

}
