package com.selivanov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CourseDto(
        Integer id,
        @Column(unique = true)
        @Size(min = 1, max = 21, message = "Name should be from 3 to 21 symbols")
        String name
) {
}
