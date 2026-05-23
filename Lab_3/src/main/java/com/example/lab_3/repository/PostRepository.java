package com.example.lab_3.repository;

import com.example.lab_3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Здесь уже есть методы findAll(), findById(), save(), deleteById()
}