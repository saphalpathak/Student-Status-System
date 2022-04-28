package com.texas.studentstatus.service.teacher;

import com.texas.studentstatus.dto.TeacherDto;
import com.texas.studentstatus.entity.Teacher;
import com.texas.studentstatus.exceptions.ResourceNotFoundException;
import com.texas.studentstatus.repo.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepo teacherRepo;

    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<TeacherDto> findAllTeachers() {
        return TeacherDto.toDtos(teacherRepo.findAll());
    }

    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        if(teacherDto.getId() != null && teacherDto.getId()!=0){
            teacher = teacherRepo.findById(teacherDto.getId()).orElseThrow(
                    ()-> new ResourceNotFoundException("Teacher","id",teacherDto.getId())
            );
        }
        teacher.setAddress(teacherDto.getAddress());
        teacher.setContact(teacherDto.getContact());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPassword(teacherDto.getPassword());
        teacher.setAddress(teacherDto.getAddress());
        teacher.setSubjects(teacherDto.getSubjects());
        return new TeacherDto(teacherRepo.save(teacher));
    }

    @Override
    public TeacherDto findTeacherById(Integer id) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Teacher","id",id)
        );
        return new TeacherDto(teacher);
    }

    @Override
    public void deleteTeacherById(Integer id) {
        teacherRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Teacher","id",id)
        );
        teacherRepo.deleteById(id);
    }
}
