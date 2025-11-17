package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Plane.Requests.CreatePlaneRequestDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneDetailResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneListResponseDTO;
import com.trevisan.AirSpace.Dtos.Plane.Responses.PlaneResponseDTO;
import com.trevisan.AirSpace.Services.PlaneService.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/plane")
public class PlaneController {

    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping("/register")
    public ResponseEntity<PlaneResponseDTO>registerNewPlane(@RequestBody CreatePlaneRequestDTO requestDTO){
        return new ResponseEntity<>(planeService.registerNewPlane(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlaneListResponseDTO>>getAllPlanes(){
        return new ResponseEntity<>(planeService.getAllPlanes(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlaneDetailResponseDTO>getPlaneById(@PathVariable Long id){
        return new ResponseEntity<>(planeService.getPlaneById(id), HttpStatus.OK);
    }
}
