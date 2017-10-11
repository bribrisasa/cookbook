package com.cookbook.cookbookv3.REPOSITORY;

import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.MODEL.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository  extends MongoRepository<Recipe, String> {
    void delete(Recipe deleted);
    List<Recipe> findAll();
    Recipe findOne(String id);
    Recipe save(Recipe saved);
}
