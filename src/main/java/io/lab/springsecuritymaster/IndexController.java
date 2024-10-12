package io.lab.springsecuritymaster;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, MemberDto memberDto) throws ServletException {
        request.login(memberDto.getUsername(), memberDto.getPassword());
        System.out.println("login is successful");
        return "login successful";
    }

    @GetMapping("/users")
    public List<MemberDto> users(HttpServletRequest request, HttpServletResponse response, MemberDto memberDto) throws ServletException, IOException {
        boolean authenticate = request.authenticate(response);
        if (authenticate) return List.of(new MemberDto("user", "1111"));
        return Collections.emptyList();
    }

    @GetMapping("/")
    public Authentication index(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/db")
    public String db() {
        return "DB";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String secure() {
        return "user";
    }
}
