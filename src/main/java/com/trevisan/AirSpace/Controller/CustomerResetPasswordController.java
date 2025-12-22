package com.trevisan.AirSpace.Controller;

import com.trevisan.AirSpace.Dtos.Customer.Requests.ResetPasswordRequestConfirmedDTO;
import com.trevisan.AirSpace.Dtos.Customer.Requests.ResetPasswordRequestDTO;
import com.trevisan.AirSpace.Services.CustomerService.CustomerResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pass")
public class CustomerResetPasswordController {
    private final CustomerResetPasswordService passwordService;

    @Autowired
    public CustomerResetPasswordController(CustomerResetPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("request")
    public ResponseEntity<String>requestReset(@RequestBody ResetPasswordRequestDTO requestDTO){
        return new ResponseEntity<>(passwordService.requestPasswordReset(requestDTO.email()), HttpStatus.OK);
    }

    @PostMapping("reset")
    public ResponseEntity<String>resetPassword(@RequestBody ResetPasswordRequestConfirmedDTO requestConfirmedDTO){
        return new ResponseEntity<>(passwordService.resetPassword(requestConfirmedDTO.token(), requestConfirmedDTO.password()), HttpStatus.OK);
    }
}
