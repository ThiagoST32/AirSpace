package com.trevisan.AirSpace.Dtos.Plane.Responses;

import com.trevisan.AirSpace.Dtos.Company.Responses.CompanySummaryDTO;

public record PlaneSummaryDTO(Long id, String modelPlane, String capacity, CompanySummaryDTO companySummaryDTO) {
}
