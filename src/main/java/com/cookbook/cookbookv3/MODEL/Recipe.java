package com.cookbook.cookbookv3.MODEL;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String title;
    private String photo;
    private String time;
    private String serving;
    private int author;
  //  private List<String> ingredients;
    private String description;

    public Recipe(String title, String photo, List<String> ingredients, String time, String persons, String description) {
        this.title = title;
        this.photo = photo;
    //    this.ingredients = ingredients;
        this.time = time;
        this.serving = persons;
        this.description = description;
    }

    public Recipe(String title,String time,String persons){
        this.title = title;
        this.photo = "http://www.fondecranmagique.com/cuisine/pomme/1320427589.jpg";
        this.time = time;
        this.serving = persons;
   //     this.ingredients = new ArrayList<String>();
    }

    public Recipe(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

  /*  public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String k){
        this.ingredients.add(k);
    } */

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String persons) {
        this.serving = persons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String toString(){
        String s =  "Recipe for : "+this.title+"\n";

            return s;
        }

}