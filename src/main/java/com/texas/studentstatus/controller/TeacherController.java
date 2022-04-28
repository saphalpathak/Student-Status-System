package com.texas.studentstatus.controller;
import com.texas.studentstatus.dto.TeacherDto;
import com.texas.studentstatus.dto.response.ResponseDto;
import com.texas.studentstatus.service.teacher.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController extends BaseController{

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/save")
    public ResponseDto saveTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        return successResponse("Teacher successfully added",teacherService.saveTeacher(teacherDto));
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findTeacherById(@PathVariable Integer id) {
        return ResponseEntity.ok(successResponse("Teacher data",teacherService.findTeacherById(id)));
    }

    //find all
    @GetMapping("/all")
    public ResponseDto findAllTeachers() {
        return successResponse("Teacher data",teacherService.findAllTeachers());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteTeacherById(@PathVariable Integer id) {
        teacherService.deleteTeacherById(id) ;
        return successResponse("Teacher successfully Deleted",null);
    }

    //update
    @PutMapping("/update")
    public ResponseDto updateTeacher(@Valid @RequestBody TeacherDto teacherDto){
        return successResponse("Teacher successfully Updated",teacherService.saveTeacher(teacherDto));
    }
}
