package com.trevisan.AirSpace.Models.Plane;

import com.trevisan.AirSpace.Dtos.Plane.Requests.CreatePlaneRequestDTO;
import com.trevisan.AirSpace.Models.Company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "planeId")
@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planeId;

    private String modelPlane;

    private String capacity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Company company;

    public Plane (CreatePlaneRequestDTO requestDTO, Company company){
        this.modelPlane = requestDTO.modelPlane();
        this.capacity = requestDTO.capacity();
        this.company = company;
    }
}
