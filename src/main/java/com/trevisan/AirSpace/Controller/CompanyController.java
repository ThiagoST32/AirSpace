package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Company.Requests.CreateCompanyRequestDTO;
import com.trevisan.AirSpace.Dtos.Company.Responses.CompanyDetailsResponseDTO;
import com.trevisan.AirSpace.Dtos.Company.Responses.CompanyListResponseDTO;
import com.trevisan.AirSpace.Dtos.Company.Responses.CompanySummaryDTO;
import com.trevisan.AirSpace.Services.CompanyService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/register")
    public ResponseEntity<CompanySummaryDTO>registerNewCompany(@RequestBody CreateCompanyRequestDTO requestDTO){
        return new ResponseEntity<>(companyService.registerNewCompany(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompanyListResponseDTO>>getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("{companyId}")
    public ResponseEntity<CompanyDetailsResponseDTO>getCompanyById(@PathVariable Long companyId){
        return new ResponseEntity<>(companyService.getCompanyById(companyId), HttpStatus.OK);
    }
}
