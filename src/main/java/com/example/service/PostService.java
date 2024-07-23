package com.example.service;

import com.example.paylod.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    void deletePost(long id);
}
