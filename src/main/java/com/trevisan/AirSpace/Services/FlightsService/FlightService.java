package com.trevisan.AirSpace.Services.FlightsService;

import com.trevisan.AirSpace.Dtos.Flights.RequestRegisterFlightDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseAllFlightsDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseAvailableFlightsDTO;
import com.trevisan.AirSpace.Dtos.Flights.ResponseRegisterFlightDTO;
import com.trevisan.AirSpace.Models.Flights.Flights;
import com.trevisan.AirSpace.Models.Seat.Seat;
import com.trevisan.AirSpace.Repositories.FlightRepository.FlightRepository;
import com.trevisan.AirSpace.Repositories.SeatRepository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, SeatRepository seatRepository) {
        this.flightRepository = flightRepository;
        this.seatRepository = seatRepository;
    }

    public ResponseRegisterFlightDTO registerNewFlight(RequestRegisterFlightDTO flightDTO){

        Seat seatsToActualFlight = seatRepository.findById(flightDTO.seat_id()).orElseThrow();
        Flights newFlightRequested = new Flights(flightDTO, seatsToActualFlight);

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
                flights.isFlightsAvailable(),
                flights.getSeats()
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
                flights.getSeats()
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
                flights.getSeats()
        );
    }
}
