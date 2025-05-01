package com.selivanov.repository;

import com.selivanov.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.department.id = :departmentId")
    List<Employee> findEmployeesByDepartment(@Param("departmentId") Integer departmentId);

    @Query("select e from Employee e left join fetch e.department where e.id = :id")
    Optional<Employee> findEmployeeById(@Param("id") Integer id);

    @Modifying
    @Query(value = "INSERT INTO employees (department_id, job, name) VALUES (:departmentId, :job, :name)", nativeQuery = true)
    void saveEmployee(@Param("departmentId") Integer departmentId,
                      @Param("job") String job,
                      @Param("name") String name);
}