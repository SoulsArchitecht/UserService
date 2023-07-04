package ru.sshibko.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sshibko.UserService.model.entity.User;
import ru.sshibko.UserService.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/userservice")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable Long id) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "userList";
    }
}
