package com.example.lab_3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentCreateDto {

    @NotBlank(message = "Комментарий не может быть пустым")
    @Size(max = 500, message = "Комментарий слишком длинный (макс. 500 символов)")
    private String text;

    public CommentCreateDto() {
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}