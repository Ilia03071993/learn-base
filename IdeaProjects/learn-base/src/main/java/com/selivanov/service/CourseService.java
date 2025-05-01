package com.selivanov.service;

import com.selivanov.dto.CourseDto;
import com.selivanov.entity.Course;
import com.selivanov.exception.NoSuchEntityException;
import com.selivanov.mapper.CourseMapper;
import com.selivanov.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Transactional(readOnly = true)
    public Course getCourseByName(String name){
        return repository.findCourseByName(name).orElseThrow(
                () -> new NoSuchEntityException("Course with name = '%s' not found".formatted(name))
        );
    }

    @Transactional
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = repository.save(mapper.toCourse(courseDto));
        return mapper.toCourseDto(course);
    }
}