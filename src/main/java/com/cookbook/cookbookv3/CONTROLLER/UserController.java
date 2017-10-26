package com.cookbook.cookbookv3.CONTROLLER;


import com.cookbook.cookbookv3.MODEL.User;
import com.cookbook.cookbookv3.REPOSITORY.UserRepository;
import com.cookbook.cookbookv3.SERVICE.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> allUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/add/{un}/{em}/{ps}", method = RequestMethod.POST)
    public List<User> addUser(@PathVariable("un") String un,@PathVariable("em") String em,@PathVariable("ps") String ps){
        User u = new User(un,em,ps);
        userService.addUser(u);
        return this.allUser();
    }

    @RequestMapping(value = "/delete/{usN}", method = RequestMethod.POST)
    public List<User> deleteUser(@PathVariable("usN") String un){
        userService.deleteUser(un);
        return this.allUser();
    }

    @RequestMapping(value = "/findOne/{usN}", method = RequestMethod.POST)
    public User findUser(@PathVariable("usN") String un){
        return this.userService.findByUserName(un);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public List<User> loginUser(@RequestBody User un){
        if (this.userService.login(un)) {
            return this.allUser();
        }else {
            return null;
            }
        }


}
