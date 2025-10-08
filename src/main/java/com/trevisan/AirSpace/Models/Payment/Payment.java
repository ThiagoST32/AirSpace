package com.trevisan.AirSpace.Models.Payment;

import com.trevisan.AirSpace.Models.Enums.PaymentMethod;
import com.trevisan.AirSpace.Models.Enums.PaymentStatus;
import com.trevisan.AirSpace.Models.Reserve.Reserve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "paymentId")
public class Payment {
    private Long paymentId;
    private Reserve reserveId;
    private PaymentMethod method;
    private BigDecimal value;
    private PaymentStatus status;
    private OffsetDateTime paymentDate;
}
