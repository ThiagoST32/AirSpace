package com.trevisan.AirSpace.Services.PlaneService;

import com.trevisan.AirSpace.Dtos.Plane.Requests.CreatePlaneRequestDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneDetailResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneListResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneSummaryDTO;
import com.trevisan.AirSpace.Models.Plane.Plane;
import com.trevisan.AirSpace.Repositories.PlaneRepository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public PlaneResponseDTO registerNewPlane(CreatePlaneRequestDTO requestDTO){
        Plane planeRequested = new Plane(requestDTO);

        var planePersisted = planeRepository.save(planeRequested);

        return new PlaneResponseDTO(
                planePersisted.getPlaneId(),
                planePersisted.getModelPlane(),
                planePersisted.getCapacity()
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
                planeFound.getCapacity()
        );
    }

    private PlaneListResponseDTO mapToPlaneSummaryDTO(Plane plane){
        return new PlaneListResponseDTO(
                plane.getPlaneId(),
                plane.getModelPlane(),
                plane.getCapacity()
        );
    }
}
