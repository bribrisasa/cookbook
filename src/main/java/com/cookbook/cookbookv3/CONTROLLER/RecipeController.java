package com.cookbook.cookbookv3.CONTROLLER;


import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.SERVICE.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeService;

    @GetMapping("/all")
    public Iterable<Recipe> allRecipe(){
        return recipeService.findAllRecipe();
    }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody Recipe newRecipe){
        recipeService.addRecipe(newRecipe);
        return newRecipe;
    }

    @PostMapping("/edit")
    public Recipe editRecipe(@RequestBody Recipe newRecipe){
       // recipeService.editRecipe(newRecipe);
        return newRecipe;
    }

    @RequestMapping(value = "/addIngredient/{name}/{ingredient}", method = RequestMethod.POST)
    public Recipe addIngredientRecipe(@PathVariable("name") String name,@PathVariable("ingredient") String ingredient){
       // return recipeService.updateRecipe(name,ingredient);
        return null;
    }

    @RequestMapping(value = "/updateRecipe/{name}/{value}/{newTime}", method = RequestMethod.POST)
    public Recipe updateRecipe(@PathVariable("name") String name,@PathVariable("value") String value,@PathVariable("newTime") String newTime){
       // return recipeService.updateRecipeValue(value,name,newTime);
        return null;
    }


    @RequestMapping(value = "/delete/{usN}", method = RequestMethod.POST)
    public Iterable<Recipe> deleteRecipe(@PathVariable("usN") int un){
        recipeService.deleteRecipe(this.findRecipe(un));
        return this.allRecipe();
    }

    @RequestMapping(value = "/findOne/{usN}", method = RequestMethod.GET)
    public Recipe findRecipe(@PathVariable("usN") int un){
        return this.recipeService.findByName(un);
    }


    @RequestMapping(value = "/filter/{ingredient}", method = RequestMethod.POST)
    public List<Recipe> recipesFiltered(@PathVariable("ingredient") String ingredient){
       // return recipeService.filter(ingredient);
        return null;
    }

}
