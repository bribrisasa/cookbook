package com.cookbook.cookbookv3.MODEL;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String username;
    private String photo;
    private String password;
    private List<Recipe> favoritesRecipes;
    private List<User> friends;


    public User(){}
    public User(String username, String photo, String password) {
        this.username = username;
        this.photo = photo;
        this.password = password;
        this.favoritesRecipes = new ArrayList<Recipe>();
        this.friends = new ArrayList<User>();

    }

    public void update(String username, String photo, String password){
        this.setUsername(username);
        this.setPhoto(photo);
        this.setPassword(password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Recipe> getFavoritesRecipes() {
        return favoritesRecipes;
    }

    public void setFavoritesRecipes(List<Recipe> favoritesRecipes) {
        this.favoritesRecipes = favoritesRecipes;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void addFriends(User friend){
        this.friends.add(friend);
    }

    public void deleteFriends(User friend){
        this.friends.remove(friend);
    }

    public int getNbFriends(){
        return this.friends.size();
    }

    public void addFavoriteRecipe(Recipe recipe){
        this.favoritesRecipes.add(recipe);
    }

    public void deleteFavoriteRecipe(Recipe recipe){
        this.favoritesRecipes.remove(recipe);
    }

    public int getNbFavoriteRecipe(){
        return this.favoritesRecipes.size();
    }
}
