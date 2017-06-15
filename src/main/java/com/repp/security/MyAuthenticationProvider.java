package com.repp.security;

import com.repp.service.UsersService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.inject.Inject;

/**
 * Created by 1 on 15.06.2017.
 */
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Inject
    UsersService usersService;

    private UserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("shot");
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
