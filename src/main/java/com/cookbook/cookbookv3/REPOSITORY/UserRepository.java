package com.cookbook.cookbookv3.REPOSITORY;

import com.cookbook.cookbookv3.MODEL.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends MongoRepository<User, String> {
    void delete(User deleted);
    List<User> findAll();
    User findOne(String id);
    User save(User saved);

}
