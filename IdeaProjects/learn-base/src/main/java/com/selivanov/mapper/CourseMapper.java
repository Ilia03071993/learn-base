package com.selivanov.mapper;

import com.selivanov.dto.CourseDto;
import com.selivanov.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "students", ignore = true)
    Course toCourse(CourseDto courseDto);

    CourseDto toCourseDto(Course course);
}