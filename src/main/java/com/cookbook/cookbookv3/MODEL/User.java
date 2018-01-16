package com.cookbook.cookbookv3.MODEL;


import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String username;
    private String photo;
    private String password;
    private String token;

    @OneToMany(targetEntity=User.class)
    private List<User> friends;

    @OneToMany(targetEntity=Recipe.class)
    private List<Recipe> favorite;



    public User(){}
    public User(String username, String photo, String password) {
        this.username = username;
        this.photo = photo;
        this.password = password;
        this.friends = new ArrayList<User>();
        this.favorite = new ArrayList<Recipe>();


    }

    public void update(String username, String photo, String password){
        this.setUsername(username);
        this.setPhoto(photo);
        this.setPassword(password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Recipe> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<Recipe> favorite) {
        this.favorite = favorite;
    }

    public void addFriend(User u){
        this.friends.add(u);
    }

    public void addRecipe(Recipe r){
        this.favorite.add(r);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
