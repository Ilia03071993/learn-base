package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
public record PersonDto(
        Integer id,
        String name,
        Integer passportId
) {
}
