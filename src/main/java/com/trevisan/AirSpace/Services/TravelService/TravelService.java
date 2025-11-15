package com.trevisan.AirSpace.Services.TravelService;

import com.trevisan.AirSpace.Dtos.Travels.RegisterTravelRequestDTO;
import com.trevisan.AirSpace.Dtos.Travels.ResponseGetAllTravels;
import com.trevisan.AirSpace.Dtos.Travels.ResponseRegisterTravelDTO;
import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Flights.Flights;
import com.trevisan.AirSpace.Models.Travels.Travels;
import com.trevisan.AirSpace.Repositories.AirPortRepository.AirPortRepository;
import com.trevisan.AirSpace.Repositories.FlightRepository.FlightRepository;
import com.trevisan.AirSpace.Repositories.TravelRepository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelService {

    private final TravelRepository travelRepository;
    private final AirPortRepository airPortRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public TravelService(TravelRepository travelRepository, AirPortRepository airPortRepository, FlightRepository flightRepository) {
        this.travelRepository = travelRepository;
        this.airPortRepository = airPortRepository;
        this.flightRepository = flightRepository;
    }

    public ResponseRegisterTravelDTO registerANewTravelForAFlight(RegisterTravelRequestDTO requestDTO){

        AirPort airPortRequested = airPortRepository.findById(requestDTO.idAirPort()).orElseThrow();
        Flights flightsRequested = flightRepository.findById(requestDTO.idFlight()).orElseThrow();
        Travels travelRequested = new Travels(requestDTO, airPortRequested, flightsRequested);

        var travelsPersisted = travelRepository.save(travelRequested);

        return mapToResponseRegister(travelsPersisted);
    }

    public List<ResponseGetAllTravels>getAllTravels(){
        return travelRepository.findAll()
                .stream()
                .map(this::mapToResponseGetAllTravels)
                .toList();
    }


    private ResponseRegisterTravelDTO mapToResponseRegister(Travels travel){
        return new ResponseRegisterTravelDTO(
                travel.getTravelStatus(),
                travel.getAirPortTravel(),
                travel.getFlightsTravel()
        );
    }

    private ResponseGetAllTravels mapToResponseGetAllTravels(Travels travels){
        return new ResponseGetAllTravels(
                travels.getTravelId(),
                travels.getAirPortTravel(),
                travels.getFlightsTravel(),
                travels.getTravelStatus()
        );
    }
}
