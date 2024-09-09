package io.lab.springsecuritymaster;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CustomRequestMatcher implements RequestMatcher {

    private final String urlPattern;

    public CustomRequestMatcher(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return request.getRequestURI().startsWith(urlPattern); // == ("urlPattern/**")
    }
}
