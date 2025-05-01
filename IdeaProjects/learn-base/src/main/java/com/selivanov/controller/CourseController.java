package com.selivanov.controller;

import com.selivanov.dto.CourseDto;
import com.selivanov.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> saveCourse(@Valid @RequestBody CourseDto courseDto) {
        CourseDto course = courseService.saveCourse(courseDto);
        return ResponseEntity.ok(course);
    }
}