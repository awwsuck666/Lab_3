package com.example.lab_3.controller;

import com.example.lab_3.dto.CommentCreateDto;
import com.example.lab_3.dto.PostCreateDto;
import com.example.lab_3.dto.PostResponseDto;
import com.example.lab_3.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String listPosts(Model model) {
        List<PostResponseDto> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts-list";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        PostResponseDto post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("commentDto", new CommentCreateDto());
        return "post-view";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("postDto", new PostCreateDto());
        return "post-form";
    }

    @PostMapping("/new")
    public String createPost(@Valid @ModelAttribute("postDto") PostCreateDto postDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post-form";
        }
        postService.createPost(postDto);
        return "redirect:/posts";
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}