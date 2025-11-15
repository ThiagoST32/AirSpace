package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Travels.RegisterTravelRequestDTO;
import com.trevisan.AirSpace.Dtos.Travels.ResponseGetAllTravels;
import com.trevisan.AirSpace.Dtos.Travels.ResponseRegisterTravelDTO;
import com.trevisan.AirSpace.Services.TravelService.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/travels")
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterTravelDTO>registerANewTravel(@RequestBody RegisterTravelRequestDTO requestDTO){
        return new ResponseEntity<>(travelService.registerANewTravelForAFlight(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseGetAllTravels>>getAllTravels(){
        return new ResponseEntity<>(travelService.getAllTravels(), HttpStatus.OK);
    }
}
