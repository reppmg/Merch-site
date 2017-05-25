package com.repp.controller;

import com.repp.model.User;
import com.repp.service.AddressService;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UsersController {


    @Autowired
    UsersService usersService;

    @Autowired
    AddressService addressService;

    @RequestMapping(method = RequestMethod.POST)
    public void registerUser(@RequestBody final User user){
        final Long id = user.getId();
        final User usedInDB = usersService.findById(id);

        if (usedInDB == null){
            //register
            user.setRights(1);
            addressService.addAddress(user.getAddress());
            usersService.save(user);
        } else {
            //update admin
            addressService.addAddress(user.getAddress());
            usersService.save(user);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public Object getUser(final Principal principal) {

        final OAuth2Authentication authentication = (OAuth2Authentication) principal;
        final Map details = (Map) authentication.getUserAuthentication().getDetails();
        final Map response = (Map) ((List) details.get("response")).get(0);
        response.put("authenticated", true);

        final Long id = Long.valueOf(response.get("uid").toString());
        final User user = usersService.findById(id);
        if (user == null) {
            response.put("registered", false);
        } else {
            response.put("phone", user.getPhone());
        }
        return response;

    }
}
