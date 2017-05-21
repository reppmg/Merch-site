package com.repp.service.impl;

import com.repp.dao.UsersRepository;
import com.repp.model.User;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1 on 20.04.2017.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return usersRepository.findOne(id);
    }
}
