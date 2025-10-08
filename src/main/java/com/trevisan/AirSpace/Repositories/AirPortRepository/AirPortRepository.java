package com.trevisan.AirSpace.Repositories.AirPortRepository;

import com.trevisan.AirSpace.Models.AirPort.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPortRepository extends JpaRepository<AirPort, Long> {
}
