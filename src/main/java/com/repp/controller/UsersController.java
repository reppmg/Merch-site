package com.repp.controller;

import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 20.04.2017.
 */
@RestController
@RequestMapping("/user")
public class UsersController {


    @Autowired
    UsersService usersService;


//    @RequestMapping(method = RequestMethod.GET)
//    public List<User> getAllUsers() {
//        return usersService.findAll();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public Object user(Principal principal) {

        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        Map details = (Map) authentication.getUserAuthentication().getDetails();
        Map response = (Map) ((List) details.get("response")).get(0);
        response.put("authenticated", true);
        return response;

//        return principal;
    }
}
