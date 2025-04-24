package com.selivanov.controller;

import com.selivanov.dto.DepartmentDto;
import com.selivanov.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<?> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        service.saveDepartment(departmentDto);
        return ResponseEntity.ok().build();
    }
}
