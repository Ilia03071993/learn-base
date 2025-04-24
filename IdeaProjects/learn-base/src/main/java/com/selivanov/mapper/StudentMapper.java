package com.selivanov.mapper;

import com.selivanov.dto.StudentDto;
import com.selivanov.entity.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @InheritInverseConfiguration
    Student toStudent(StudentDto studentDto);

    StudentDto toStudentDto(Student student);

    List<StudentDto> toStudentsDto(List<Student> students);

    void updateStudent(@MappingTarget Student updatableStudent, StudentDto studentDto);
}