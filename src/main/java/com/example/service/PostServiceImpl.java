package com.example.service;

import com.example.controller.PostController;
import com.example.entity.Post;
import com.example.paylod.PostDto;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository ;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post entity = postRepository.save(post);
        PostDto postDto1 = mapToDto(entity);
        return postDto1;
    }

    @Transactional
    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    private PostDto mapToDto(Post entity) {
        PostDto dto = new PostDto();
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setId(entity.getId());
        return dto;
    }

    public Post mapToEntity(PostDto dto) {
        Post entity = new Post();
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setId(dto.getId());
        return entity;

    }
}
