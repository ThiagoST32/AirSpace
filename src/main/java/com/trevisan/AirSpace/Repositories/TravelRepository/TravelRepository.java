package com.trevisan.AirSpace.Repositories.TravelRepository;

import com.trevisan.AirSpace.Models.Travels.Travels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travels, Long> {
}
