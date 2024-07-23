package com.example.service;

import com.example.entity.Comment;
import com.example.paylod.CommentDto;

public interface CommentService {

    CommentDto createComment(long id, CommentDto commentDto);
}
