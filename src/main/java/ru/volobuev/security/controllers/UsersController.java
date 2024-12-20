package ru.volobuev.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volobuev.security.service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDetails user = userService.loadUserByUsername(username);
        if(user != null) {
            model.addAttribute("myInfo", user);
        }
        return "user/index";
    }
}