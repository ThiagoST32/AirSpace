package com.trevisan.AirSpace.Services.FlightsService;

import com.trevisan.AirSpace.Dtos.Flights.RequestRegisterFlightDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseAllFlightsDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseAvailableFlightsDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseRegisterFlightDTO;
import com.trevisan.AirSpace.Dtos.Seat.SeatResponseDTO;
import com.trevisan.AirSpace.Dtos.Seat.SeatResponseFlightDTO;
import com.trevisan.AirSpace.Models.Flights.Flights;
import com.trevisan.AirSpace.Models.Seat.Seat;
import com.trevisan.AirSpace.Repositories.FlightRepository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public ResponseRegisterFlightDTO registerNewFlight(RequestRegisterFlightDTO flightDTO){

        Flights newFlightRequested = new Flights(flightDTO);

        var newFlightPersisted = flightRepository.save(newFlightRequested);

        return mapToRegisterResponseFromObject(newFlightPersisted);
    }

    public List<ResponseAllFlightsDTO> getAllFlights(){
        return flightRepository.findAll()
                .stream()
                .map(this::mapToFlightsFromObject)
                .toList();
    }

    public List<ResponseAvailableFlightsDTO> getAllAvailableFlights(){
        return flightRepository.findByFlightsAvailableTrue()
                .stream()
                .map(this::mapToAvailableFlightsFromObject)
                .toList();
    }

    private ResponseRegisterFlightDTO mapToRegisterResponseFromObject(Flights flights){
        return new ResponseRegisterFlightDTO(
                flights.getFlightId(),
                flights.getDepartureTime(),
                flights.getArrivalTime(),
                flights.getFlightNumber(),
                flights.getFlightsClass(),
                flights.getFlightsStatus(),
                flights.isFlightsAvailable()
        );
    }

    private ResponseAvailableFlightsDTO mapToAvailableFlightsFromObject(Flights flights){
        return new ResponseAvailableFlightsDTO(
                flights.getFlightId(),
                flights.getDepartureTime(),
                flights.getArrivalTime(),
                flights.getFlightNumber(),
                flights.getFlightsClass(),
                flights.getFlightsStatus(),
                flights.isFlightsAvailable(),
                mapToSeatResponseFromObject(flights.getSeat())
        );
    }

    private ResponseAllFlightsDTO mapToFlightsFromObject(Flights flights){
        return new ResponseAllFlightsDTO(
                flights.getFlightId(),
                flights.getDepartureTime(),
                flights.getArrivalTime(),
                flights.getFlightNumber(),
                flights.getFlightsClass(),
                flights.getFlightsStatus(),
                flights.isFlightsAvailable(),
                mapToSeatResponseFromObject(flights.getSeat())
        );
    }

    private List<SeatResponseFlightDTO> mapToSeatResponseFromObject(List<Seat> seats){
        return seats.stream()
                .map(seat -> new SeatResponseFlightDTO(
                        seat.getSeatId(),
                        seat.getSeatNumber(),
                        seat.getSeatType(),
                        seat.isSeatAvailable(),
                        seat.getSeatValue()
                )).collect(Collectors.toList());
    }
}
