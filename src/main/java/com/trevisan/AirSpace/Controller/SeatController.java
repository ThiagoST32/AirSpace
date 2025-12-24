package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Seat.Request.SeatRegisterRequestDTO;
import com.trevisan.AirSpace.Dtos.Seat.SeatResponseDTO;
import com.trevisan.AirSpace.Services.SeatService.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/register")
    public ResponseEntity<SeatResponseDTO>registerANewSeat(@RequestBody SeatRegisterRequestDTO requestDTO){
        return new ResponseEntity<>(seatService.registerSeatsOnAFlights(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SeatResponseDTO>>getAllSeats(){
        return new ResponseEntity<>(seatService.getAllSeats(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<SeatResponseDTO>>getAllSeatsFromAOneFlight(@PathVariable Long id){
        return new ResponseEntity<>(seatService.getAllSeatsFromAOneFlights(id), HttpStatus.OK);
    }
}
