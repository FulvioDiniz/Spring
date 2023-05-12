package com.example.site.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.site.models.Administrador;
import com.example.site.repositorio.AdministradorRepo;

@Controller
public class AdministradoresController {

    @Autowired
    private AdministradorRepo AdministradorRepo;

    @GetMapping("/administradores")
    public String index(Model model) {
        List<Administrador> lista = (List<Administrador>) AdministradorRepo.findAll();
        model.addAttribute("lista", lista);
        return "administradores/index";
    }

    @GetMapping("/administradores/novo")
    public String novo(Model model) {
        return "administradores/novo";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador) {
        AdministradorRepo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Administrador> lista = AdministradorRepo.findById(id);
        if(lista.isEmpty()) {
            throw new RuntimeException("Administrador não encontrado");
        } else {         
        model.addAttribute("administrador", lista.get());
        return "administradores/editar";
    }
        
    }

    @PostMapping("/administradores/atualizar")
    public String atualizar(Administrador administrador) {
        AdministradorRepo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/remover/{id}")
    public String remover(@PathVariable int id) {
        AdministradorRepo.deleteById(id);
        return "redirect:/administradores";
    }

}
