package com.example.authenticationjwt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(Integer status,
                            String error,
                            List<String> errors) {
}
