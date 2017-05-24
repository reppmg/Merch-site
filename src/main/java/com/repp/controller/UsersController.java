package com.repp.controller;

import com.repp.model.User;
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


    @RequestMapping(method = RequestMethod.GET)
    public Object getUser(Principal principal) {

        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        Map details = (Map) authentication.getUserAuthentication().getDetails();
        Map response = (Map) ((List) details.get("response")).get(0);
        response.put("authenticated", true);

        Long id = Long.valueOf(response.get("uid").toString());
        User user = usersService.findById(id);
        if (user == null){
            response.put("registered", false);
        }
        return response;

    }
}
