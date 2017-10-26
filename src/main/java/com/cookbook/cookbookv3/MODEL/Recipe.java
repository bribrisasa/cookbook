package com.cookbook.cookbookv3.MODEL;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "Recipe")
public class Recipe {
    @Id
    private String id;
    private String name;
    private String photo;
    private String time;
    private String nbPerson;
    private List<String> ingredients;
    private String description;

    public Recipe(String name, String photo, List<String> ingredients, String time, String persons, String description) {
        this.name = name;
        this.photo = photo;
        this.ingredients = ingredients;
        this.time = time;
        this.nbPerson = persons;
        this.description = description;
    }

    public Recipe(String name,String time,String persons){
        this.name = name;
        this.photo = "http://www.fondecranmagique.com/cuisine/pomme/1320427589.jpg";
        this.time = time;
        this.nbPerson = persons;
        this.ingredients = new ArrayList<String>();
    }

    public Recipe(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String k){
        this.ingredients.add(k);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getnbPerson() {
        return nbPerson;
    }

    public void setnbPerson(String persons) {
        this.nbPerson = persons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        String s =  "Recipe for : "+this.name+"\n";

            return s;
        }

}