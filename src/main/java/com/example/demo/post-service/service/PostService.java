package com.example.demo.postservice.service;

import com.example.demo.postservice.model.Post;
import com.example.demo.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
    
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Post not found with id: " + id));
    }
    
    public Post updatePost(Long id, Post postDetails) {
        Post post = getPost(id);
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }
}
