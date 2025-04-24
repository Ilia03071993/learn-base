package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CourseDto(
        Integer id,
        @Column(unique = true)
        String name
) {
}
