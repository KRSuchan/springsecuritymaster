package io.lab.cors1;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
    public String index() {
        return "index";
    }
}