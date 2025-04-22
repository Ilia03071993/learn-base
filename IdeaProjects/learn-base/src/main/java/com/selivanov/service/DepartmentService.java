package com.selivanov.service;

import com.selivanov.dto.DepartmentDto;
import com.selivanov.entity.Department;
import com.selivanov.exception.NoSuchDepartmentException;
import com.selivanov.mapper.EmployeeDepartmentMapper;
import com.selivanov.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repository;
    private final EmployeeDepartmentMapper mapper;

    public Department getDepartmentById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new NoSuchDepartmentException("Department with id = '%d' not found".formatted(id)));
    }

    public void saveDepartment(DepartmentDto departmentDto) {
        repository.save(mapper.toDepartment(departmentDto));
    }

    public void saveDepartment(Department department) {
        repository.save(department);
    }

    public Department createOrGetDepartment(DepartmentDto departmentDto) {
        return repository.findById(departmentDto.id())
                .orElse(repository.save(mapper.toDepartment(departmentDto)));
    }
}