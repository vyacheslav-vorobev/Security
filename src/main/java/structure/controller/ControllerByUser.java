package structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import structure.service.UserService;

//@Controller
//public class ControllerByUser {
//    @Autowired
//    UserService userService;
//    @GetMapping("user/{login}")
//    public String getOneUser(@PathVariable("login")String login, Model model){
//        model.addAttribute("user", userService.findByUserName(login));
//        return "user";
//    }
//}
