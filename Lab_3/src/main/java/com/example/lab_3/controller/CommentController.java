package com.example.lab_3.controller;

import com.example.lab_3.dto.CommentCreateDto;
import com.example.lab_3.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addComment(@PathVariable Long postId,
                             @Valid @ModelAttribute("commentDto") CommentCreateDto commentDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/posts/" + postId;
        }
        commentService.addComment(postId, commentDto);
        return "redirect:/posts/" + postId;
    }
}