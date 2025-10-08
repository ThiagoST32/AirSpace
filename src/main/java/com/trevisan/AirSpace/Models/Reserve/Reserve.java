package com.trevisan.AirSpace.Models.Reserve;

import com.trevisan.AirSpace.Models.Customer.Customer;
import com.trevisan.AirSpace.Models.Enums.ReserveStatus;
import com.trevisan.AirSpace.Models.Flights.Flights;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Reserve {
    private Long reserveId;

    private ReserveStatus reserveStatus;

    private BigDecimal totalValue;

    private Date reserveDate;

    private UUID reserveCode;

    private Seat seatId;

    private Customer customerId;

    private Flights flight;
}
