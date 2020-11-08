package structure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class Controller0 {
    @GetMapping()
    public String start(){
        return "main";
    }
}
