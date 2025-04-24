package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
public record PersonDto(
        Integer id,
        @NotNull(message = "Name cannot be null")
        @NotBlank(message = "Name cannot be empty or blank")
        @NotNull(message = "Name cannot be null")
        @NotBlank(message = "Name cannot be empty or blank")
        @Size(min = 1, max = 21, message = "Name should be from 1 to 21 symbols")
        String name,
        Integer passportId
) {
}
