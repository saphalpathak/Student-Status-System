package com.texas.studentstatus.service.teacher;

import com.texas.studentstatus.dto.SubjectDto;
import com.texas.studentstatus.dto.TeacherDto;
import com.texas.studentstatus.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherService{

    List<TeacherDto> findAllTeachers();
    TeacherDto saveTeacher(TeacherDto teacherDto);
    TeacherDto findTeacherById(Integer id);
    void deleteTeacherById(Integer id);
}
