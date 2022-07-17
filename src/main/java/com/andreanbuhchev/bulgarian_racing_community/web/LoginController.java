package com.andreanbuhchev.bulgarian_racing_community.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //TODO SHOW ERRORS WHEN WRONG CREDENTIALS

}
