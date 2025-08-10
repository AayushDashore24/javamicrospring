package com.example.demo.interactionservice.service;

import com.example.demo.interactionservice.model.Interaction;
import com.example.demo.interactionservice.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionService {
    
    @Autowired
    private InteractionRepository interactionRepository;
    
    public Interaction addInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }
    
    public long getLikesCount(Long postId) {
        return interactionRepository.countByPostIdAndInteractionType(postId, "LIKE");
    }
    
    public long getDislikesCount(Long postId) {
        return interactionRepository.countByPostIdAndInteractionType(postId, "DISLIKE");
    }
}
