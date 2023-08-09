package com.whosvictorm.springbootmongodb.services;

import com.whosvictorm.springbootmongodb.domain.Post;
import com.whosvictorm.springbootmongodb.domain.User;
import com.whosvictorm.springbootmongodb.dto.UserDTO;
import com.whosvictorm.springbootmongodb.repository.PostRepository;
import com.whosvictorm.springbootmongodb.repository.UserRepository;
import com.whosvictorm.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String title){
        return repository.findByTitleContainingIgnoreCase(title);
    }
}
