package com.trevisan.AirSpace.Models.Company;

import com.trevisan.AirSpace.Dtos.Company.Requests.CreateCompanyRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "companyId")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;

    private String companyLogo;

    private String companyContact;

    private String companyAcronym;

    public Company(CreateCompanyRequestDTO requestDTO){
        this.companyName = requestDTO.companyName();
        this.companyLogo = requestDTO.companyLogo();
        this.companyContact = requestDTO.companyContact();
        this.companyAcronym = requestDTO.companyAcronym();
    }
}
