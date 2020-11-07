package structure.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @GetMapping("/privet")
    public String priv(){
        return "privet";
    }
    @GetMapping("/")
    public String defolt(){
        return "priv";
    }
}
