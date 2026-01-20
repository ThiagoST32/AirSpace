package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Reserve.Request.ReserveRequestDTO;
import com.trevisan.AirSpace.Dtos.Reserve.ReserveResponseDTO;
import com.trevisan.AirSpace.Services.ReserveService.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reserves")
public class ReserveController {

    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping("register")
    public ResponseEntity<ReserveResponseDTO>registerANewReserve(@RequestBody ReserveRequestDTO requestDTO){
        return new ResponseEntity<>(reserveService.registerANewReserve(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ReserveResponseDTO>> getReserveByCustomer(@PathVariable Long id){
        return new ResponseEntity<>(reserveService.getReservesByUser(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReserveResponseDTO>>getAllReserves(){
        return new ResponseEntity<>(reserveService.getAllReserves(), HttpStatus.OK);
    }
}
