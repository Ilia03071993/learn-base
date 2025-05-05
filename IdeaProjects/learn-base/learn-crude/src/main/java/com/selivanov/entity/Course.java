package com.selivanov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public void setStudents(List<Student> students) {
        for (Student student : students) {
            student.getCourses().add(this);
        }
        this.students = students;
    }
}