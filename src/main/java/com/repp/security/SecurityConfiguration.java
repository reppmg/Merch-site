package com.repp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

/**
 * Created by 1 on 17.04.2017.
 */

@EnableOAuth2Sso
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Maksik").password("fthio").roles("USER");
        auth.inMemoryAuthentication().withUser("Odmen").password("ftsio").roles("ADMIN", "DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/good/**", "/login**", "/js/**", "/css/**", "/fonts/**").permitAll()
                .antMatchers(HttpMethod.GET,"/cup/**").permitAll()
                .anyRequest().authenticated()
                .antMatchers(HttpMethod.POST, "/cup/**").access("ROLE_ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().disable()/*
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())*/;
        http.headers().frameOptions().disable();
    }

//    @Bean
//    @ConfigurationProperties("facebook")
//    public ClientResources facebook() {
//        return new ClientResources();
//    }
//
//    private Filter ssoFilter() {
//        OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
//        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
//        facebookFilter.setRestTemplate(facebookTemplate);
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(), facebook().getClientId());
//        tokenServices.setRestTemplate(facebookTemplate);
//        facebookFilter.setTokenServices(tokenServices);
//        return facebookFilter;
//    }
}
