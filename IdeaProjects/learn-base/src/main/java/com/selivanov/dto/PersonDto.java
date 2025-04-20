package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
public record PersonDto(
        Integer id,
        @NotNull(message = "Name cannot be null")
        @NotBlank(message = "Name cannot be empty or blank")
        String name,
        Integer passportId
) {
}
