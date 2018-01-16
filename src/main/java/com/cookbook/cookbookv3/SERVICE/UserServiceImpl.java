package com.cookbook.cookbookv3.SERVICE;

import com.cookbook.cookbookv3.MODEL.Token;
import com.cookbook.cookbookv3.MODEL.User;
import com.cookbook.cookbookv3.REPOSITORY.RecipeRepository;
import com.cookbook.cookbookv3.REPOSITORY.TokenRepository;
import com.cookbook.cookbookv3.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    TokenRepository tokenRepository;

    public void addUser(User u){
        userRepository.save(u);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }


    public void deleteUser(String userName){

    }

    public User findByUserName(String userName){
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public User login(String username,String pass){
        User u = this.findByUserName(username);

        if(u == null){
            return u;
        } else if(!u.getPassword().equals(pass)){
            return u;
        } else
            return u;
    }

    public User findById(int id){
        return userRepository.findOne(id);
    }

    public User addFriend(int i, int o){
            User u = this.findById(i);
            u.addFriend(this.findById(o));
            userRepository.save(u);
            return u;
    }

    public User addRecipe(int i, int o){
        User u = this.findById(i);
        u.addRecipe(recipeRepository.findOne(o));
        userRepository.save(u);
        return u;
    }

    public void save(Token t){
        tokenRepository.save(t);
    }

}
