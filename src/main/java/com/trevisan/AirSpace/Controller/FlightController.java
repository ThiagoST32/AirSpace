package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Flights.*;
import com.trevisan.AirSpace.Services.FlightsService.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterFlightDTO>registerNewFlights(@RequestBody RequestRegisterFlightDTO flightDTO){
        return new ResponseEntity<>(flightService.registerNewFlight(flightDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseAllFlightsDTO>>getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/isAvailable")
    public ResponseEntity<List<ResponseAvailableFlightsDTO>>getAllFlightsAvailable(){
        return new ResponseEntity<>(flightService.getAllAvailableFlights(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/flightsWithSeats")
    public ResponseEntity<List<ResponseAllFlightsWithSeatsDTO>> getAllFlightsWithSeats(){
        return new ResponseEntity<>(flightService.getAllFlightsWithSeats(), HttpStatus.ACCEPTED);
    }

}
