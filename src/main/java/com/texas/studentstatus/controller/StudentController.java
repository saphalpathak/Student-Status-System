package com.texas.studentstatus.controller;
import com.texas.studentstatus.dto.response.ResponseDto;
import com.texas.studentstatus.dto.StudentDto;
import com.texas.studentstatus.service.student.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController extends BaseController{

    public final StudentServiceImpl service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto) {
            return successResponse("Student successfully added",service.saveStudent(studentDto));
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findStudentById(@PathVariable Integer id) {
            return ResponseEntity.ok(successResponse("Student data",service.findStudentById(id)));
    }

    //find all
    @GetMapping("/all")
    public ResponseDto findAllStudents() {
        return successResponse("Student data",service.findAllStudents());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteStudentById(@PathVariable Integer id) {
        service.deleteStudentById(id) ;
        return successResponse("Student successfully deleted",null);
    }

    //update
    @PutMapping("/update")
    public ResponseDto updateStudent(@Valid @RequestBody StudentDto studentDto){
        return successResponse("Student successfully updated",service.saveStudent(studentDto));
    }
}
