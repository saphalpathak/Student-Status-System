package com.texas.studentstatus.service.post;

import com.texas.studentstatus.dto.PostDto;

import java.io.IOException;
import java.util.List;

public interface PostService {

    PostDto savePost(PostDto postDto) throws IOException;
    PostDto findPostById(Integer id);
    void deletePostById(Integer id);
    List<PostDto> findAllPost();
}
