package com.example.site.repositorio;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.site.models.Login;

public interface LoginRepo extends CrudRepository<Login, Integer> {
    
    @Query(value = "SELECT * FROM users WHERE email_users = :email AND senha_users = :senha", nativeQuery = true)
    public Login logar(@Param("email") String email, @Param("senha") String senha);
    
    // @Query(value = "SELECT nome_users FROM users WHERE email_users = :email", nativeQuery = true)
    // public String getNome(@Param("nome_users") String nome);

    




    
    
}
