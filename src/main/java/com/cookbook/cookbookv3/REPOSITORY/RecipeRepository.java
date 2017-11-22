package com.cookbook.cookbookv3.REPOSITORY;

import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.MODEL.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository  extends CrudRepository<Recipe, Integer> {

}
