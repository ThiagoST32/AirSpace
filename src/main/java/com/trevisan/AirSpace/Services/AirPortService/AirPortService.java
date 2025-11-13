package com.trevisan.AirSpace.Services.AirPortService;

import com.trevisan.AirSpace.Dtos.AirPort.RequestAirPortRegisterDTO;
import com.trevisan.AirSpace.Dtos.AirPort.ResponseAirPortRegisterDTO;
import com.trevisan.AirSpace.Dtos.AirPort.ResponseGetAirPortByIdDTO;
import com.trevisan.AirSpace.Dtos.AirPort.ResponseGetAllAirPortDTO;
import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Repositories.AirPortRepository.AirPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPortService {

    private final AirPortRepository airPortRepository;

    @Autowired
    public AirPortService(AirPortRepository airPortRepository) {
        this.airPortRepository = airPortRepository;
    }

    public ResponseAirPortRegisterDTO registerAirPort(RequestAirPortRegisterDTO registerDTO) {

        AirPort newAirPort = new AirPort(registerDTO);

        var newAirPortPersisted = airPortRepository.save(newAirPort);

        return new ResponseAirPortRegisterDTO(
                newAirPortPersisted.getName(),
                newAirPortPersisted.getIataCode(),
                newAirPortPersisted.getCity(),
                newAirPortPersisted.getCountry()
        );
    }


    public List<ResponseGetAllAirPortDTO> getAllAirPortDTO(){
        return airPortRepository.findAll()
                .stream()
                .map(this::mapToResponseGetAllAirPorts)
                .toList();
    }

    public ResponseGetAirPortByIdDTO getAirPortById(Long id){
        AirPort airPortResponse = airPortRepository.findById(id).orElseThrow();
        return new ResponseGetAirPortByIdDTO(
                airPortResponse.getName(),
                airPortResponse.getIataCode(),
                airPortResponse.getCity(),
                airPortResponse.getCountry()
        );
    }


    private ResponseGetAllAirPortDTO mapToResponseGetAllAirPorts(AirPort airPort){
        return new ResponseGetAllAirPortDTO(
                airPort.getName(),
                airPort.getIataCode(),
                airPort.getCity(),
                airPort.getCountry()
        );
    }

    private ResponseGetAirPortByIdDTO mapToResponseGetAirPortById(AirPort airPort){
        return new ResponseGetAirPortByIdDTO(
                airPort.getName(),
                airPort.getIataCode(),
                airPort.getCity(),
                airPort.getCountry()
        );
    }
}
