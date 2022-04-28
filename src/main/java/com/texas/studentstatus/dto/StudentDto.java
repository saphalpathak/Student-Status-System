package com.texas.studentstatus.dto;
import com.texas.studentstatus.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Integer id;
    @NotEmpty
    private String name;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email !! please type a valid email.")
    private String email;

    @NotEmpty
    private String contact;

    @NotEmpty
    private String address;

    public StudentDto(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.address = student.getAddress();
        this.email = student.getEmail();
        this.contact = student.getContact();

    }
    public static List<StudentDto> toDto(List<Student> dto){
        List<StudentDto> studentDtos = new ArrayList<>();
        dto.forEach(student -> studentDtos.add(new StudentDto(student)));
        return studentDtos;
    }
}
