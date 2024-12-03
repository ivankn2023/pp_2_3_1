package web.controller;

import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String mainView(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        System.out.println(id);
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam int id, ModelMap model) {
        List<User> users = userService.listUsers();
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        model.addAttribute("user", user);
        return "editUserForm";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        System.out.println(user.getId());
        userService.editUser(user.getId(), user);
        return "redirect:/users/";
    }
}
