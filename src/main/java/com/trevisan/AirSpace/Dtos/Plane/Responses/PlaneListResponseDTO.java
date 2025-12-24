package com.trevisan.AirSpace.Dtos.Plane.Responses;

import com.trevisan.AirSpace.Dtos.Company.Responses.CompanySummaryDTO;

public record PlaneListResponseDTO(Long planeId, String modelPlane, String capacity, CompanySummaryDTO companySummaryDTO) {
}
