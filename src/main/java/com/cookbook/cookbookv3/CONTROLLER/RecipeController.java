package com.cookbook.cookbookv3.CONTROLLER;


import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.MODEL.User;
import com.cookbook.cookbookv3.SERVICE.RecipeServiceImpl;
import com.cookbook.cookbookv3.SERVICE.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recipe> allRecipe(){
        return recipeService.findAllRecipe();
    }

    @RequestMapping(value = "/add/{name}/{time}/{person}", method = RequestMethod.POST)
    public List<Recipe> addRecipe(@PathVariable("name") String name,@PathVariable("time") String time,@PathVariable("person") String person){
        Recipe u = new Recipe(name,time,person);
      //  Recipe r = new Recipe();
        recipeService.addRecipe(u);
        return this.allRecipe();
    }

    @RequestMapping(value = "/addIngredient/{name}/{ingredient}/{quantite}", method = RequestMethod.POST)
    public Recipe addIngredientRecipe(@PathVariable("name") String name,@PathVariable("ingredient") String ingredient,@PathVariable("quantite") String quantite){
        return recipeService.updateRecipe(name,ingredient,quantite);
    }

    @RequestMapping(value = "/updateRecipe/{name}/{value}/{newTime}", method = RequestMethod.POST)
    public Recipe updateRecipe(@PathVariable("name") String name,@PathVariable("value") String value,@PathVariable("newTime") String newTime){
        return recipeService.updateRecipeValue(value,name,newTime);
    }


    @RequestMapping(value = "/delete/{usN}", method = RequestMethod.POST)
    public List<Recipe> deleteRecipe(@PathVariable("usN") String un){
        recipeService.deleteRecipe(this.findRecipe(un));
        return this.allRecipe();
    }

    @RequestMapping(value = "/findOne/{usN}", method = RequestMethod.POST)
    public Recipe findRecipe(@PathVariable("usN") String un){
        return this.recipeService.findByName(un);
    }

    @RequestMapping(value = "/filter/{ingredient}", method = RequestMethod.POST)
    public List<Recipe> recipesFiltered(@PathVariable("ingredient") String ingredient){
        return recipeService.filter(ingredient);
    }

}
