package com.repp.controller;

import com.repp.model.User;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1 on 20.04.2017.
 */
@RestController
@RequestMapping("/user")
public class UsersController {


    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return usersService.getList();
    }
}
