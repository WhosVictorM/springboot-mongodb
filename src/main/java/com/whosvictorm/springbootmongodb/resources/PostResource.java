package com.whosvictorm.springbootmongodb.resources;

import com.whosvictorm.springbootmongodb.domain.Post;
import com.whosvictorm.springbootmongodb.domain.User;
import com.whosvictorm.springbootmongodb.dto.UserDTO;
import com.whosvictorm.springbootmongodb.services.PostService;
import com.whosvictorm.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post user = service.findById(id);

        return ResponseEntity.ok().body(user);
    }
}