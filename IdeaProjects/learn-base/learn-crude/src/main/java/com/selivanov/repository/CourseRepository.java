package com.selivanov.repository;

import com.selivanov.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("select c from Course c where c.name = :name")
    Optional<Course> findCourseByName(@Param("name") String name);
}