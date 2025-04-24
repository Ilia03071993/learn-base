package com.selivanov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StudentDto(
        Integer id,
        String name,
        List<CourseDto> courses
) {
}
