package com.core.service.repositories;

import com.core.service.entities.Profecionales;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfecionales extends CrudRepository<Profecionales, Integer> {
    Profecionales findByEmailcliente(String email);

    Profecionales findByEmailclienteAndPasswordAndActivado(String email, String password,String status);

    @Query(value = "SELECT nombrecliente FROM profecionales  WHERE idprofecional = ?1", nativeQuery = true)
    public String buscaPorIdSoloNombre(Integer id);
}
