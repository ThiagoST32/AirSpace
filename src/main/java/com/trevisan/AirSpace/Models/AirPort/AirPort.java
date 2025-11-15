package com.trevisan.AirSpace.Models.AirPort;

import com.trevisan.AirSpace.Dtos.AirPort.RequestAirPortRegisterDTO;
import com.trevisan.AirSpace.Models.Flights.Flights;
import com.trevisan.AirSpace.Models.Travels.Travels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "airPortId")
@Entity
public class AirPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airPortId;

    private String name;

    private String iataCode;

    private String city;

    private String country;

    public AirPort(RequestAirPortRegisterDTO registerDTO){
        this.name = registerDTO.name();
        this.iataCode = registerDTO.iataCode();
        this.city = registerDTO.city();
        this.country = registerDTO.country();
    }

}
