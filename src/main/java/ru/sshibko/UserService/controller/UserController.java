package ru.sshibko.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable Long id) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("/new")
    public String getUserCreateForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
