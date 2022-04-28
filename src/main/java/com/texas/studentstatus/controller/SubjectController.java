package com.texas.studentstatus.controller;
import com.texas.studentstatus.dto.SubjectDto;
import com.texas.studentstatus.dto.response.ResponseDto;
import com.texas.studentstatus.service.subject.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/subject")
public class SubjectController extends BaseController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/save")
    public ResponseDto saveSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return successResponse("Subject successfully added",subjectService.saveSubject(subjectDto));
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findAdminById(@PathVariable Integer id) {
        return ResponseEntity.ok(successResponse("Data found",subjectService.findSubjectById(id)));
    }

    //find all
    @GetMapping("/all")
    public ResponseDto findAllAdmins() {
        return successResponse("Data found",subjectService.findAllSubject());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteAdminById(@PathVariable Integer id) {
        subjectService.deleteSubjectById(id) ;
        return successResponse("Subject successfully Deleted",null);
    }

    //update
    @PutMapping("/update")
    public ResponseDto updateSubject(@Valid @RequestBody SubjectDto subjectDto){
        return successResponse("Admin successfully Updated",subjectService.saveSubject(subjectDto));
    }
}
