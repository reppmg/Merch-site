package com.repp.service;

import com.repp.model.User;

import java.util.List;

/**
 * Created by 1 on 19.04.2017.
 */
public interface UsersService{

    List<User> findAll();


    User findById(Long id);
}
