package com.cookbook.cookbookv3.SERVICE;

import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.MODEL.User;
import com.cookbook.cookbookv3.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public void addUser(User u){
        userRepository.save(u);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(String userName){
        userRepository.delete(userName);
    }

    public User findByUserName(String userName){
        List<User> users = userRepository.findAll();
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

   /* @PreAuthorize("hasRole('USER')")
    @PostMapping("/login")
    public ResponseEntity login() {
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    public User findById(String id){
        return userRepository.findOne(id);
    }

    public void addFavoriteRecipe(User user, Recipe recipe) {

    }
}
