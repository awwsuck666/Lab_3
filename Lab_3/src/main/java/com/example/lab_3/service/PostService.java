package com.example.lab_3.service;

import com.example.lab_3.dto.PostCreateDto;
import com.example.lab_3.dto.PostResponseDto;
import com.example.lab_3.entity.Comment;
import com.example.lab_3.entity.Post;
import com.example.lab_3.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пост с ID " + id + " не найден"));
        return convertToResponseDto(post);
    }

    @Transactional
    public void createPost(PostCreateDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private PostResponseDto convertToResponseDto(Post post) {
        PostResponseDto dto = new PostResponseDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());

        List<String> commentTexts = post.getComments().stream()
                .map(Comment::getText)
                .collect(Collectors.toList());
        dto.setComments(commentTexts);

        return dto;
    }
}