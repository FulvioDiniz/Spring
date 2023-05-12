package com.example.site.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model, String nome) {
        model.addAttribute("nome", nome);
        return "home/index";
    }


    
}
