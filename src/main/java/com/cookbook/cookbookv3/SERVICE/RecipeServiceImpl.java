package com.cookbook.cookbookv3.SERVICE;

import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.REPOSITORY.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl {

    @Autowired
    RecipeRepository rr;

    public void deleteRecipe(Recipe deleted){
        rr.delete(deleted.getName());
    }

    public List<Recipe> findAllRecipe(){
        return rr.findAll();
    }

    public Recipe findByName(String id){
        return rr.findOne(id);
    }

    public Recipe addRecipe(Recipe saved){
        return rr.save(saved);
    }

    public Recipe updateRecipe(String n, String i){
        Recipe r = rr.findOne(n);
        r.addIngredient(i);
        rr.save(r);
        return r;

    }

    public Recipe updateRecipeValue(String n, String i, String q){
        Recipe r = rr.findOne(i);
        if(n.equals("time")){
            r.setTime(q);
        }else if(n.equals("persons")){
            r.setnbPerson(q);
        }
        rr.save(r);
        return r;

    }

    public List<Recipe> filter(String ingredient){
        List<Recipe> ls = this.findAllRecipe();


    return ls;
    }

    public void editRecipe(Recipe newRecipe) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(newRecipe.getId()));

        //Recipe recipe = rr.findOne(query, Recipe.class);

       // System.out.println("userTest1 - " + userTest1);

//modify and update with save()
     //   userTest1.setAge(99);
      //  mongoOperation.save(userTest1);

//get the updated object again
      //  User userTest1_1 = mongoOperation.findOne(query, User.class);

     //   System.out.println("userTest1_1 - " + userTest1_1);

        rr.save(newRecipe);
    }
}
