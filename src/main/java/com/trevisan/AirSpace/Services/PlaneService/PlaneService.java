package com.trevisan.AirSpace.Services.PlaneService;

import com.trevisan.AirSpace.Dtos.Company.Responses.CompanySummaryDTO;
import com.trevisan.AirSpace.Dtos.Plane.Requests.CreatePlaneRequestDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneDetailResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneListResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneResponseDTO;
import com.trevisan.AirSpace.Models.Company.Company;
import com.trevisan.AirSpace.Models.Plane.Plane;
import com.trevisan.AirSpace.Repositories.CompanyRepository.CompanyRepository;
import com.trevisan.AirSpace.Repositories.PlaneRepository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository, CompanyRepository companyRepository) {
        this.planeRepository = planeRepository;
        this.companyRepository = companyRepository;
    }

    public PlaneResponseDTO registerNewPlane(CreatePlaneRequestDTO requestDTO){
        Company companyRequestedToPlane = companyRepository.findById(requestDTO.companyId()).orElseThrow();
        Plane planeRequested = new Plane(requestDTO, companyRequestedToPlane);

        var planePersisted = planeRepository.save(planeRequested);

        return new PlaneResponseDTO(
                planePersisted.getPlaneId(),
                planePersisted.getModelPlane(),
                planePersisted.getCapacity(),
                mapToCompanySummaryDTO(planePersisted.getCompany())
        );
    }

    public List<PlaneListResponseDTO> getAllPlanes(){
        return planeRepository.findAll()
                .stream()
                .map(this::mapToPlaneSummaryDTO)
                .toList();
    }

    public PlaneDetailResponseDTO getPlaneById(Long id){
        Plane planeFound = planeRepository.findById(id).orElseThrow();
        return new PlaneDetailResponseDTO(
                planeFound.getPlaneId(),
                planeFound.getModelPlane(),
                planeFound.getCapacity(),
                mapToCompanySummaryDTO(planeFound.getCompany())
        );
    }

    private PlaneListResponseDTO mapToPlaneSummaryDTO(Plane plane){
        return new PlaneListResponseDTO(
                plane.getPlaneId(),
                plane.getModelPlane(),
                plane.getCapacity(),
                mapToCompanySummaryDTO(plane.getCompany())
        );
    }

    private CompanySummaryDTO mapToCompanySummaryDTO(Company company){
        return new CompanySummaryDTO(
                company.getCompanyId(),
                company.getCompanyName(),
                company.getCompanyLogo(),
                company.getCompanyContact(),
                company.getCompanyAcronym()
        );
    }
}
