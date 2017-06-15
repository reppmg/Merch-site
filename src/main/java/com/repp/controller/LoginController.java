package com.repp.controller;

import com.repp.model.User;
import com.repp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * Should deal with login and registration
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public void getLogin(final Principal principal, final HttpServletResponse httpResponse){
        final OAuth2Authentication authentication = (OAuth2Authentication) principal;
        final Map details = (Map) authentication.getUserAuthentication().getDetails();
        final Map response = (Map) ((List) details.get("response")).get(0);

        final Long id = Long.valueOf(response.get("uid").toString());
        final User user = usersService.findById(id);
        if (user == null) {
            try {
                httpResponse.sendRedirect("registration.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping
    public void postLogin(final Principal principal, final HttpServletResponse httpResponse){
        final OAuth2Authentication authentication = (OAuth2Authentication) principal;
        final Map details = (Map) authentication.getUserAuthentication().getDetails();
        final Map response = (Map) ((List) details.get("response")).get(0);

        final Long id = Long.valueOf(response.get("uid").toString());
        final User user = usersService.findById(id);
        if (user == null) {
            try {
                httpResponse.sendRedirect("registration.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
