package com.selivanov.service;

import com.selivanov.dto.DepartmentDto;
import com.selivanov.entity.Department;
import com.selivanov.exception.NoSuchEntityException;
import com.selivanov.mapper.EmployeeDepartmentMapper;
import com.selivanov.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repository;
    private final EmployeeDepartmentMapper mapper;

    public Department getDepartmentById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new NoSuchEntityException("Department with id = '%d' not found".formatted(id)));
    }

    public void saveDepartment(DepartmentDto departmentDto) {
        repository.save(mapper.toDepartment(departmentDto));
    }

    public Department createOrGetDepartment(DepartmentDto departmentDto) {
        return repository.findById(departmentDto.id())
                .orElse(repository.save(mapper.toDepartment(departmentDto)));
    }

    @Transactional
    public boolean checkExistsEmployeeInDepartment(String name) {
        return repository.checkExistsEmployeeInDepartment(name);
    }
}