package com.trevisan.AirSpace.Services.SeatService;

import com.trevisan.AirSpace.Dtos.Seat.SeatRegisterRequestDTO;
import com.trevisan.AirSpace.Dtos.Seat.SeatResponseDTO;
import com.trevisan.AirSpace.Models.Seat.Seat;
import com.trevisan.AirSpace.Repositories.FlightRepository.FlightRepository;
import com.trevisan.AirSpace.Repositories.SeatRepository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository, FlightRepository flightRepository) {
        this.seatRepository = seatRepository;
        this.flightRepository = flightRepository;
    }

    public SeatResponseDTO registerSeatsOnAFlights(SeatRegisterRequestDTO requestDTO){

        Seat newSeatRegister = new Seat(requestDTO);

        //Posteriormente implantar métodos de verificação antes de inserir lugares dentro do banco de dados
        var seatPersisted = seatRepository.save(newSeatRegister);

        return new SeatResponseDTO(
          seatPersisted.getSeatId(),
          seatPersisted.getSeatNumber(),
          seatPersisted.getSeatType(),
          seatPersisted.isSeatAvailable(),
          seatPersisted.getSeatValue()
        );
    }

    public List<SeatResponseDTO> getAllSeats(){
        return seatRepository.findAll()
                .stream()
                .map(this::mapToSeatResponseFromObjectDTO)
                .toList();
    }

    public List<SeatResponseDTO> getAllSeatsFromAOneFlights(Long id){
        //Buscar voos pelo ‘Id’ a partir do nome do voo
//        return flightRepository.findById(id)
//                .stream()
//                .map(this::mapToSeatResponseFromObjectDTO)
//                .toList();
        return null;
    }

    private SeatResponseDTO mapToSeatResponseFromRequestDTO(SeatRegisterRequestDTO requestDTO){

        Seat seatRequest = new Seat(requestDTO);

        return new SeatResponseDTO(
                seatRequest.getSeatId(),
                seatRequest.getSeatNumber(),
                seatRequest.getSeatType(),
                seatRequest.isSeatAvailable(),
                seatRequest.getSeatValue()
        );
    }

    private SeatResponseDTO mapToSeatResponseFromObjectDTO(Seat seat){

        Seat seatRequest = new Seat(seat);

        return new SeatResponseDTO(
                seatRequest.getSeatId(),
                seatRequest.getSeatNumber(),
                seatRequest.getSeatType(),
                seatRequest.isSeatAvailable(),
                seatRequest.getSeatValue()
        );
    }
}

