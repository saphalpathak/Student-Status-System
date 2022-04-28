package com.texas.studentstatus.service.admin;

import com.texas.studentstatus.dto.AdminDto;
import com.texas.studentstatus.dto.StudentDto;
import com.texas.studentstatus.entity.Admin;

import java.util.List;

public interface AdminService {
    List<AdminDto> findAllAdmins();
    AdminDto saveAdmin(AdminDto adminDto);
    AdminDto findAdminById(Integer id);
    void deleteAdminById(Integer id);
}
