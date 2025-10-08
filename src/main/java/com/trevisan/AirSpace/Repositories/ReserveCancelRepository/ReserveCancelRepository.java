package com.trevisan.AirSpace.Repositories.ReserveCancelRepository;

import com.trevisan.AirSpace.Models.ReserveCancel.ReserveCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveCancelRepository extends JpaRepository<ReserveCancel, Long> {
}
