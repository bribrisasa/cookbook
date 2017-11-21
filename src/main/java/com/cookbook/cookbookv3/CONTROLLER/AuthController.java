package com.cookbook.cookbookv3.CONTROLLER;

import com.cookbook.cookbookv3.MODEL.User;
import com.cookbook.cookbookv3.SERVICE.UserServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class AuthController {
    @Autowired
    UserServiceImpl userService;


    @PostMapping("/auth")
    public String auth(@RequestHeader(value = "authorization") String authorization,
                       HttpServletResponse response) throws JSONException {
        System.out.println(authorization);
        String base64Tmp = authorization.split(" ")[1];
        String[] base64DecodeTmp = new String(Base64.getDecoder().decode(base64Tmp)).split(":");
        if (base64DecodeTmp.length == 2) {
            String username = base64DecodeTmp[0];
            String password = base64DecodeTmp[1];


            //récuperer tous les user et chercher si le user match a son mot de passe

            List<User> user = userService.findAll();
            //System.out.print(user.get(4).getUsername());
            for (User users : user) {
                if (users.getUsername().equals(username)
                        && users.getPassword().equals(password)) {
                    String token = UUID.randomUUID().toString();
                    //return token;

                    User usere = users;
                 /*   usere.setUserToken(UUID.randomUUID().toString());


                    JSONArray arr = new JSONArray();
                    HashMap<String, JSONObject> repos = new HashMap<>();
                    JSONObject json = new JSONObject();
                    json.put("username", usere.getUsername());
                    json.put("Gitoken", usere.getGithubToken());
                    json.put("UserToken", usere.getUserToken());
                    repos.put("json", json);
                    arr.put(repos.get("json"));
                    return arr.toString();

                }*/
                }
            }
        }
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return "lll";

    }
}
