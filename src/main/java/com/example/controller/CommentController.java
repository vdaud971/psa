package com.example.controller;
import com.example.paylod.CommentDto;
import com.example.paylod.PostDto;
import com.example.service.CommentService;
import com.example.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private CommentService commentService ;

    public CommentController( CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto>postComment(@RequestParam long postid,@RequestBody CommentDto commentDto){

        CommentDto comment = commentService.createComment(postid, commentDto);
        return new ResponseEntity<>(comment,HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<String>deleteCommentById(@RequestParam long postid){
        commentService.deleteByyId(postid);
        return null;
    }
}
