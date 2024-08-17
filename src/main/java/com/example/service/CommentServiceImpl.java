package com.example.service;


import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.paylod.CommentDto;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository;
    private PostRepository postRepository ;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postid, CommentDto commentDto) {
        Post post = postRepository.findById(postid).get();
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
        return mapToDto(comment);
    }

    @Override
    public void deleteByyId(long postid) {
        commentRepository.deleteById(postid);
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto dto= new CommentDto();
        dto.setId(comment.getId());
        dto.setEmail(comment.getEmail());
        dto.setContent(comment.getContent());
        dto.setPost(comment.getPost());
        return dto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setContent(commentDto.getContent());
        comment.setPost(commentDto.getPost());
        return comment;
    }

}
