package com.trevisan.AirSpace.Models.Seat;

import com.trevisan.AirSpace.Dtos.Seat.Request.SeatRegisterRequestDTO;
import com.trevisan.AirSpace.Models.Enums.SeatType;
import com.trevisan.AirSpace.Models.Flights.Flights;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "seatId")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    private String seatNumber;

    private SeatType seatType;

    private boolean seatAvailable;

    private BigDecimal seatValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flights flight;


    public Seat(SeatRegisterRequestDTO requestDTO, Flights flight){
        this.seatNumber = requestDTO.seatNumber();
        this.seatType = requestDTO.seatType();
        this.seatAvailable = requestDTO.seatAvailable();
        this.seatValue = requestDTO.seatValue();
        this.flight = flight;
    }

    public Seat(Seat seat){
        this.seatId = seat.getSeatId();
        this.seatNumber = seat.getSeatNumber();
        this.seatType = seat.getSeatType();
        this.seatAvailable = seat.isSeatAvailable();
        this.seatValue = seat.getSeatValue();
    }
}
