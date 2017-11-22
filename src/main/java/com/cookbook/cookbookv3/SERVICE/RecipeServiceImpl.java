package com.cookbook.cookbookv3.SERVICE;

import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.REPOSITORY.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl {

    @Autowired
    RecipeRepository rr;

    public void deleteRecipe(Recipe deleted){
        rr.delete(deleted.getId());
    }

    public Iterable<Recipe> findAllRecipe(){
        return rr.findAll();
    }

    public Recipe findByName(int id){
        return rr.findOne(id);
    }

    public Recipe addRecipe(Recipe saved){
        return rr.save(saved);
    }

}
