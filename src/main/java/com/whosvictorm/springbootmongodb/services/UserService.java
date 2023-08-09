package com.whosvictorm.springbootmongodb.services;

import com.whosvictorm.springbootmongodb.repository.UserRepository;
import com.whosvictorm.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whosvictorm.springbootmongodb.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

}
