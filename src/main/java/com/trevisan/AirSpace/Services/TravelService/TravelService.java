package com.trevisan.AirSpace.Services.TravelService;

import com.trevisan.AirSpace.Dtos.AirPort.Response.ResponseAirPortDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseFlightDTO;
import com.trevisan.AirSpace.Dtos.Travels.Requests.RegisterTravelRequestDTO;
import com.trevisan.AirSpace.Dtos.Travels.Responses.ResponseGetAllTravels;
import com.trevisan.AirSpace.Dtos.Travels.Responses.ResponseRegisterTravelDTO;
import com.trevisan.AirSpace.Models.AirPort.AirPort;
import com.trevisan.AirSpace.Models.Flights.Flights;
import com.trevisan.AirSpace.Models.Travels.Travels;
import com.trevisan.AirSpace.Repositories.AirPortRepository.AirPortRepository;
import com.trevisan.AirSpace.Repositories.FlightRepository.FlightRepository;
import com.trevisan.AirSpace.Repositories.TravelRepository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                mapProxyHibernateToEntityAirPort(travels),
                mapProxyHibernateToEntityFlights(travels),
                travels.getTravelStatus()
        );
    }

    private ResponseAirPortDTO mapProxyHibernateToEntityAirPort(Travels travels){
        AirPort airPortTravel = travels.getAirPortTravel();
        return new ResponseAirPortDTO(
            airPortTravel.getName(),
            airPortTravel.getIataCode(),
            airPortTravel.getCity(),
            airPortTravel.getCountry()
        );
    }

    private ResponseFlightDTO mapProxyHibernateToEntityFlights(Travels travels){
        Flights flightsTravel = travels.getFlightsTravel();
        return new ResponseFlightDTO(
            flightsTravel.getDepartureTime(),
            flightsTravel.getArrivalTime(),
            flightsTravel.getFlightNumber(),
            flightsTravel.getFlightsClass(),
            flightsTravel.getFlightsStatus(),
            flightsTravel.isFlightsAvailable()
        );
    }
}
