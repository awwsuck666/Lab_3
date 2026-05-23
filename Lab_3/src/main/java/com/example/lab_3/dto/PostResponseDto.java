package com.example.lab_3.dto;

import java.util.List;

public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private List<String> comments;

    public PostResponseDto() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<String> getComments() { return comments; }
    public void setComments(List<String> comments) { this.comments = comments; }
}