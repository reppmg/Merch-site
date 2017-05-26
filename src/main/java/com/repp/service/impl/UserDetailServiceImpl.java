package com.repp.service.impl;

import com.repp.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by 1 on 25.05.2017.
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//        final UserDetails  userDetails = new User();
//        OAuthUser user = new OAuthUser()
        return null;
    }
}
