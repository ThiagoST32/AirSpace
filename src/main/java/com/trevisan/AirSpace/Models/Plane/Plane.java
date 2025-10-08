package com.trevisan.AirSpace.Models.Plane;

import com.trevisan.AirSpace.Models.Company.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "planeId")
public class Plane {
    private Long planeId;

    private String model;

    private Integer capacity;

    private Company companyId;
}
