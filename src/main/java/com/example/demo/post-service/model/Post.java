package com.example.demo.postservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Integer likes;
    private Integer dislikes;
    
    public Post() {
        this.createdAt = LocalDateTime.now();
        this.likes = 0;
        this.dislikes = 0;
    }
}
