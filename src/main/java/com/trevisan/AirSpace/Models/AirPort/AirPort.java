package com.trevisan.AirSpace.Models.AirPort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "airPortId")
public class AirPort {
    private Long airPortId;

    private String name;

    private String iataCode;

    private String city;

    private String country;

    private String coordinates;
}
