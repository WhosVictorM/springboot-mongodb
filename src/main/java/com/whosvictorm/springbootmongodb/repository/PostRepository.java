package com.whosvictorm.springbootmongodb.repository;

import com.whosvictorm.springbootmongodb.domain.Post;
import com.whosvictorm.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
