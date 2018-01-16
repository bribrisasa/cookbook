package com.cookbook.cookbookv3.CONTROLLER;


import com.cookbook.cookbookv3.MODEL.Recipe;
import com.cookbook.cookbookv3.MODEL.Token;
import com.cookbook.cookbookv3.MODEL.User;
import com.cookbook.cookbookv3.SERVICE.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @PostMapping("/auth")
    public String auth(@RequestHeader(value = "authorization") String authorization,
                       HttpServletResponse response) {
        String base64Tmp = authorization.split(" ")[1];
        String[] base64DecodeTmp = new String(Base64.getDecoder().decode(base64Tmp)).split(":");
        System.out.println("TEST");
        if (base64DecodeTmp.length == 2) {
            String username = base64DecodeTmp[0];
            String password = base64DecodeTmp[1];
            Iterable<User> users = userService.findAll();
            //List<Account> accounts = DataSingleton.getInstance().getAccounts();
            for (User us : users) {
                if (us.getUsername().equals(username)
                        && us.getPassword().equals(password)) {
                    Token token = new Token();
                    token.setToken(UUID.randomUUID().toString());
                    token.setUser_id(us.getId());
                    token.setTtl(3600);
                    //DataSingleton.getInstance().getTokens().add(token);
                    userService.save(token);
                    return token.toString();
                }
            }
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return "";
    }

    @GetMapping(value = "/profil/{id}")
    public User profil(@PathVariable Integer id){
        return this.userService.findById(id);
    }

    @PostMapping(value = "/add")
    public User addUser(@RequestBody User u){
        System.out.println("ok");
        userService.addUser(u);
        System.out.println("je suis la");
        return u;
    }

    @PostMapping(value = "/addFriends/{uo}/{uf}")
    public User addFriend(@PathVariable int uo, @PathVariable int uf){
        return userService.addFriend(uo,uf);
         //userService.findById(uo);
    }

    @PostMapping(value = "/addRecipe/{uo}/{uf}")
    public User addRecipe(@PathVariable int uo, @PathVariable int uf){
        return userService.addRecipe(uo,uf);
        //userService.findById(uo);
    }

    @GetMapping(value = "/all")
    public Iterable<User> allUser(){
        return userService.findAll();

    }

    @RequestMapping(value = "/delete/{usN}", method = RequestMethod.POST)
    public List<User> deleteUser(@PathVariable("usN") String un){
        userService.deleteUser(un);
        return null;
    }

    @RequestMapping(value = "/findOne/{usN}", method = RequestMethod.POST)
    public User findUser(@PathVariable("usN") String un){
        return this.userService.findByUserName(un);
    }

    @GetMapping(value = "/getId/{username}/{password}")
    public User loginUser(@PathVariable("username") String username, @PathVariable("password") String password){
     return this.userService.login(username,password);


        }

    @PostMapping(value = "/addFavorite")
    public void addFavoriteRecipe(@RequestBody Recipe recipe,@RequestBody User user){
      //  this.userService.addFavoriteRecipe(user,recipe);
    }

    @GetMapping(value = "/test")
    public Iterable<User> test(){
       return this.userService.findAll();
    }
}
