package com.trevisan.AirSpace.Services.ReserveService;

import com.trevisan.AirSpace.Dtos.Reserve.Request.ReserveRequestDTO;
import com.trevisan.AirSpace.Dtos.Reserve.ReserveResponseDTO;
import com.trevisan.AirSpace.Models.Reserves.Reserve;
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
//    private final ReserveCustomerRepository reserveCustomerRepository;

    @Autowired
    public ReserveService(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    public ReserveResponseDTO registerANewReserve(ReserveRequestDTO requestDTO){

        //Implementar lógica de verificação posteriormente, no momento apenas está a servir como esqueleto do projeto
        Reserve reserveRequest = new Reserve(
                requestDTO,
                LocalDate.now(),
                LocalTime.now().withNano(0),
                UUID.randomUUID()
        );

        //Implementar lógica de verificação posteriormente, no momento apenas está a servir como esqueleto do projeto
        var reservePersisted = reserveRepository.save(reserveRequest);

        //Pega Id do usuário logado e fazer a inserção do mesmo dentro banco de dados
        //reserveCustomerRepository.save(new ReserveCustomer(userLogado.getId(), reservePersisted.getReserveId()));

        return new ReserveResponseDTO(
            reserveRequest.getTotalValue(),
            reserveRequest.getReserveDate(),
            reserveRequest.getLocalTime(),
            reserveRequest.getReserveCode()
        );
    }

    public List<ReserveResponseDTO> getReservesByUser(Long id){
//        List<Reserve> reserves = reserveRepository.findByCustomer_CustomerId(id).orElseThrow(() -> new RuntimeException("Nenhuma reserva foi encontrada!"));
        return List.of();
    }

    //Posteriormente implantar método de verificação para apenas ADMIN usarem este tipo de chamada
    public List<ReserveResponseDTO> getAllReserves(){
        return reserveRepository.findAll()
                .stream()
                .map(this::mapToReserveResponseDTO)
                .toList();
    }


    private ReserveResponseDTO mapToReserveResponseDTO(Reserve reserve){
        return new ReserveResponseDTO(
                reserve.getTotalValue(),
                reserve.getReserveDate(),
                reserve.getLocalTime(),
                reserve.getReserveCode()
        );
    }
}
