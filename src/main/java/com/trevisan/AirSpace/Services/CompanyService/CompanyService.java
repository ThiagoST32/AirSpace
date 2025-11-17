package com.trevisan.AirSpace.Services.CompanyService;

import com.trevisan.AirSpace.Dtos.Company.Requests.CreateCompanyRequestDTO;
import com.trevisan.AirSpace.Dtos.Company.Responses.CompanyDetailsResponseDTO;
import com.trevisan.AirSpace.Dtos.Company.Responses.CompanyListResponseDTO;
import com.trevisan.AirSpace.Dtos.Company.Responses.CompanySummaryDTO;
import com.trevisan.AirSpace.Models.Company.Company;
import com.trevisan.AirSpace.Repositories.CompanyRepository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanySummaryDTO registerNewCompany(CreateCompanyRequestDTO requestDTO){
        Company companyRequested = new Company(requestDTO);

        var companyPersisted = companyRepository.save(companyRequested);

        return new CompanySummaryDTO(
                companyPersisted.getCompanyId(),
                companyPersisted.getCompanyName(),
                companyPersisted.getCompanyLogo(),
                companyPersisted.getCompanyContact(),
                companyPersisted.getCompanyAcronym()
        );
    }

    public List<CompanyListResponseDTO> getAllCompanies(){
        return companyRepository.findAll()
                .stream()
                .map(this::mapToCompanyListResponse)
                .toList();
    }

    public CompanyDetailsResponseDTO getCompanyById(Long id){
        Company companyRequested = companyRepository.findById(id).orElseThrow();

        return new CompanyDetailsResponseDTO(
                companyRequested.getCompanyId(),
                companyRequested.getCompanyName(),
                companyRequested.getCompanyLogo(),
                companyRequested.getCompanyContact(),
                companyRequested.getCompanyAcronym()
        );
    }

    private CompanyListResponseDTO mapToCompanyListResponse(Company company){
        return new CompanyListResponseDTO(
                company.getCompanyId(),
                company.getCompanyName(),
                company.getCompanyLogo(),
                company.getCompanyContact(),
                company.getCompanyAcronym()
        );
    }
}
