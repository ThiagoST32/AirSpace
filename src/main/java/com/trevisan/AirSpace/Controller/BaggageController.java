package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageUpdateRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.Response.BaggageResponseDTO;
import com.trevisan.AirSpace.Services.BaggageService.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/baggage")
public class BaggageController {

    private final BaggageService baggageService;

    @Autowired
    public BaggageController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @PostMapping("registerBaggage")
    public ResponseEntity<BaggageResponseDTO>registerBaggage(@RequestBody BaggageRequestDTO requestDTO){
        return new ResponseEntity<>(baggageService.registerBaggager(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("{baggageId}")
    public ResponseEntity<BaggageResponseDTO>updateBaggage(@RequestBody BaggageUpdateRequestDTO requestDTO, @PathVariable Long baggageId){
        return new ResponseEntity<>(baggageService.updateBaggager(requestDTO, baggageId), HttpStatus.OK);
    }
}
