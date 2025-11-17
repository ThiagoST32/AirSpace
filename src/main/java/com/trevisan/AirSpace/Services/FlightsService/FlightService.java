package com.trevisan.AirSpace.Services.FlightsService;

import com.trevisan.AirSpace.Dtos.Flights.*;
import com.trevisan.AirSpace.Dtos.Flights.Request.RequestRegisterFlightDTO;
import com.trevisan.AirSpace.Dtos.Seat.SeatResponseFlightDTO;
import com.trevisan.AirSpace.Dtos.Travels.Responses.TravelResponseFlightDTO;
import com.trevisan.AirSpace.Models.Flights.Flights;
import com.trevisan.AirSpace.Models.Seat.Seat;
import com.trevisan.AirSpace.Models.Travels.Travels;
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

    public List<ResponseAllFlightsWithSeatsDTO> getAllFlightsWithSeats(){
        return flightRepository.findAllFlightsWithSeats()
                .stream()
                .map(this::mapAllFlightsWithSeats)
                .toList();
    }

    public List<ResponseFlightsWithAvailableSeatsDTO> getAllFlightsAvailableSeats(){
        return flightRepository.findAllFlightsWithAvailableSeats()
                .stream()
                .map(this::mapAllFlightsWithAvailableSeats)
                .toList();
    }

    public List<ResponseFlightsWithSeatsByIdDTO> getFlightsWithSeatsById(Long id){
        return flightRepository.findFlightWithSeatsById(id)
                .stream()
                .map(this::mapFlightsWithSeatsById)
                .toList();
    }

    public List<ResponseFlightByIdDTO> getFlightsById(Long id){
        return flightRepository.findById(id)
                .stream()
                .map(this::mapFlightsById)
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
//                mapToTravelsResponseFromObject(flights.getTravels())
        );
    }

    private ResponseAllFlightsWithSeatsDTO mapAllFlightsWithSeats(Flights flights){
        return new ResponseAllFlightsWithSeatsDTO(
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

    private ResponseFlightsWithAvailableSeatsDTO mapAllFlightsWithAvailableSeats(Flights flights){
        return new ResponseFlightsWithAvailableSeatsDTO(
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

    private ResponseFlightsWithSeatsByIdDTO mapFlightsWithSeatsById(Flights flights){
        return new ResponseFlightsWithSeatsByIdDTO(
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

    private ResponseFlightByIdDTO mapFlightsById(Flights flights){
        return new ResponseFlightByIdDTO(
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

    private List<TravelResponseFlightDTO> mapToTravelsResponseFromObject(List<Travels> travels){
        return travels.stream()
                .map( travel -> new TravelResponseFlightDTO(
                        travel.getTravelId(),
                        travel.getAirPortTravel(),
                        travel.getTravelStatus()
                )).collect(Collectors.toList());
    }
}
