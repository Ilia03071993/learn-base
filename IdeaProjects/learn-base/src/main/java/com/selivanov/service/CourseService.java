package com.selivanov.service;

import com.selivanov.dto.CourseDto;
import com.selivanov.entity.Course;
import com.selivanov.exception.NoSuchCourseException;
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
    public Course getCourseById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new NoSuchCourseException("Course with id = '%d' not found".formatted(id))
        );
    }

    @Transactional(readOnly = true)
    public Course getCourseByName(String name){
        return repository.getCourseByName(name).orElseThrow(
                () -> new NoSuchCourseException("Course with name = '%s' not found".formatted(name))
        );
    }

    @Transactional
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = repository.save(mapper.toCourse(courseDto));
        return mapper.toCourseDto(course);
    }
}