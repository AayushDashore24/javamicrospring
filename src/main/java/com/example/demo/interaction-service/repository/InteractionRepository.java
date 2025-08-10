package com.example.demo.interactionservice.repository;

import com.example.demo.interactionservice.model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    List<Interaction> findByPostId(Long postId);
    long countByPostIdAndInteractionType(Long postId, String interactionType);
}
