package com.example.controller;


import com.example.paylod.PostDto;
import com.example.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
     private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/v1/post?id=
 @Transactional
    @DeleteMapping
    public ResponseEntity<String>deletePost(@RequestParam long id){
        postService.deletePost(id);
        return new ResponseEntity<>("record_is_deleted",HttpStatus.OK);
    }
}
