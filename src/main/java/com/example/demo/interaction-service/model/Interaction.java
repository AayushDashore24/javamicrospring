package com.example.demo.interactionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String interactionType; // LIKE or DISLIKE
    private LocalDateTime createdAt;
    
    public Interaction() {
        this.createdAt = LocalDateTime.now();
    }
}
