package com.cookbook.cookbookv3.MODEL;

import javax.persistence.*;

@Entity
public class Token {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String token;
    private int user_id;
    private String token_type = "Bearer";
    private int ttl = 3600;

    public Token() {

    }

    public int getUser_id() {
        return user_id;
    }

    public int getTtl() {
        return ttl;
    }

    public String getToken() {
        return token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String toString(){
        return this.getToken();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}