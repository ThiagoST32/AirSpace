package com.trevisan.AirSpace.Dtos.Plane.Requests;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreatePlaneRequestDTO(
        @NotNull
        @NotBlank
        @NotEmpty(message = "Model plano cannot be empty!")
        String modelPlane,
        @NotNull
        @NotBlank
        @NotEmpty(message = "Model plano cannot be empty!")
        String capacity,
        @NotNull
        @NotBlank
        @NegativeOrZero(message = "Company id cannot be 0 or less than 0!")
        Long companyId) {
}
