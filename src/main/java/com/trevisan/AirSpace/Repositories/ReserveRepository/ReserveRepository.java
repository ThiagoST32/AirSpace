package com.trevisan.AirSpace.Repositories.ReserveRepository;

import com.trevisan.AirSpace.Models.Reserve.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
