package com.trevisan.AirSpace.Services.ReserveService;

import com.trevisan.AirSpace.Dtos.Customer.CustomerGetResponseDTO;
import com.trevisan.AirSpace.Dtos.Reserve.ReserveRequestDTO;
import com.trevisan.AirSpace.Dtos.Reserve.ReserveResponseDTO;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Models.Reserves.Reserve;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import com.trevisan.AirSpace.Repositories.ReserveRepository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ReserveService(ReserveRepository repository, ReserveRepository reserveRepository, CustomerRepository customerRepository) {
        this.reserveRepository = reserveRepository;
        this.customerRepository = customerRepository;
    }

    public ReserveResponseDTO registerANewReserve(ReserveRequestDTO requestDTO){

        Customer customer = customerRepository.findCustomerByName(requestDTO.customerName()).orElseThrow();

        CustomerGetResponseDTO customerResponse = new CustomerGetResponseDTO(
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getDateOfBirth()
        );

        Reserve reserveRequest = new Reserve(
                requestDTO,
                LocalDate.now(),
                LocalTime.now().withNano(0),
                UUID.randomUUID(),
                customer
        );

        reserveRepository.save(reserveRequest);

        return new ReserveResponseDTO(
            reserveRequest.getTotalValue(),
            reserveRequest.getReserveDate(),
            reserveRequest.getLocalTime(),
            reserveRequest.getReserveCode(),
            customerResponse
        );
    }

    public List<ReserveResponseDTO> getReservesByUser(Long id){
        List<Reserve> reserves = reserveRepository.findByCustomer_CustomerId(id).orElseThrow(() -> new RuntimeException("Nenhuma reserva foi encontrada!"));
        return reserves.stream()
                .map(this::mapToReserveResponseDTO)
                .toList();
    }

    public List<ReserveResponseDTO> getAllReserves(){
        return reserveRepository.findAll()
                .stream()
                .map(this::mapToReserveResponseDTO)
                .toList();
    }


    private ReserveResponseDTO mapToReserveResponseDTO(Reserve reserve){
        Customer customer = this.customerRepository.findById(reserve.getCustomer().getCustomerId()).orElseThrow();

        CustomerGetResponseDTO customerResponse = new CustomerGetResponseDTO(
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getDateOfBirth()
        );
        return new ReserveResponseDTO(
                reserve.getTotalValue(),
                reserve.getReserveDate(),
                reserve.getLocalTime(),
                reserve.getReserveCode(),
                customerResponse
        );
    }
}
