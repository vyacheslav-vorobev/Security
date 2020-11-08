package structure.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import structure.dao.UserDao;
import structure.model.User;

@Controller
@RequestMapping("/users")
public class Controller1 {

    UserDao userDao;
    @Autowired
    public Controller1(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String viewsUsers(Model model){
        model.addAttribute("users", userDao.getAllUsers());
        return "allUsers";
    }
    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id")Long id, Model model){
        model.addAttribute("user", userDao.getUser(id));
        return "user";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userDao.saveUser(user);
        return "redirect:/users";
    }
}
