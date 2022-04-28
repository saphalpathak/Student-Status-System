package com.texas.studentstatus.service.admin;

import com.texas.studentstatus.dto.AdminDto;
import com.texas.studentstatus.entity.Admin;
import com.texas.studentstatus.exceptions.ResourceNotFoundException;
import com.texas.studentstatus.repo.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public List<AdminDto> findAllAdmins() {
        return AdminDto.toDto(adminRepo.findAll());
    }

    @Override
    public AdminDto saveAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        if(adminDto.getId()!=null && adminDto.getId()!=0){
            admin = adminRepo.findById(adminDto.getId()).orElseThrow(
                    ()-> new ResourceNotFoundException("Admin","id",adminDto.getId())
            );
        }
        admin.setName(adminDto.getName());
        admin.setAddress(adminDto.getAddress());
        admin.setContact(adminDto.getContact());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        return new AdminDto(adminRepo.save(admin));

    }

    @Override
    public AdminDto findAdminById(Integer id) {
        Admin admin = adminRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Admin","id",id)
        );
        return new AdminDto(admin);
    }

    @Override
    public void deleteAdminById(Integer id) {
        adminRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Admin","id",id)
        );
       adminRepo.deleteById(id);
    }
}
