//package com.texas.studentstatus.config.security;
//
//import com.texas.studentstatus.entity.Admin;
//import com.texas.studentstatus.repo.AdminRepo;
//import com.texas.studentstatus.repo.StudentRepo;
//import com.texas.studentstatus.repo.TeacherRepo;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final AdminRepo adminRepo;
//    private final TeacherRepo teacherRepo;
//    private final StudentRepo studentRepo;
//
//    public CustomUserDetailsService(AdminRepo adminRepo, TeacherRepo teacherRepo, StudentRepo studentRepo) {
//        this.adminRepo = adminRepo;
//        this.teacherRepo = teacherRepo;
//        this.studentRepo = studentRepo;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    }
//}
