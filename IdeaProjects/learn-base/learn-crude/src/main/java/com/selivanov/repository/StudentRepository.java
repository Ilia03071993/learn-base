package com.selivanov.repository;

import com.selivanov.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.name = :name")
    Optional<Student> findStudentByName(@Param("name") String name);

    @Query("select s from Student  s left join fetch s.courses where s.id = :id")
    Optional<Student> findStudentById(@Param("id") Integer id);

    @Query("select s from Student s left join fetch s.courses")
    List<Student> findStudents();

    @Modifying
    @Query(value = "insert into students_courses (student_id, course_id) values (:s_id, :c_id)", nativeQuery = true)
    void saveStudentsCourses(@Param("s_id") Integer studentId, @Param("c_id") Integer courseId);

    @Modifying
    @Query(value = "delete from students_courses where student_id = :s_id and course_id = :c_id", nativeQuery = true)
    void deleteFromStudentsCourses(@Param("s_id") Integer studentId, @Param("c_id") Integer courseId);
}