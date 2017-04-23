package com.repp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 1 on 17.04.2017.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Maksik").password("fthio").roles("USER");
        auth.inMemoryAuthentication().withUser("Odmen").password("ftsio").roles("ADMIN", "DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                    .antMatchers("/", "/login**", "/css/**", "/images/**", "/js/**")
                    .permitAll()
                .anyRequest()
                    .authenticated();

//        http.authorizeRequests()
//                .antMatchers("/", "/good/**", "/cup/**").permitAll()
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .antMatchers("/h2-console/**").permitAll()
////                .antMatchers("/user/**", "/order/**").access("hasRole('ADMIN')")
//                .and().formLogin()
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
    }
}
