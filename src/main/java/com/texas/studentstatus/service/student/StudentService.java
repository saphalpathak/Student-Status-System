package com.texas.studentstatus.service.student;

import com.texas.studentstatus.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAllStudents();
    StudentDto saveStudent(StudentDto studentDto);
    StudentDto findStudentById(Integer id);
    void deleteStudentById(Integer integer);
}
