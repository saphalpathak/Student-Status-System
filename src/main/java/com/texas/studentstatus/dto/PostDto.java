package com.texas.studentstatus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.texas.studentstatus.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Integer id;

    private String title;

    private String content;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate addedDate;

    private String faculty;

    private String semester;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.addedDate = post.getAddedDate();
        this.semester = post.getSemester();
        this.faculty = post.getFaculty();
    }

    public static List<PostDto> toDto(List<Post> posts) {
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(post -> postDtos.add(new PostDto(post)));
        return postDtos;
    }


}
