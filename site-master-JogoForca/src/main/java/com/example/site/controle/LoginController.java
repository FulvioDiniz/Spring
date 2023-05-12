package com.example.site.controle;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

import com.example.site.models.Login;
import com.example.site.repositorio.LoginRepo;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginRepo loginRepo;

    @GetMapping("/login")
    public String index() {
        return "login/login";
    }

    @GetMapping("/login/register")
    public String novo(Model model) {
        return "login/register";
    }

    @PostMapping("/login/criar")
    public String criar(Login user) {
        loginRepo.save(user);
        return "redirect:/login";
    }

    @PostMapping("/logar")
    public String logar(Model model, Login user, String lembrar, HttpServletResponse response) {
        Login usuario = this.loginRepo.logar(user.getEmail(), user.getSenha());
        if(usuario != null) {
            return "redirect:/?nome=" + usuario.getNome();
        } else {
            model.addAttribute("mensagem", "Usuário ou senha inválidos");
            return "login/login";
        }
    }
    
    





    // @GetMapping("/administradores/editar/{id}")
    // public String editar(@PathVariable int id, Model model) {
    //     Optional<Administrador> lista = loginRepo.findById(id);
    //     if(lista.isEmpty()) {
    //         throw new RuntimeException("Administrador não encontrado");
    //     } else {         
    //     model.addAttribute("administrador", lista.get());
    //     return "administradores/editar";
    // }
        
    // }

    // @PostMapping("/administradores/atualizar")
    // public String atualizar(Administrador administrador) {
    //     loginRepo.save(administrador);
    //     return "redirect:/administradores";
    // }

    // @GetMapping("/administradores/remover/{id}")
    // public String remover(@PathVariable int id) {
    //     loginRepo.deleteById(id);
    //     return "redirect:/administradores";
    // }

}
