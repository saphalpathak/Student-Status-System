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
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

    private Integer id;

    private String name;

    private String semester;

    private Teacher teacher;

    public SubjectDto(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.semester = subject.getSemester();
        this.teacher = subject.getTeacher();
    }

    public static List<SubjectDto> toDtos(List<Subject> subjects){
        List<SubjectDto> subjectList = new ArrayList<>();
        subjects.forEach(subject -> subjectList.add(new SubjectDto(subject)));
        return subjectList;
    }
}
