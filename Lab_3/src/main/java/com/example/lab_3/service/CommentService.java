package com.example.lab_3.service;

import com.example.lab_3.dto.CommentCreateDto;
import com.example.lab_3.entity.Comment;
import com.example.lab_3.entity.Post;
import com.example.lab_3.repository.CommentRepository;
import com.example.lab_3.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public void addComment(Long postId, CommentCreateDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Пост с ID " + postId + " не найден"));

        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setPost(post);
        commentRepository.save(comment);
    }
}