package com.cookbook.cookbookv3.MODEL;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private String name;
    private HashMap<String,String> ingredients;
    private int time;
    private int persons;

    public Recipe(String name, HashMap<String, String> ingredients, int time, int persons) {
        this.name = name;
        this.ingredients = ingredients;
        this.time = time;
        this.persons = persons;
    }

    public Recipe(String name,String time,String persons){
        this.name = name;
        this.time = Integer.parseInt(time);
        this.persons = Integer.parseInt(persons);
        this.ingredients = new HashMap<String,String>();
    }

    public Recipe(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String k, String i){
        this.ingredients.put(k,i);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String toString(){
        String s =  "Recipe for : "+this.name+"\n";
        for(Map.Entry<String, String> e : ingredients.entrySet()) {
                String key = e.getKey();
                String value = e.getValue();
                s+= value+" - "+key+"\n";
            }
            return s;
        }

}