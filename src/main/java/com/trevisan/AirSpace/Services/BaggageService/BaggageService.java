package com.trevisan.AirSpace.Services.BaggageService;

import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.Requests.BaggageUpdateRequestDTO;
import com.trevisan.AirSpace.Dtos.Baggage.Response.BaggageResponseDTO;
import com.trevisan.AirSpace.Models.Baggage.Baggage;
import com.trevisan.AirSpace.Models.Baggage.CustomerBaggage;
import com.trevisan.AirSpace.Models.Customers.Customer;
import com.trevisan.AirSpace.Repositories.BaggageRepository.BaggageRepository;
import com.trevisan.AirSpace.Repositories.BaggageRepository.CustomerBaggageRepository;
import com.trevisan.AirSpace.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaggageService {

    private final BaggageRepository baggageRepository;
    private final CustomerBaggageRepository customerBaggageRepository;

    @Autowired
    public BaggageService(BaggageRepository baggageRepository, CustomerBaggageRepository customerBaggageRepository) {
        this.baggageRepository = baggageRepository;
        this.customerBaggageRepository = customerBaggageRepository;
    }

    public BaggageResponseDTO registerBaggager(BaggageRequestDTO requestDTO){
        Baggage newBaggage = new Baggage(requestDTO);

        //Implementação da Lógica por trás para os tipos de processos de bagagens
        if (requestDTO.itens().isEmpty()){
            newBaggage.setTotalItens(0);
        } else {
            newBaggage.setTotalItens(requestDTO.itens().size());
        }

        var baggagePersisted = baggageRepository.save(newBaggage);

        //Futuramente implantar cadastro de CustomerBaggage pegando o id do usuário logado com o novo Id da Bagagem Persistida
//        customerBaggageRepository.save(new CustomerBaggage(usuarioLogado.getId(), baggagePersisted.getBaggageId()));

        return new BaggageResponseDTO(
                newBaggage.getWeight(),
                newBaggage.getBaggageType(),
                newBaggage.getBaggageStatus(),
                newBaggage.getBaggageCode(),
                newBaggage.getBaggageHigh(),
                newBaggage.getBaggageWidth(),
                newBaggage.getTimestampBaggage().toLocalDateTime().toLocalDate(),
                newBaggage.getTimestampBaggage().toLocalDateTime().toLocalTime().withNano(0),
                newBaggage.getItens(),
                newBaggage.getTotalItens()
        );
    }

    public BaggageResponseDTO updateBaggager(BaggageUpdateRequestDTO requestDTO, Long id){
        //Implementar uma verificação futura para verificar se o usuário logado é dono da bagagem especificada
//        if (!customerBaggageRepository.findUserBaggageRequested(id)){
//            throw new RuntimeException("Não existe usuário vinculado a esta bagagem!");
//        }
        Baggage baggageRequested = baggageRepository.findById(id).orElseThrow();

        baggageRequested.setBaggageType(requestDTO.baggageType());
        baggageRequested.setBaggageHigh(requestDTO.baggageHigh());
        baggageRequested.setBaggageWidth(requestDTO.baggageWidth());
        baggageRequested.setItens(requestDTO.itens());
        baggageRequested.setTotalItens(requestDTO.itens().size());

        //Verificações a serem criadas posteriormente
        var baggagePersisted = baggageRepository.save(baggageRequested);

        return new BaggageResponseDTO(
                baggagePersisted.getWeight(),
                baggagePersisted.getBaggageType(),
                baggagePersisted.getBaggageStatus(),
                baggagePersisted.getBaggageCode(),
                baggagePersisted.getBaggageHigh(),
                baggagePersisted.getBaggageWidth(),
                baggagePersisted.getTimestampBaggage().toLocalDateTime().toLocalDate(),
                baggagePersisted.getTimestampBaggage().toLocalDateTime().toLocalTime().withNano(0),
                baggagePersisted.getItens(),
                baggagePersisted.getTotalItens()
        );
    }
}
