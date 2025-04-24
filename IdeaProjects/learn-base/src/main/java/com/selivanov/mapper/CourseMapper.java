package com.selivanov.mapper;

import com.selivanov.dto.CourseDto;
import com.selivanov.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CourseDto courseDto);

    CourseDto toCourseDto(Course course);
}