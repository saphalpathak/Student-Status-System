package com.texas.studentstatus.dto;

import com.texas.studentstatus.entity.Admin;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {


    private Integer id;

    private String name;

    private String email;

    private String contact;

    private String address;

    private String password;

    public AdminDto(Admin admin) {
        this.id = admin.getId();
        this.address = admin.getAddress();
        this.contact = admin.getContact();
        this.email = admin.getEmail();
        this.name = admin.getName();
        this.password = admin.getPassword();
    }

    public static List<AdminDto> toDto(List<Admin> admins) {
        List<AdminDto> adminDtos = new ArrayList<>();
        admins.forEach(admin -> adminDtos.add(new AdminDto(admin)));
        return adminDtos;
    }
}
