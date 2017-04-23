package com.repp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableOAuth2Sso
public class MerchApplication extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(MerchApplication.class);
    }


    public static void main(final String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(MerchApplication.class, args);


    }
}
