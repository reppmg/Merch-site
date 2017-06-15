package com.repp.security;

import com.repp.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Map;

/**
 * @author Denis.Repp
 */
public class CustomUserInfoTokenServices extends UserInfoTokenServices {
    @Autowired
    UsersRepository usersRepository;

    public CustomUserInfoTokenServices(String userInfoUri, String clientId) {
        super(userInfoUri,clientId);
        setAuthoritiesExtractor(authoritiesExtractor);
    }

    private AuthoritiesExtractor authoritiesExtractor = new AuthoritiesExtractor() {
        @Override
        public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
            usersRepository.findAll(); // TODO Implement database logic
            System.out.println("OLOLO");
            return null;
        }
    };
}
