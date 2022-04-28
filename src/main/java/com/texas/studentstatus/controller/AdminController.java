package com.texas.studentstatus.controller;

import com.texas.studentstatus.dto.AdminDto;
import com.texas.studentstatus.dto.StudentDto;
import com.texas.studentstatus.dto.response.ResponseDto;
import com.texas.studentstatus.service.admin.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController extends BaseController{

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/save")
    public ResponseDto saveAdmin(@Valid @RequestBody AdminDto adminDto) {
        return successResponse("Admin successfully added",adminService.saveAdmin(adminDto));
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findAdminById(@PathVariable Integer id) {
        return ResponseEntity.ok(successResponse("Data found",adminService.findAdminById(id)));
    }

    //find all
    @GetMapping("/all")
    public ResponseDto findAllAdmins() {
        return successResponse("Data found",adminService.findAllAdmins());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteAdminById(@PathVariable Integer id) {
        adminService.deleteAdminById(id) ;
        return successResponse("Admin successfully Deleted",null);
    }

    //update
    @PutMapping("/update")
    public ResponseDto updateAdmin(@Valid @RequestBody AdminDto adminDto){
        return successResponse("Admin successfully Updated",adminService.saveAdmin(adminDto));
    }
}
