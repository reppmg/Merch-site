package com.repp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.Filter;

/**
 * Created by 1 on 17.04.2017.
 */

@EnableOAuth2Client
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    public void configureGlobalSecurity(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication().withUser("Maksik").password("fthio").roles("USER");
//        auth.inMemoryAuthentication().withUser("Odmen").password("ftsio").roles("ADMIN", "DBA");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/good/**", "/login**", "/js/**", "/css/**", "/fonts/**").permitAll()
                .antMatchers(HttpMethod.GET,"/cup/**", "/shirt/**", "/about.html").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()

                .antMatchers(HttpMethod.POST, "/cup/**").access("hasRole(ROLE_ADMIN)")
//                .and().formLogin().successForwardUrl("/registration.html")
                .and().logout().logoutSuccessUrl("/").permitAll()
//                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)

        ;
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    public Filter ssoFilter() {
        final OAuth2ClientAuthenticationProcessingFilter vkFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/vk");
        final OAuth2RestTemplate vkTemplate = new OAuth2RestTemplate(vk(), oauth2ClientContext);
        vkFilter.setRestTemplate(vkTemplate);
        final UserInfoTokenServices tokenServices = new UserInfoTokenServices(vkResource().getUserInfoUri(), vk().getClientId());
        tokenServices.setRestTemplate(vkTemplate);
        vkFilter.setTokenServices(tokenServices);
        return vkFilter;
    }

    @Bean
    @ConfigurationProperties("vk.resource")
    public ResourceServerProperties vkResource() {
        return new ResourceServerProperties();
    }

    @Bean
    @ConfigurationProperties("vk.client")
    public AuthorizationCodeResourceDetails vk() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            final OAuth2ClientContextFilter filter) {
        final FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }
}
