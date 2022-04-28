package com.texas.studentstatus.repo;

import com.texas.studentstatus.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
}
