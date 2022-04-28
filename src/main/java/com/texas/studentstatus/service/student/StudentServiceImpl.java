package com.texas.studentstatus.service.student;
import com.texas.studentstatus.dto.StudentDto;
import com.texas.studentstatus.entity.Student;
import com.texas.studentstatus.exceptions.ResourceNotFoundException;
import com.texas.studentstatus.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    public final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return StudentDto.toDto(studentRepo.findAll());
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = new Student();
        if(studentDto.getId()!=null && studentDto.getId()!=0){
            student=studentRepo.findById(studentDto.getId()).orElseThrow(
                    ()->new RuntimeException("Invalid Id")
            );
        }
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setContact(studentDto.getContact());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        return new StudentDto(studentRepo.save(student));
    }

    @Override
    public StudentDto findStudentById(Integer id) {
        Student student = studentRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student","id",id)
        );
        return new StudentDto(student);
    }

    @Override
    public void deleteStudentById(Integer id){
        studentRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Invalid Id")
        );
        studentRepo.deleteById(id);
    }
}
