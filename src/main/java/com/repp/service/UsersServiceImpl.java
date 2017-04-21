package com.repp.service;

import com.repp.dao.UsersRepository;
import com.repp.model.User;
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
    public List<User> getList() {
        return (List<User>) usersRepository.findAll();
    }
}
