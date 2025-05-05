package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
public record PassportDto(
        Integer id,
        @NotNull(message = "Number cannot be null")
        @Min(value = 100000, message = "Number must be at least 6 digits")
        @Max(value = 9999999999999L, message = "Number must be at most 13 digits")
        Integer number,
        @NotNull(message = "Series cannot be null")
        @Min(value = 1000, message = "Series must be exactly 4 digits")
        @Max(value = 9999, message = "Series must be exactly 4 digits")
        Integer series
) {
}