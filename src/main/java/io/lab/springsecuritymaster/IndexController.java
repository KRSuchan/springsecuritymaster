package io.lab.springsecuritymaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    // test
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
