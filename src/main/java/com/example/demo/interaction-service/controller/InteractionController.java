package com.example.demo.interactionservice.controller;

import com.example.demo.interactionservice.model.Interaction;
import com.example.demo.interactionservice.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {
    
    @Autowired
    private InteractionService interactionService;
    
    @PostMapping("/like/{postId}")
    public ResponseEntity<Interaction> likePost(@PathVariable Long postId) {
        Interaction interaction = new Interaction();
        interaction.setPostId(postId);
        interaction.setInteractionType("LIKE");
        return ResponseEntity.ok(interactionService.addInteraction(interaction));
    }
    
    @PostMapping("/dislike/{postId}")
    public ResponseEntity<Interaction> dislikePost(@PathVariable Long postId) {
        Interaction interaction = new Interaction();
        interaction.setPostId(postId);
        interaction.setInteractionType("DISLIKE");
        return ResponseEntity.ok(interactionService.addInteraction(interaction));
    }
    
    @GetMapping("/{postId}/likes")
    public ResponseEntity<Long> getLikesCount(@PathVariable Long postId) {
        return ResponseEntity.ok(interactionService.getLikesCount(postId));
    }
    
    @GetMapping("/{postId}/dislikes")
    public ResponseEntity<Long> getDislikesCount(@PathVariable Long postId) {
        return ResponseEntity.ok(interactionService.getDislikesCount(postId));
    }
}
