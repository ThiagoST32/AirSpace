package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.AirPort.RequestAirPortRegisterDTO;
import com.trevisan.AirSpace.Dtos.AirPort.ResponseAirPortRegisterDTO;
import com.trevisan.AirSpace.Dtos.AirPort.ResponseGetAirPortByIdDTO;
import com.trevisan.AirSpace.Dtos.AirPort.ResponseGetAllAirPortDTO;
import com.trevisan.AirSpace.Services.AirPortService.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airPort")
public class AirPortController {

    private final AirPortService airPortService;

    @Autowired
    public AirPortController(AirPortService airPortService) {
        this.airPortService = airPortService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseAirPortRegisterDTO>registerANewAirPort(@RequestBody RequestAirPortRegisterDTO registerDTO){
        return new ResponseEntity<>(airPortService.registerAirPort(registerDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseGetAllAirPortDTO>>getAllAirPorts(){
        return new ResponseEntity<>(airPortService.getAllAirPortDTO(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseGetAirPortByIdDTO>getAirPortById(@PathVariable Long id){
        return new ResponseEntity<>(airPortService.getAirPortById(id), HttpStatus.OK);
    }
}
