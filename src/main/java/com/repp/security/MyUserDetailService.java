package com.repp.security;

import com.repp.model.User;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 14.06.2017.
 */
//@Service
@Deprecated
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {


        final Long userId = Long.valueOf(username);
        final User userFromDB = usersService.findById(userId);
        if (userFromDB == null) throw new UsernameNotFoundException("Cannot find used with this id");

        final Set<GrantedAuthority> authorities = new HashSet<>();
        if (userFromDB.getRights() == 0)
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(username, "", authorities);
    }
}
