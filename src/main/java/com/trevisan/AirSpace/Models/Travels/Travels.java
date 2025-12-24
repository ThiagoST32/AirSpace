package com.trevisan.AirSpace.Models.Travels;

import com.trevisan.AirSpace.Dtos.Travels.RegisterTravelRequestDTO;
import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Enums.TravelStatus;
import com.trevisan.AirSpace.Models.Flights.Flights;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "travelId")
@Entity
public class Travels {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long travelId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airPort_id")
    private AirPort airPortTravel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "flightsTravel_id")
    private Flights flightsTravel;

    private TravelStatus travelStatus;

    public Travels(RegisterTravelRequestDTO requestDTO, AirPort airPort, Flights flights){
        this.airPortTravel = airPort;
        this.flightsTravel = flights;
        this.travelStatus = requestDTO.travelStatus();
    }
}
