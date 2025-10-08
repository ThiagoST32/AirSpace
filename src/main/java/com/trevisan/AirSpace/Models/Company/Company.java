package com.trevisan.AirSpace.Models.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "companyId")
public class Company{
    private Long companyId;

    private String name;

    private String logo;

    private String contact;

    private String acronym;
}
