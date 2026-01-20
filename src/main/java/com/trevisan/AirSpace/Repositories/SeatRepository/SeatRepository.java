package com.trevisan.AirSpace.Repositories.SeatRepository;

import com.trevisan.AirSpace.Models.Seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
