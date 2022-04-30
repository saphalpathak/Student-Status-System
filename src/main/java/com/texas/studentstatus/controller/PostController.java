package com.texas.studentstatus.controller;

import com.texas.studentstatus.dto.PostDto;
import com.texas.studentstatus.dto.response.ResponseDto;
import com.texas.studentstatus.service.post.PostService;
import com.texas.studentstatus.service.post.PostServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/post")
public class PostController extends BaseController{

    public final PostService service;

    public PostController(PostServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/save", consumes = {"application/json"})
    public ResponseDto savePost(@Valid @RequestBody PostDto postDto) throws IOException {
        return successResponse("Post successfully added",service.savePost(postDto));
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(successResponse("Post data",service.findPostById(id)));
    }

    //find all
    @GetMapping("/all")
    public ResponseDto findAllPosts() {
        return successResponse("All post data",service.findAllPost());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseDto deletePostById(@PathVariable Integer id) {
        service.deletePostById(id);
        return successResponse("Post successfully deleted",null);
    }

    //update
    @PutMapping("/update")
    public ResponseDto updatePost(@Valid @RequestBody PostDto postDto) throws IOException {
        return successResponse("Post successfully updated",service.savePost(postDto));
    }
}
