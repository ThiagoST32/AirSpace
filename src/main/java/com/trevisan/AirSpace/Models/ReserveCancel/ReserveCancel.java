package com.trevisan.AirSpace.Models.ReserveCancel;

import com.trevisan.AirSpace.Models.Enums.ReasonReserveCancel;
import com.trevisan.AirSpace.Models.Enums.RefundReserveCancelStatus;
import com.trevisan.AirSpace.Models.Reserve.Reserve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "reserveCancelId")
public class ReserveCancel {
    private Long reserveCancelId;
    private Reserve reserveId;
    private ReasonReserveCancel reason;
    private OffsetDateTime cancelTime;
    private BigDecimal valueRefund;
    private RefundReserveCancelStatus refundStatus;
}
