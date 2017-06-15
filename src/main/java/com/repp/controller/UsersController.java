package com.repp.controller;

import com.repp.model.User;
import com.repp.service.AddressService;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.PUT)
    public void endowAdminRight(final OAuth2Authentication authentication, @RequestBody final Long uid){
        if (usersService.checkAuthorities(Long.valueOf(((Map) ((List) ((Map) authentication.getUserAuthentication().getDetails()).get("response")).get(0)).get("uid").toString()))){
            final User user = usersService.findById(uid);
            user.setRights(0);
            usersService.save(user);
        }

    }

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
            if (user.getRights() == 0)
                response.put("isAdmin", true);
            else
                response.put("isAdmin", false);
            response.put("phone", user.getPhone());
            response.put("address", user.getAddress());
            response.put("email", user.getEmail());
            response.put("registered", true);
        }
        return response;

    }


}
