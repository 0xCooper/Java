package xyz.thewind.windpan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class IndexController {
    @RequestMapping("/ee")
    public String index(){
        return "index2";
    }
}
