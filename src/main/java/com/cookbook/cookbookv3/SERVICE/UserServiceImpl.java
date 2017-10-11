package com.cookbook.cookbookv3.SERVICE;

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
        return userRepository.findOne(userName);
    }

    public boolean login(String userName,String pass){
        User u = userRepository.findOne(userName);
        if(u == null){
            return false;
        } else if(u.getPassword() != pass){
            return false;
        } else
            return true;
    }
}
