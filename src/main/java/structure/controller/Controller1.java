package structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import structure.dao.RoleDao;
import structure.model.Role;
import structure.model.User;
import structure.service.UserService;

import java.util.HashSet;
import java.util.Set;


@Controller
public class Controller1 {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleDao roleDao;

    UserService userService;

    @Autowired
    public Controller1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String viewsUsers(Model model){
        model.addAttribute("users", userService.listUsers());
        return "allUsers";
    }
    @GetMapping("user/{id}")
    public String getOneUser(@PathVariable("id")Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }
    @GetMapping("/admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
//    @PostMapping("/admin/new")
//    public String create(@ModelAttribute("user") User user){
//        System.out.println("зашёл в create");
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
    @PostMapping("/admin/new")
    public String create(@ModelAttribute("login") String login, @ModelAttribute("password") String password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(encoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(2L));
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/admin";
    }
    @GetMapping("admin/{id}/edit")
    public String edit(Model model, @PathVariable("id")Long id){
        System.out.println("зашёл в edit");
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }
    @PostMapping("admin/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id){
        System.out.println("Зашёл в UpDate");
        userService.upDate(id,user);
        return "redirect:/admin";
    }
    @GetMapping("admin/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        System.out.println("Зашёл в DELETE");
        userService.remove(id);
        return "redirect:/admin";
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
}

