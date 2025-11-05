package com.trevisan.AirSpace.Repositories.BaggageRepository;

import com.trevisan.AirSpace.Models.Baggage.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Long> {
}
