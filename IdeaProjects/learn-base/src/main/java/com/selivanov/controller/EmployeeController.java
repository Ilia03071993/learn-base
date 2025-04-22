package com.selivanov.controller;

import com.selivanov.dto.EmployeeDto;
import com.selivanov.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        EmployeeDto employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = service.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByDepartment(@PathVariable("id") Integer departmentId) {
        List<EmployeeDto> employees = service.getEmployeesByDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        service.saveEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/department/{id}")
    public ResponseEntity<?> createEmployeeToDepartment(@PathVariable("id") Integer id,
                                                        @RequestBody EmployeeDto employeeDto) {
        service.createEmployeeToDepartment(id, employeeDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/attach-department/{departmentId}")
    public ResponseEntity<?> attachEmployeeToDepartment(@PathVariable("id") Integer employeeId,
                                                        @PathVariable("departmentId") Integer departmentId) {
        service.attachEmployeeToDepartment(employeeId, departmentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{employeeId}/department/{departmentId}")
    public ResponseEntity<?> transferEmployeeToDepartment(@PathVariable("employeeId") Integer employeeId,
                                                          @PathVariable("departmentId") Integer departmentId) {
        service.transferEmployeeToDepartment(employeeId, departmentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Integer id,
                                            @RequestBody EmployeeDto employeeDto) {
        service.updateEmployeeById(id, employeeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{employeeId}/department/{departmentId}")
    public ResponseEntity<?> detachEmployeeFromDepartment(@PathVariable("employeeId") Integer employeeId,
                                                          @PathVariable("departmentId") Integer departmentId) {
        service.detachEmployeeFromDepartment(departmentId, employeeId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        service.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}