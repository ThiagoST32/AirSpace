package com.trevisan.AirSpace.Services.BaggageService;

import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.Response.BaggageResponseDTO;
import com.trevisan.AirSpace.Models.Baggage.Baggage;
import com.trevisan.AirSpace.Repositories.BaggageRepository.BaggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaggageRegisterService {

    private final BaggageRepository baggageRepository;

    @Autowired
    public BaggageRegisterService(BaggageRepository baggageRepository) {
        this.baggageRepository = baggageRepository;
    }

    public BaggageResponseDTO registerBaggager(BaggageRequestDTO requestDTO){
        Baggage newBaggage = new Baggage(requestDTO);

        //Implementação da Lógica por trás para os tipos de processos de bagagens

        baggageRepository.save(newBaggage);

        return new BaggageResponseDTO(
          newBaggage.getWeight(),
          newBaggage.getBaggageType(),
          newBaggage.getBaggageStatus(),
          newBaggage.getTimestampBaggage().toLocalDateTime().toLocalDate(),
          newBaggage.getTimestampBaggage().toLocalDateTime().toLocalTime().withNano(0)
        );
    }
}
