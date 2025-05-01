package com.selivanov.repository;

import com.selivanov.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("select case when count(e) > 0 then true else false end from Department d left join d.employees e where e.name = :name")
    boolean checkExistsEmployeeInDepartment(@Param("name") String name);
}