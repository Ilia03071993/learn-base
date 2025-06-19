package com.selivanov.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ValidationErrorResponse(
        Integer status,
        String description,
        List<FieldError> errors
) {
}