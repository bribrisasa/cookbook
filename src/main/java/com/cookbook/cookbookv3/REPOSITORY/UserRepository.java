package com.cookbook.cookbookv3.REPOSITORY;

import com.cookbook.cookbookv3.MODEL.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer> {

}
