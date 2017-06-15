package com.repp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 1 on 03.06.2017.
 */
public class MyOauth2Filter extends OAuth2ClientContextFilter {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Value("${vk.client.redirectUri}")
    private String propsRedirectUri;

    @Override
    protected void redirectUser(
            final UserRedirectRequiredException e,
            final HttpServletRequest request,
            final HttpServletResponse response) throws IOException {
        super.redirectUser(e, request, response);
        final String redirectUri = e.getRedirectUri();
        final UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(redirectUri);
        final Map<String, String> requestParams = e.getRequestParams();
        for (final Map.Entry<String, String> param : requestParams.entrySet()) {
            builder.queryParam(param.getKey(), param.getValue());
        }

        if (e.getStateKey() != null) {
            builder.queryParam("state", e.getStateKey());
        }

        this.redirectStrategy.sendRedirect(request, response, builder.build()
                .encode().toUriString());
    }
}
