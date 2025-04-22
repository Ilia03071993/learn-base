package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EmployeeDto(
        Integer id,
        String name,
        String job,
        DepartmentDto department
) {
}