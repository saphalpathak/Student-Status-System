package com.texas.studentstatus.repo;
import com.texas.studentstatus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
