package com.trevisan.AirSpace.Repositories.CompanyRepository;

import com.trevisan.AirSpace.Models.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
