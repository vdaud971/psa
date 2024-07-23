package com.example.paylod;

import com.example.entity.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentDto {

    private Long id;
    private String email;
    private String content;
    private Post post;

}