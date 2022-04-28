package com.texas.studentstatus.dto;

import com.texas.studentstatus.entity.Subject;
import com.texas.studentstatus.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Integer id;

    private String name;

    private String email;

    private String contact;

    private String address;

    private String password;

    private List<Subject> subjects;

    public TeacherDto(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.email = teacher.getEmail();
        this.contact = teacher.getContact();
        this.address = teacher.getAddress();
        this.password = teacher.getPassword();
        this.subjects = teacher.getSubjects();
    }

    public static List<TeacherDto> toDtos(List<Teacher> teachers){
        List<TeacherDto> teacherDtos = new ArrayList<>();
        teachers.forEach(teacher -> teacherDtos.add(new TeacherDto(teacher)));
        return teacherDtos;
    }
}
