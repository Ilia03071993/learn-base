package com.selivanov.mapper;

import com.selivanov.entity.Student;
import com.selivanov.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "courses", ignore = true)
    Student toStudent(StudentDto studentDto);

    StudentDto toStudentDto(Student student);

    List<StudentDto> toStudentsDto(List<Student> students);
    @Mapping(target = "courses", ignore = true)
    void updateStudent(@MappingTarget Student updatableStudent, StudentDto studentDto);
}