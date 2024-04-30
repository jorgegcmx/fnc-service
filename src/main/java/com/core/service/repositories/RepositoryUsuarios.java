package com.core.service.repositories;


import com.core.service.entities.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryUsuarios extends CrudRepository<Usuarios,Long> {
    Usuarios findByEmailAndContrasena(String email, String contrasena);
}
