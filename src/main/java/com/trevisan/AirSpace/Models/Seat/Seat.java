package com.trevisan.AirSpace.Models.Seat;

import com.trevisan.AirSpace.Models.Enums.SeatType;
import com.trevisan.AirSpace.Models.Flights.Flights;

import java.math.BigDecimal;

public class Seat {
    private Long seatId;

    private String seatNumber;

    private SeatType seatType;

    private boolean seatAvailable;

    private BigDecimal seatValue;

    private Flights flightId;
}
