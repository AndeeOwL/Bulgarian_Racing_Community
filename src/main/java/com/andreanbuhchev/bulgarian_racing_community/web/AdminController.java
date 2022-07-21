package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String allUsers(Model model) {


        List<UserEntity> users = userService.findAllUsers();

        model.addAttribute("allUsers", users);
        return "admin-panel";  //TODO EDIT METHOD NOT TO SHOW ADMINS
    }

    @GetMapping("/add/{id}")
    public String makeAdmin(@PathVariable Long id) {
        userService.addRoleToUser(id);
        return "redirect:/home";  //TODO METHOD NOT WORKING CORRECTLY
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return "redirect:/home";
    }
}
