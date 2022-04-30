package com.texas.studentstatus.service.post;

import com.texas.studentstatus.dto.PostDto;
import com.texas.studentstatus.entity.Post;
import com.texas.studentstatus.exceptions.ResourceNotFoundException;
import com.texas.studentstatus.repo.PostRepo;
import com.texas.studentstatus.utils.FileUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto savePost(PostDto postDto) throws IOException {

        Post post = new Post();
        if (postDto.getId() != null && postDto.getId() != 0) {
            post = postRepo.findById(postDto.getId()).orElseThrow(
                    () -> new RuntimeException("Invalid id: " + postDto.getId())
            );
        }
        post.setContent(postDto.getContent());
        post.setAddedDate(postDto.getAddedDate());
        post.setTitle(postDto.getTitle());
        post.setFaculty(postDto.getFaculty());
        post.setSemester(postDto.getSemester());
        Post save = postRepo.save(post);
        return new PostDto(save);
    }

    @Override
    public PostDto findPostById(Integer id) {
        Post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        return new PostDto(post);
    }

    @Override
    public void deletePostById(Integer id) {
        postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        postRepo.deleteById(id);
    }

    @Override
    public List<PostDto> findAllPost() {
        return PostDto.toDto(postRepo.findAll());
    }
}
