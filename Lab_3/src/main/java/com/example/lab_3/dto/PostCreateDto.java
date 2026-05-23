package com.example.lab_3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostCreateDto {

    @NotBlank(message = "Заголовок не должен быть пустым")
    @Size(min = 3, max = 100, message = "Заголовок должен быть от 3 до 100 символов")
    private String title;

    @NotBlank(message = "Содержимое поста не должно быть пустым")
    @Size(min = 10, message = "Текст поста должен быть не менее 10 символов")
    private String content;

    public PostCreateDto() {
    }

    // Геттеры и сеттеры
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}