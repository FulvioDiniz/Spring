package com.example.site.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.example.site.models.Administrador;

public interface AdministradorRepo extends CrudRepository<Administrador, Integer> {
    
    
}
