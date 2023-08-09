package com.whosvictorm.springbootmongodb.resources;

import com.whosvictorm.springbootmongodb.domain.Post;
import com.whosvictorm.springbootmongodb.domain.User;
import com.whosvictorm.springbootmongodb.dto.UserDTO;
import com.whosvictorm.springbootmongodb.resources.util.URL;
import com.whosvictorm.springbootmongodb.services.PostService;
import com.whosvictorm.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @GetMapping(path = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){

        title = URL.decodeParam(title);
        List<Post> list = service.findByTitle(title);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "title", defaultValue = "") String title,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate){

        title = URL.decodeParam(title);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = service.fullSearch(title, min, max);

        return ResponseEntity.ok().body(list);
    }
}
