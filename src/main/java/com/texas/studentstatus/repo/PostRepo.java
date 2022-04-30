package com.texas.studentstatus.repo;

import com.texas.studentstatus.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
