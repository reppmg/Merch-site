package com.repp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class MerchApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(MerchApplication.class);
    }


    public static void main(final String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(MerchApplication.class, args);
        NamedParameterJdbcTemplate jdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
        System.out.println(jdbcTemplate);
//
//        Iterator<String> beanNamesIterator = ctx.getBeanFactory().getBeanNamesIterator();
//        System.out.println("BEANSS");
//        while (beanNamesIterator.hasNext()) {
//            System.out.println(beanNamesIterator.next());
//        }
    }
}
