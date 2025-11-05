package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Baggage.BaggageRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.BaggageResponseDTO;
import com.trevisan.AirSpace.Services.BaggageService.BaggageRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/baggage")
public class BaggageController {

    private final BaggageRegisterService baggageRegisterService;

    @Autowired
    public BaggageController(BaggageRegisterService baggageRegisterService) {
        this.baggageRegisterService = baggageRegisterService;
    }

    @PostMapping("registerBaggage")
    public ResponseEntity<BaggageResponseDTO>registerBaggage(@RequestBody BaggageRequestDTO requestDTO){
        return new ResponseEntity<>(baggageRegisterService.registerBaggager(requestDTO), HttpStatus.CREATED);
    }
}
